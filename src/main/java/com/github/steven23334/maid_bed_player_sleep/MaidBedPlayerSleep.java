package com.github.steven23334.maid_bed_player_sleep;

import com.mojang.logging.LogUtils;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.slf4j.Logger;

@Mod(MaidBedPlayerSleep.MOD_ID)
public class MaidBedPlayerSleep {
    public static final String MOD_ID = "maid_bed_player_sleep";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final ModConfigSpec SERVER_CONFIG;
    public static final ModConfigSpec.DoubleValue SLEEP_COOLDOWN_SECONDS;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("女仆睡眠相关配置")
                .translation("maid_bed_player_sleep.configuration.sleep")
                .push("sleep");

        SLEEP_COOLDOWN_SECONDS = builder
                .comment("玩家叫醒女仆后，女仆无法重新入睡的时长（秒）")
                .translation("maid_bed_player_sleep.configuration.sleepCooldownSeconds")
                .defineInRange("sleepCooldownSeconds", 0.5, 0.0, 30.0);

        builder.pop();

        SERVER_CONFIG = builder.build();
    }

    public MaidBedPlayerSleep(ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        LOGGER.info("Maid Bed Player Sleep loaded.");
    }
}