package com.github.tartaricacid.netmusic;

import com.github.tartaricacid.netmusic.api.NetEaseMusic;
import com.github.tartaricacid.netmusic.api.WebApi;
import com.github.tartaricacid.netmusic.config.GeneralConfig;
import com.github.tartaricacid.netmusic.config.MusicListManage;
import com.github.tartaricacid.netmusic.init.*;
import com.github.tartaricacid.netmusic.inventory.CDBurnerMenu;
import com.github.tartaricacid.netmusic.inventory.ComputerMenu;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.resource.ResourceType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetMusic implements ModInitializer {
    public static final String MOD_ID = "netmusic";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static WebApi NET_EASE_WEB_API;

    public static final ScreenHandlerType<CDBurnerMenu> CD_BURNER_MENU_SCREEN_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "cd_burner"), CDBurnerMenu::new);
    public static final ScreenHandlerType<ComputerMenu> COMPUTER_MENU_SCREEN_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "computer"), ComputerMenu::new);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        NET_EASE_WEB_API = new NetEaseMusic().getApi();

        // 加载 resource 中的歌曲列表
        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new MusicListManage());

        InitBlocks.init();
        InitItems.init();
        InitBlockEntity.init();
        InitSounds.init();
        CommandRegistry.registryCommand();
        ReceiverRegistry.register();
        GeneralConfig.INSTANCE.load();
    }
}