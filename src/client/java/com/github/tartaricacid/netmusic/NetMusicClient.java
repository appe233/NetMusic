package com.github.tartaricacid.netmusic;

import com.github.tartaricacid.netmusic.init.CommonRegistry;
import com.github.tartaricacid.netmusic.init.InitRenderer;
import net.fabricmc.api.ClientModInitializer;

public class NetMusicClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CommonRegistry.register();
        InitRenderer.init();
    }
}