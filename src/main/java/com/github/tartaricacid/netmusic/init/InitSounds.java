package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.NetMusic;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/2
 */
public class InitSounds {

    public static final SoundEvent NET_MUSIC = SoundEvent.of(Identifier.of(NetMusic.MOD_ID, "net_music"));

    public static void init() {
        Registry.register(
                Registries.SOUND_EVENT,
                Identifier.of(NetMusic.MOD_ID, "net_music"),
                NET_MUSIC
        );
    }
}
