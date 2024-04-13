package com.github.tartaricacid.netmusic.compat.tlm.backpack;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.compat.tlm.backpack.data.MusicPlayerBackpackData;
import com.github.tartaricacid.netmusic.compat.tlm.client.model.MusicPlayerBackpackModel;
import com.github.tartaricacid.netmusic.compat.tlm.inventory.MusicPlayerBackpackContainer;
import com.github.tartaricacid.netmusic.init.InitItems;
import com.github.tartaricacid.touhoulittlemaid.api.backpack.IBackpackData;
import com.github.tartaricacid.touhoulittlemaid.api.backpack.IMaidBackpack;
import com.github.tartaricacid.touhoulittlemaid.entity.item.EntityTombstone;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.github.tartaricacid.touhoulittlemaid.inventory.container.AbstractMaidContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class MusicPlayerBackpack extends IMaidBackpack {
    public static final ResourceLocation ID = new ResourceLocation(NetMusic.MOD_ID, "music_player_backpack");
    public static final ResourceLocation TEXTURE = new ResourceLocation(NetMusic.MOD_ID, "textures/entity/music_player_backpack.png");
    private static final int MAX_AVAILABLE = 30;

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public Item getItem() {
        return InitItems.MUSIC_PLAYER_BACKPACK.get();
    }

    @Override
    public void onPutOn(ItemStack itemStack, PlayerEntity player, EntityMaid entityMaid) {
    }

    @Override
    public void onTakeOff(ItemStack stack, PlayerEntity player, EntityMaid maid) {
        this.dropAllItems(maid);
    }

    @Override
    public void onSpawnTombstone(EntityMaid entityMaid, EntityTombstone entityTombstone) {
    }

    @Override
    public INamedContainerProvider getGuiProvider(final int entityId) {
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new StringTextComponent("Maid Music Player Container");
            }

            @Override
            public AbstractMaidContainer createMenu(int index, PlayerInventory playerInventory, PlayerEntity player) {
                return new MusicPlayerBackpackContainer(index, playerInventory, entityId);
            }
        };
    }

    @Override
    public boolean hasBackpackData() {
        return true;
    }

    @Nullable
    @Override
    public IBackpackData getBackpackData(EntityMaid maid) {
        return new MusicPlayerBackpackData();
    }

    @Override
    public int getAvailableMaxContainerIndex() {
        return MAX_AVAILABLE;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void offsetBackpackItem(MatrixStack poseStack) {
        poseStack.translate(0.0, 0.625, -0.05);
    }

    @Nullable
    @Override
    @OnlyIn(Dist.CLIENT)
    public EntityModel<EntityMaid> getBackpackModel() {
        return new MusicPlayerBackpackModel();
    }

    @Nullable
    @Override
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getBackpackTexture() {
        return TEXTURE;
    }
}
