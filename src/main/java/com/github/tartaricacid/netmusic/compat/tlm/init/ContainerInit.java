package com.github.tartaricacid.netmusic.compat.tlm.init;

import com.github.tartaricacid.netmusic.compat.tlm.inventory.MusicPlayerBackpackContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.event.RegistryEvent;

public class ContainerInit {
    public static void init(RegistryEvent.Register<MenuType<?>> event) {
        event.getRegistry().register(MusicPlayerBackpackContainer.TYPE.setRegistryName("maid_music_player_backpack"));
    }
}
