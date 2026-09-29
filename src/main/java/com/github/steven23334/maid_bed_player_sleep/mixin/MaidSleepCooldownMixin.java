package com.github.steven23334.maid_bed_player_sleep.mixin;

import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.github.steven23334.maid_bed_player_sleep.MaidSleepCooldown;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityMaid.class)
public abstract class MaidSleepCooldownMixin {

    @Inject(method = "startSleeping", at = @At("HEAD"), cancellable = true, remap = false)
    private void maid_bed_player_sleep$blockSleepDuringCooldown(BlockPos pos, CallbackInfo ci) {
        EntityMaid maid = (EntityMaid) (Object) this;
        if (maid.level() instanceof ServerLevel serverLevel) {
            if (MaidSleepCooldown.isOnCooldown(maid.getUUID(), serverLevel.getGameTime())) {
                ci.cancel();
            }
        }
    }
}