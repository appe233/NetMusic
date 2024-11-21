package com.github.tartaricacid.netmusic.inventory;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.init.InitItems;
import com.github.tartaricacid.netmusic.item.ItemMusicCD;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

/**
 * @author : IMG
 * @create : 2024/10/11
 */
public class ComputerMenu extends ScreenHandler {
    public final Slot input = new Slot(new SimpleInventory(1), 0, 147, 14) {
        @Override
        public boolean canInsert(ItemStack stack) {
            return stack.getItem() == InitItems.MUSIC_CD;
        }
    };

    public final Slot output = new Slot(new SimpleInventory(1), 0, 147, 79) {
        @Override
        public boolean canInsert(ItemStack stack) {
            return false;
        }

        @Override
        public int getMaxItemCount() {
            return 1;
        }
    };

    private ItemMusicCD.SongInfo songInfo;

    public ComputerMenu(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(NetMusic.COMPUTER_MENU_SCREEN_HANDLER_TYPE, syncId);
    }

    public ComputerMenu(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, null);

        this.addSlot(input);
        this.addSlot(output);

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(inventory, i, 8 + i * 18, 192));
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 134 + i * 18));
            }
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slotByIndex = this.slots.get(slot);
        if (slotByIndex != null && slotByIndex.hasStack()) {
            ItemStack slotItem = slotByIndex.getStack();
            itemStack = slotItem.copy();
            if (slot < 2) {
                if (!this.insertItem(slotItem, 2, this.slots.size(), false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(slotItem, 0, 2, true)) {
                return ItemStack.EMPTY;
            }

            if (slotItem.isEmpty()) {
                slotByIndex.setStack(ItemStack.EMPTY);
            } else {
                slotByIndex.markDirty();
            }
        }
        return itemStack;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        giveItemToPlayer(player, input.getStack(), 0);
        giveItemToPlayer(player, output.getStack(), 1);
    }

    private static void giveItemToPlayer(PlayerEntity player, ItemStack stack, int preferredSlot) {
        if (!stack.isEmpty()) {
            if (!player.getInventory().insertStack(stack)) {
                player.dropItem(stack, false);
            }
        }
    }

    public void setSongInfo(ItemMusicCD.SongInfo songInfo) {
        this.songInfo = songInfo;
        if (!input.getStack().isEmpty() && output.getStack().isEmpty()) {
            ItemStack itemStack = this.input.getStack().copyWithCount(1);
            this.input.getStack().decrement(1);
            ItemMusicCD.SongInfo rawSongInfo = ItemMusicCD.getSongInfo(itemStack);
            if (rawSongInfo == null || !rawSongInfo.readOnly) {
                ItemMusicCD.setSongInfo(this.songInfo, itemStack);
            }
            this.output.setStack(itemStack);
        }
    }

    public Slot getInput() {
        return input;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
