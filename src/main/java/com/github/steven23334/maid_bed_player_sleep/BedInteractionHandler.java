package com.github.steven23334.maid_bed_player_sleep;

import com.github.tartaricacid.touhoulittlemaid.block.BlockMaidBed;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.List;
import java.util.Optional;

@EventBusSubscriber(modid = MaidBedPlayerSleep.MOD_ID)
public class BedInteractionHandler {

    @SubscribeEvent
    public static void onRightClickBed(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != InteractionHand.MAIN_HAND) return;
        if (event.getLevel().isClientSide()) return;

        Level level = event.getLevel();
        BlockState state = level.getBlockState(event.getPos());
        if (!(state.getBlock() instanceof BlockMaidBed)) return;

        Player player = event.getEntity();
        if (player.isShiftKeyDown()) return;

        BlockPos bedPos = event.getPos();
        if (state.hasProperty(BlockStateProperties.BED_PART)
                && state.getValue(BlockStateProperties.BED_PART) == BedPart.FOOT) {
            bedPos = bedPos.relative(state.getValue(BlockStateProperties.HORIZONTAL_FACING));
        }

        AABB searchBox = new AABB(bedPos).inflate(1.5);
        List<EntityMaid> maids = level.getEntitiesOfClass(EntityMaid.class, searchBox);

        for (EntityMaid maid : maids) {
            if (!maid.isSleeping()) continue;

            Optional<BlockPos> maidBedPos = maid.getSleepingPos();
            if (maidBedPos.isEmpty() || !maidBedPos.get().equals(bedPos)) continue;

            maid.stopSleeping();

            if (level instanceof ServerLevel serverLevel) {
                int cooldownTicks = (int) Math.round(
                        MaidBedPlayerSleep.SLEEP_COOLDOWN_SECONDS.get() * 20);
                MaidSleepCooldown.setCooldown(maid.getUUID(), serverLevel.getGameTime(), cooldownTicks);
            }

            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.SUCCESS);
            return;
        }

        player.startSleepInBed(bedPos);
        event.setCanceled(true);
        event.setCancellationResult(InteractionResult.SUCCESS);
    }
}