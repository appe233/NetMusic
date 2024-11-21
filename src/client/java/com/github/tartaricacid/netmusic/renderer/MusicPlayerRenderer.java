package com.github.tartaricacid.netmusic.renderer;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.math.Axis;
import com.github.tartaricacid.netmusic.model.ModelMusicPlayer;
import com.github.tartaricacid.netmusic.tileentity.TileEntityMusicPlayer;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class MusicPlayerRenderer implements BlockEntityRenderer<TileEntityMusicPlayer> {
    public static ModelMusicPlayer<?> MODEL;
    public static final Identifier TEXTURE = Identifier.of(NetMusic.MOD_ID, "textures/block/music_player.png");
    public static MusicPlayerRenderer instance;

    public MusicPlayerRenderer(BlockEntityRendererFactory.Context ctx) {
        MODEL = new ModelMusicPlayer<>(ctx.getLayerModelPart(ModelMusicPlayer.LAYER));
        instance = this;
    }

    @Override
    public void render(TileEntityMusicPlayer entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Direction facing = entity.getCachedState().get(HorizontalFacingBlock.FACING);
        ItemStack cd = entity.getStack(0);
        ModelPart disc = MODEL.getDiscBone();
        disc.visible = !entity.isEmpty();
        if (!entity.isEmpty() && entity.isPlay()) {
            disc.yaw = (float) ((2 * Math.PI / 40) * ((System.currentTimeMillis() / 50) % 40));
        }
        renderMusicPlayer(matrices, vertexConsumers, light, facing);
    }

    public void renderMusicPlayer(MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int combinedLight, Direction facing) {
        matrixStack.push();
        matrixStack.scale(0.75f, 0.75f, 0.75f);
        matrixStack.translate(0.5 / 0.75, 1.5, 0.5 / 0.75);
        switch (facing) {
            case NORTH:
            default:
                break;
            case SOUTH:
                matrixStack.multiply(Axis.YP.rotationDegrees(180));
                break;
            case EAST:
                matrixStack.multiply(Axis.YP.rotationDegrees(270));
                break;
            case WEST:
                matrixStack.multiply(Axis.YP.rotationDegrees(90));
                break;
        }
        matrixStack.multiply(Axis.ZP.rotationDegrees(180));
        VertexConsumer buffer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE));
        MODEL.render(matrixStack, buffer, combinedLight, OverlayTexture.DEFAULT_UV, 0xffffffff);
        matrixStack.pop();
    }
}
