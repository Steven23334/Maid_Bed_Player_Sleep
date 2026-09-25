package com.github.steven23334.maid_bed_player_sleep;

import com.mojang.logging.LogUtils;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(MaidBedPlayerSleep.MOD_ID)
public class MaidBedPlayerSleep {
    public static final String MOD_ID = "maid_bed_player_sleep";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MaidBedPlayerSleep() {
        LOGGER.info("Maid Bed Player Sleep loaded.");
    }
}