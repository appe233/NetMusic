package com.github.tartaricacid.netmusic.compat.tlm.client.gui;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.compat.tlm.inventory.MusicPlayerBackpackContainer;
import com.github.tartaricacid.touhoulittlemaid.client.gui.entity.maid.AbstractMaidContainerGui;
import com.github.tartaricacid.touhoulittlemaid.client.gui.entity.maid.backpack.IBackpackContainerScreen;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.anti_ad.mc.ipn.api.IPNButton;
import org.anti_ad.mc.ipn.api.IPNGuiHint;
import org.anti_ad.mc.ipn.api.IPNPlayerSideOnly;

@IPNPlayerSideOnly
@IPNGuiHint(button = IPNButton.SORT, horizontalOffset = -36, bottom = -12)
@IPNGuiHint(button = IPNButton.SORT_COLUMNS, horizontalOffset = -24, bottom = -24)
@IPNGuiHint(button = IPNButton.SORT_ROWS, horizontalOffset = -12, bottom = -36)
@IPNGuiHint(button = IPNButton.SHOW_EDITOR, horizontalOffset = -5)
@IPNGuiHint(button = IPNButton.SETTINGS, horizontalOffset = -5)
public class MusicPlayerBackpackContainerScreen extends AbstractMaidContainerGui<MusicPlayerBackpackContainer> implements IBackpackContainerScreen {
    private static final ResourceLocation BACKPACK = new ResourceLocation(NetMusic.MOD_ID, "textures/gui/maid_music_player.png");
    private final EntityMaid maid;

    public MusicPlayerBackpackContainerScreen(MusicPlayerBackpackContainer container, Inventory inv, Component titleIn) {
        super(container, inv, titleIn);
        this.imageHeight = 256;
        this.imageWidth = 256;
        this.maid = menu.getMaid();
    }

    @Override
    protected void init() {
        super.init();
        this.addRenderableWidget(new Button(this.leftPos + 142, this.topPos + 135, 15, 20,
                Component.literal("<"), b -> clickButton(0),
                (button, poseStack, mouseX, mouseY) -> renderTooltip(poseStack, Component.translatable("gui.netmusic.maid.music_player_backpack.previous"), mouseX, mouseY)));

        this.addRenderableWidget(new Button(this.leftPos + 235, this.topPos + 135, 15, 20,
                Component.literal(">"), b -> clickButton(1),
                (button, poseStack, mouseX, mouseY) -> renderTooltip(poseStack, Component.translatable("gui.netmusic.maid.music_player_backpack.next"), mouseX, mouseY)));

        this.addRenderableWidget(new Button(this.leftPos + 159, this.topPos + 135, 36, 20,
                Component.translatable("gui.netmusic.maid.music_player_backpack.stop"), b -> this.clickButton(2)));

        this.addRenderableWidget(new Button(this.leftPos + 197, this.topPos + 135, 36, 20,
                Component.translatable("gui.netmusic.maid.music_player_backpack.play"), b -> this.clickButton(3)));
    }

    private void clickButton(int id) {
        if (this.getMinecraft().gameMode != null) {
            this.getMinecraft().gameMode.handleInventoryButtonClick(this.menu.containerId, id);
        }
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTicks, int x, int y) {
        super.renderBg(poseStack, partialTicks, x, y);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BACKPACK);
        blit(poseStack, leftPos + 85, topPos + 36, 0, 0, 165, 128);
        int selectSlotId = this.menu.getSelectSlotId();
        int xIndex = selectSlotId % 6;
        int yIndex = selectSlotId / 6;
        blit(poseStack, leftPos + 142 + 18 * xIndex, topPos + 56 + 18 * yIndex, 165, 0, 18, 18);
    }
}