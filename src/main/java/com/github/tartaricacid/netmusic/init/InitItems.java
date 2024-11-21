package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.config.MusicListManage;
import com.github.tartaricacid.netmusic.item.ItemMusicCD;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/2
 */
public class InitItems {

    public static Item MUSIC_CD = register(new ItemMusicCD(new Item.Settings()), "music_cd");

    public static Item MUSIC_PLAYER = register(new BlockItem(InitBlocks.MUSIC_PLAYER, new FabricItemSettings()), "music_player");

    public static Item CD_BURNER = register(new BlockItem(InitBlocks.CD_BURNER, new FabricItemSettings()), "cd_burner");

    public static Item COMPUTER = register(new BlockItem(InitBlocks.COMPUTER, new FabricItemSettings()), "computer");

    public static Item register(Item item, String id) {
        Identifier itemId = Identifier.of(NetMusic.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemId, item);
    }

    public static final ItemGroup NET_MUSIC_TAB = Registry.register(Registries.ITEM_GROUP, new Identifier(NetMusic.MOD_ID, "netmusic_group"), FabricItemGroup.builder()
            .icon(() -> new ItemStack(InitBlocks.MUSIC_PLAYER))
            .displayName(Text.translatable("itemGroup.netmusic"))
            .entries((displayContext, entries) -> {
                entries.add(new ItemStack(MUSIC_PLAYER));
                entries.add(new ItemStack(CD_BURNER));
                entries.add(new ItemStack(COMPUTER));
                entries.add(new ItemStack(InitItems.MUSIC_CD));
                for (ItemMusicCD.SongInfo info : MusicListManage.SONGS) {
                    ItemStack stack = new ItemStack(MUSIC_CD);
                    ItemMusicCD.setSongInfo(info, stack);
                    entries.add(stack);
                }
            }).build());

    public static void init() {
    }
}
