package com.github.steven23334.maid_bed_player_sleep;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = MaidBedPlayerSleep.MOD_ID, dist = Dist.CLIENT)
public class MaidBedPlayerSleepClient {
    public MaidBedPlayerSleepClient(ModContainer modContainer) {
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}