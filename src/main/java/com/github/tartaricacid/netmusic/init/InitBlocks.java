package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.block.BlockCDBurner;
import com.github.tartaricacid.netmusic.block.BlockComputer;
import com.github.tartaricacid.netmusic.block.BlockMusicPlayer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class InitBlocks {
    public static final Block MUSIC_PLAYER = register("music_player", new BlockMusicPlayer(FabricBlockSettings.create().strength(4.0f)));
    public static final Block CD_BURNER = register("cd_burner", new BlockCDBurner(FabricBlockSettings.create().strength(4.0f)));
    public static final Block COMPUTER = register("computer", new BlockComputer(FabricBlockSettings.create().strength(4.0f)));

    private static <T extends Block> T register(String name, T block) {
        Registry.register(Registries.BLOCK, new Identifier(NetMusic.MOD_ID, name), block);
        return block;
    }

    public static void init() {
    }
}
