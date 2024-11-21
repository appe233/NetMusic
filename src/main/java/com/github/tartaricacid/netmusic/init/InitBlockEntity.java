package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.tileentity.TileEntityMusicPlayer;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class InitBlockEntity {

    public static final BlockEntityType<TileEntityMusicPlayer> MUSIC_PLAYER_TE = register(
            "music_player",
            TileEntityMusicPlayer.TYPE
    );

    public static final <T extends BlockEntityType<?>> T register(String name, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(NetMusic.MOD_ID, name), blockEntityType);
    }

    public static void init() {
    }
}
