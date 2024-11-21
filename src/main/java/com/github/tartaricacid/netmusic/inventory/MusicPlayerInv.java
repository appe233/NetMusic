package com.github.tartaricacid.netmusic.inventory;

import com.github.tartaricacid.netmusic.init.InitItems;
import net.minecraft.item.ItemStack;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public interface MusicPlayerInv extends ImplementedInventory {

    @Override
    default boolean isValid(int slot, ItemStack stack) {
        return stack.getItem() == InitItems.MUSIC_CD && getItems().get(0).getCount() < size();
    }
}
