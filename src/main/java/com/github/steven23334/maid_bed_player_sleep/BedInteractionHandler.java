package com.github.steven23334.maid_bed_player_sleep;

import com.github.tartaricacid.touhoulittlemaid.block.BlockMaidBed;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = MaidBedPlayerSleep.MOD_ID)
public class BedInteractionHandler {

    @SubscribeEvent
    public static void onRightClickBed(PlayerInteractEvent.RightClickBlock event) {
        // 只在服务端处理，避免客户端重复触发
        if (event.getLevel().isClientSide()) return;

        BlockState state = event.getLevel().getBlockState(event.getPos());
        if (!(state.getBlock() instanceof BlockMaidBed)) return;

        Player player = event.getEntity();

        // 潜行时保留原版/其他交互
        if (player.isShiftKeyDown()) return;

        // 确定床头位置：如果点击的是床尾，则找到床头
        BlockPos bedPos = event.getPos();
        if (state.hasProperty(BlockStateProperties.BED_PART)
                && state.getValue(BlockStateProperties.BED_PART) == BedPart.FOOT) {
            bedPos = bedPos.relative(state.getValue(BlockStateProperties.HORIZONTAL_FACING));
        }

        // 调用原版睡眠流程
        player.startSleepInBed(bedPos);

        // 取消原事件，阻止 BlockMaidBed 自己的 useWithoutItem 执行
        event.setCanceled(true);
        event.setCancellationResult(InteractionResult.SUCCESS);
    }
}