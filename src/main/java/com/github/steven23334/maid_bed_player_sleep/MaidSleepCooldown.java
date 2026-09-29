package com.github.steven23334.maid_bed_player_sleep;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MaidSleepCooldown {

    private static final Map<UUID, Long> COOLDOWN_END = new HashMap<>();

    /** 设置女仆禁睡截止时间 */
    public static void setCooldown(UUID maidId, long currentTick, int durationTicks) {
        COOLDOWN_END.put(maidId, currentTick + durationTicks);
    }

    /** 女仆当前是否处于禁睡期 */
    public static boolean isOnCooldown(UUID maidId, long currentTick) {
        Long end = COOLDOWN_END.get(maidId);
        if (end == null) return false;
        if (currentTick >= end) {
            COOLDOWN_END.remove(maidId);
            return false;
        }
        return true;
    }
}