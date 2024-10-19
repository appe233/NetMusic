package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.item.ItemMusicCD;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/18
 */
public class InitDataComponent {
    public static final ComponentType<ItemMusicCD.SongInfo> SONG_INFO = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(NetMusic.MOD_ID, "song_info"),
            ComponentType.<ItemMusicCD.SongInfo>builder()
                    .codec(ItemMusicCD.SongInfo.CODEC)
                    .packetCodec(ItemMusicCD.SongInfo.STREAM_CODEC)
                    .build()
    );

    public static void init() {
    }
}
