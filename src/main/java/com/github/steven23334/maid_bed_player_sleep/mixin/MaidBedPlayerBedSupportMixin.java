package com.github.steven23334.maid_bed_player_sleep.mixin;

import com.github.tartaricacid.touhoulittlemaid.block.BlockMaidBed;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockMaidBed.class)
public abstract class MaidBedPlayerBedSupportMixin {

    @Inject(method = "isBed", at = @At("RETURN"), cancellable = true, remap = false)
    private void maid_bed_player_sleep$allowPlayerSleep(BlockState state, BlockGetter level, BlockPos pos,
                                                        LivingEntity entity,
                                                        CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof Player && !cir.getReturnValue()) {
            cir.setReturnValue(true);
        }
    }
}