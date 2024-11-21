package com.github.tartaricacid.netmusic.model;

import com.github.tartaricacid.netmusic.NetMusic;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class ModelMusicPlayer<T extends Entity> extends EntityModel<T> {
    public static final EntityModelLayer LAYER = new EntityModelLayer(Identifier.of(NetMusic.MOD_ID, "main"), "musicplayer");
    private final ModelPart laba;
    private final ModelPart tube;
    private final ModelPart wheel;
    private final ModelPart ruler;
    private final ModelPart box;
    private final ModelPart disc;
    private final ModelPart getDiscBone;

    public ModelMusicPlayer(ModelPart root) {
        this.laba = root.getChild("laba");
        this.tube = root.getChild("tube");
        this.wheel = root.getChild("wheel");
        this.ruler = root.getChild("ruler");
        this.box = root.getChild("box");
        this.disc = root.getChild("disc");
        this.getDiscBone = root.getChild("getDiscBone");
    }

    public static TexturedModelData createBodyLayer() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();

        ModelPartData laba = partdefinition.addChild("laba", ModelPartBuilder.create().uv(6, 19).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 11.0F, 7.0F, -2.3562F, 0.0F, 0.0F));

        ModelPartData piece = laba.addChild("piece", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 13.0F, 0.0F));

        ModelPartData bone = piece.addChild("bone", ModelPartBuilder.create().uv(6, 11).cuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(10, 17).cuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(5, 24).cuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(0.0F, 0.0F, 7.1706F, 0.6479F, 0.0F, 0.0F));

        ModelPartData bone2 = bone.addChild("bone2", ModelPartBuilder.create().uv(12, 0).cuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, -0.245F));

        ModelPartData bone3 = bone.addChild("bone3", ModelPartBuilder.create().uv(12, 0).cuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, 0.245F));

        ModelPartData bone16 = bone.addChild("bone16", ModelPartBuilder.create().uv(5, 24).cuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.7854F));

        ModelPartData bone20 = bone.addChild("bone20", ModelPartBuilder.create().uv(5, 24).cuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.7854F));

        ModelPartData bone17 = bone.addChild("bone17", ModelPartBuilder.create().uv(5, 24).cuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone19 = bone.addChild("bone19", ModelPartBuilder.create().uv(5, 24).cuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.3927F));

        ModelPartData bone18 = bone.addChild("bone18", ModelPartBuilder.create(), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone5 = piece.addChild("bone5", ModelPartBuilder.create(), ModelTransform.of(0.0F, -6.3F, 2.3956F, 0.3066F, 0.0F, 0.0F));

        ModelPartData bone6 = bone5.addChild("bone6", ModelPartBuilder.create().uv(14, 0).cuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, -0.1244F));

        ModelPartData bone7 = bone5.addChild("bone7", ModelPartBuilder.create().uv(14, 0).cuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(-1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, 0.1244F));

        ModelPartData piece2 = laba.addChild("piece2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 13.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData bone4 = piece2.addChild("bone4", ModelPartBuilder.create().uv(6, 11).cuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(10, 17).cuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(5, 24).cuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(0.0F, 0.0F, 7.1706F, 0.6479F, 0.0F, 0.0F));

        ModelPartData bone8 = bone4.addChild("bone8", ModelPartBuilder.create().uv(12, 0).cuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, -0.245F));

        ModelPartData bone10 = bone4.addChild("bone10", ModelPartBuilder.create().uv(12, 0).cuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, 0.245F));

        ModelPartData bone11 = bone4.addChild("bone11", ModelPartBuilder.create().uv(5, 24).cuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.7854F));

        ModelPartData bone12 = bone4.addChild("bone12", ModelPartBuilder.create().uv(5, 24).cuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.7854F));

        ModelPartData bone13 = bone4.addChild("bone13", ModelPartBuilder.create().uv(5, 24).cuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone14 = bone4.addChild("bone14", ModelPartBuilder.create().uv(5, 24).cuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.3927F));

        ModelPartData bone15 = bone4.addChild("bone15", ModelPartBuilder.create(), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone21 = piece2.addChild("bone21", ModelPartBuilder.create(), ModelTransform.of(0.0F, -6.3F, 2.3956F, 0.3066F, 0.0F, 0.0F));

        ModelPartData bone22 = bone21.addChild("bone22", ModelPartBuilder.create().uv(14, 0).cuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, -0.1244F));

        ModelPartData bone23 = bone21.addChild("bone23", ModelPartBuilder.create().uv(14, 0).cuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(-1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, 0.1244F));

        ModelPartData piece3 = laba.addChild("piece3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 13.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData bone24 = piece3.addChild("bone24", ModelPartBuilder.create().uv(6, 11).cuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(10, 17).cuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(5, 24).cuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(0.0F, 0.0F, 7.1706F, 0.6479F, 0.0F, 0.0F));

        ModelPartData bone25 = bone24.addChild("bone25", ModelPartBuilder.create().uv(12, 0).cuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, -0.245F));

        ModelPartData bone26 = bone24.addChild("bone26", ModelPartBuilder.create().uv(12, 0).cuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, 0.245F));

        ModelPartData bone27 = bone24.addChild("bone27", ModelPartBuilder.create().uv(5, 24).cuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.7854F));

        ModelPartData bone28 = bone24.addChild("bone28", ModelPartBuilder.create().uv(5, 24).cuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.7854F));

        ModelPartData bone29 = bone24.addChild("bone29", ModelPartBuilder.create().uv(5, 24).cuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone30 = bone24.addChild("bone30", ModelPartBuilder.create().uv(5, 24).cuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.3927F));

        ModelPartData bone31 = bone24.addChild("bone31", ModelPartBuilder.create(), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone32 = piece3.addChild("bone32", ModelPartBuilder.create(), ModelTransform.of(0.0F, -6.3F, 2.3956F, 0.3066F, 0.0F, 0.0F));

        ModelPartData bone33 = bone32.addChild("bone33", ModelPartBuilder.create().uv(14, 0).cuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, -0.1244F));

        ModelPartData bone34 = bone32.addChild("bone34", ModelPartBuilder.create().uv(14, 0).cuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(-1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, 0.1244F));

        ModelPartData piece4 = laba.addChild("piece4", ModelPartBuilder.create(), ModelTransform.of(0.0F, 13.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

        ModelPartData bone35 = piece4.addChild("bone35", ModelPartBuilder.create().uv(6, 11).cuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(10, 17).cuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(5, 24).cuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(0.0F, 0.0F, 7.1706F, 0.6479F, 0.0F, 0.0F));

        ModelPartData bone36 = bone35.addChild("bone36", ModelPartBuilder.create().uv(12, 0).cuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, -0.245F));

        ModelPartData bone37 = bone35.addChild("bone37", ModelPartBuilder.create().uv(12, 0).cuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, 0.245F));

        ModelPartData bone38 = bone35.addChild("bone38", ModelPartBuilder.create().uv(5, 24).cuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.7854F));

        ModelPartData bone39 = bone35.addChild("bone39", ModelPartBuilder.create().uv(5, 24).cuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.7854F));

        ModelPartData bone40 = bone35.addChild("bone40", ModelPartBuilder.create().uv(5, 24).cuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone41 = bone35.addChild("bone41", ModelPartBuilder.create().uv(5, 24).cuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.3927F));

        ModelPartData bone42 = bone35.addChild("bone42", ModelPartBuilder.create(), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone43 = piece4.addChild("bone43", ModelPartBuilder.create(), ModelTransform.of(0.0F, -6.3F, 2.3956F, 0.3066F, 0.0F, 0.0F));

        ModelPartData bone44 = bone43.addChild("bone44", ModelPartBuilder.create().uv(14, 0).cuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, -0.1244F));

        ModelPartData bone45 = bone43.addChild("bone45", ModelPartBuilder.create().uv(14, 0).cuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(-1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, 0.1244F));

        ModelPartData piece5 = laba.addChild("piece5", ModelPartBuilder.create(), ModelTransform.of(0.0F, 13.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData bone46 = piece5.addChild("bone46", ModelPartBuilder.create().uv(6, 11).cuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(10, 17).cuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(5, 24).cuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(0.0F, 0.0F, 7.1706F, 0.6479F, 0.0F, 0.0F));

        ModelPartData bone47 = bone46.addChild("bone47", ModelPartBuilder.create().uv(12, 0).cuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, -0.245F));

        ModelPartData bone48 = bone46.addChild("bone48", ModelPartBuilder.create().uv(12, 0).cuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, 0.245F));

        ModelPartData bone49 = bone46.addChild("bone49", ModelPartBuilder.create().uv(5, 24).cuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.7854F));

        ModelPartData bone50 = bone46.addChild("bone50", ModelPartBuilder.create().uv(5, 24).cuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.7854F));

        ModelPartData bone51 = bone46.addChild("bone51", ModelPartBuilder.create().uv(5, 24).cuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone52 = bone46.addChild("bone52", ModelPartBuilder.create().uv(5, 24).cuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.3927F));

        ModelPartData bone53 = bone46.addChild("bone53", ModelPartBuilder.create(), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone54 = piece5.addChild("bone54", ModelPartBuilder.create(), ModelTransform.of(0.0F, -6.3F, 2.3956F, 0.3066F, 0.0F, 0.0F));

        ModelPartData bone55 = bone54.addChild("bone55", ModelPartBuilder.create().uv(14, 0).cuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, -0.1244F));

        ModelPartData bone56 = bone54.addChild("bone56", ModelPartBuilder.create().uv(14, 0).cuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(-1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, 0.1244F));

        ModelPartData piece6 = laba.addChild("piece6", ModelPartBuilder.create(), ModelTransform.of(0.0F, 13.0F, 0.0F, 0.0F, 2.3562F, 0.0F));

        ModelPartData bone57 = piece6.addChild("bone57", ModelPartBuilder.create().uv(6, 11).cuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(10, 17).cuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(5, 24).cuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(0.0F, 0.0F, 7.1706F, 0.6479F, 0.0F, 0.0F));

        ModelPartData bone58 = bone57.addChild("bone58", ModelPartBuilder.create().uv(12, 0).cuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, -0.245F));

        ModelPartData bone59 = bone57.addChild("bone59", ModelPartBuilder.create().uv(12, 0).cuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, 0.245F));

        ModelPartData bone60 = bone57.addChild("bone60", ModelPartBuilder.create().uv(5, 24).cuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.7854F));

        ModelPartData bone61 = bone57.addChild("bone61", ModelPartBuilder.create().uv(5, 24).cuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.7854F));

        ModelPartData bone62 = bone57.addChild("bone62", ModelPartBuilder.create().uv(5, 24).cuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone63 = bone57.addChild("bone63", ModelPartBuilder.create().uv(5, 24).cuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.3927F));

        ModelPartData bone64 = bone57.addChild("bone64", ModelPartBuilder.create(), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone65 = piece6.addChild("bone65", ModelPartBuilder.create(), ModelTransform.of(0.0F, -6.3F, 2.3956F, 0.3066F, 0.0F, 0.0F));

        ModelPartData bone66 = bone65.addChild("bone66", ModelPartBuilder.create().uv(14, 0).cuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, -0.1244F));

        ModelPartData bone67 = bone65.addChild("bone67", ModelPartBuilder.create().uv(14, 0).cuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(-1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, 0.1244F));

        ModelPartData piece7 = laba.addChild("piece7", ModelPartBuilder.create(), ModelTransform.of(0.0F, 13.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData bone68 = piece7.addChild("bone68", ModelPartBuilder.create().uv(6, 11).cuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(10, 17).cuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(5, 24).cuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(0.0F, 0.0F, 7.1706F, 0.6479F, 0.0F, 0.0F));

        ModelPartData bone69 = bone68.addChild("bone69", ModelPartBuilder.create().uv(12, 0).cuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, -0.245F));

        ModelPartData bone70 = bone68.addChild("bone70", ModelPartBuilder.create().uv(12, 0).cuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, 0.245F));

        ModelPartData bone71 = bone68.addChild("bone71", ModelPartBuilder.create().uv(5, 24).cuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.7854F));

        ModelPartData bone72 = bone68.addChild("bone72", ModelPartBuilder.create().uv(5, 24).cuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.7854F));

        ModelPartData bone73 = bone68.addChild("bone73", ModelPartBuilder.create().uv(5, 24).cuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone74 = bone68.addChild("bone74", ModelPartBuilder.create().uv(5, 24).cuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.3927F));

        ModelPartData bone75 = bone68.addChild("bone75", ModelPartBuilder.create(), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone76 = piece7.addChild("bone76", ModelPartBuilder.create(), ModelTransform.of(0.0F, -6.3F, 2.3956F, 0.3066F, 0.0F, 0.0F));

        ModelPartData bone77 = bone76.addChild("bone77", ModelPartBuilder.create().uv(14, 0).cuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, -0.1244F));

        ModelPartData bone78 = bone76.addChild("bone78", ModelPartBuilder.create().uv(14, 0).cuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(-1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, 0.1244F));

        ModelPartData piece8 = laba.addChild("piece8", ModelPartBuilder.create(), ModelTransform.of(0.0F, 13.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        ModelPartData bone79 = piece8.addChild("bone79", ModelPartBuilder.create().uv(6, 11).cuboid(-2.0F, -3.7575F, 0.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(10, 17).cuboid(-1.0F, -8.7575F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(5, 24).cuboid(-0.5F, 0.322F, -1.1959F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(0.0F, 0.0F, 7.1706F, 0.6479F, 0.0F, 0.0F));

        ModelPartData bone80 = bone79.addChild("bone80", ModelPartBuilder.create().uv(12, 0).cuboid(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, -0.245F));

        ModelPartData bone81 = bone79.addChild("bone81", ModelPartBuilder.create().uv(12, 0).cuboid(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.2425F, 0.0F, 0.0F, 0.0F, 0.245F));

        ModelPartData bone82 = bone79.addChild("bone82", ModelPartBuilder.create().uv(5, 24).cuboid(-1.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.7854F));

        ModelPartData bone83 = bone79.addChild("bone83", ModelPartBuilder.create().uv(5, 24).cuboid(0.1968F, -1.1969F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.7854F));

        ModelPartData bone84 = bone79.addChild("bone84", ModelPartBuilder.create().uv(5, 24).cuboid(-2.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone85 = bone79.addChild("bone85", ModelPartBuilder.create().uv(5, 24).cuboid(1.4845F, -0.6636F, -1.1969F, 1.0F, 1.0F, 1.0F, new Dilation(0.1969F)), ModelTransform.of(-2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, 0.3927F));

        ModelPartData bone86 = bone79.addChild("bone86", ModelPartBuilder.create(), ModelTransform.of(2.9701F, 0.0F, 0.001F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone87 = piece8.addChild("bone87", ModelPartBuilder.create(), ModelTransform.of(0.0F, -6.3F, 2.3956F, 0.3066F, 0.0F, 0.0F));

        ModelPartData bone88 = bone87.addChild("bone88", ModelPartBuilder.create().uv(14, 0).cuboid(-0.9923F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.7923F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.7323F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.6823F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, -0.1244F));

        ModelPartData bone89 = bone87.addChild("bone89", ModelPartBuilder.create().uv(14, 0).cuboid(-0.0077F, -4.124F, -2.4152F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-0.2077F, -5.924F, -3.2142F, 1.0F, 2.0F, 1.0F, new Dilation(-0.2F))
                .uv(10, 22).cuboid(-0.2677F, -6.464F, -3.1542F, 1.0F, 1.0F, 1.0F, new Dilation(-0.26F))
                .uv(6, 22).cuboid(-0.3177F, -6.894F, -3.1042F, 1.0F, 1.0F, 1.0F, new Dilation(-0.31F)), ModelTransform.of(-1.0F, 0.124F, 2.4152F, 0.0F, 0.0F, 0.1244F));

        ModelPartData tube = partdefinition.addChild("tube", ModelPartBuilder.create().uv(6, 19).cuboid(-1.25F, -12.4297F, 5.2362F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 17).cuboid(0.7637F, -9.416F, 5.2362F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(5.7773F, -9.416F, 0.2226F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(9, 24).cuboid(3.7637F, -9.416F, -1.7911F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.75F, 24.0F, 1.5F));

        ModelPartData bone90 = tube.addChild("bone90", ModelPartBuilder.create().uv(10, 27).cuboid(-0.5F, -0.6533F, -0.2706F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, -12.8536F, 5.3536F, -1.1781F, 0.0F, 0.0F));

        ModelPartData bone97 = tube.addChild("bone97", ModelPartBuilder.create().uv(0, 25).cuboid(-0.7294F, -0.5F, -0.3467F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.2773F, -8.916F, -0.2774F, 0.0F, 0.3927F, 0.0F));

        ModelPartData bone98 = tube.addChild("bone98", ModelPartBuilder.create().uv(0, 25).cuboid(-0.6173F, -0.5F, -1.2168F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.2773F, -8.916F, -0.2774F, 0.0F, 0.7854F, 0.0F));

        ModelPartData bone99 = tube.addChild("bone99", ModelPartBuilder.create().uv(0, 25).cuboid(-0.1808F, -0.5F, -1.9777F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.2773F, -8.916F, -0.2774F, 0.0F, 1.1781F, 0.0F));

        ModelPartData bone94 = tube.addChild("bone94", ModelPartBuilder.create().uv(7, 26).cuboid(1.1945F, -0.5F, 0.036F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.2637F, -8.916F, 5.7362F, 0.0F, 0.3927F, 0.0F));

        ModelPartData bone95 = tube.addChild("bone95", ModelPartBuilder.create().uv(7, 26).cuboid(1.631F, -0.5F, 0.7969F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.2637F, -8.916F, 5.7362F, 0.0F, 0.7854F, 0.0F));

        ModelPartData bone96 = tube.addChild("bone96", ModelPartBuilder.create().uv(3, 26).cuboid(1.7431F, -0.5F, 1.667F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.2637F, -8.916F, 5.7362F, 0.0F, 1.1781F, 0.0F));

        ModelPartData bone91 = tube.addChild("bone91", ModelPartBuilder.create().uv(0, 27).cuboid(-0.2706F, -0.6533F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, -9.9297F, 5.7362F, 0.0F, 0.0F, -0.3927F));

        ModelPartData bone92 = tube.addChild("bone92", ModelPartBuilder.create().uv(0, 27).cuboid(-0.3827F, 0.2168F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, -9.9297F, 5.7362F, 0.0F, 0.0F, -0.7854F));

        ModelPartData bone93 = tube.addChild("bone93", ModelPartBuilder.create().uv(0, 27).cuboid(-0.8192F, 0.9777F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, -9.9297F, 5.7362F, 0.0F, 0.0F, -1.1781F));

        ModelPartData wheel = partdefinition.addChild("wheel", ModelPartBuilder.create().uv(12, 8).cuboid(-1.3536F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1464F)), ModelTransform.pivot(5.0137F, 15.084F, 0.2089F));

        ModelPartData bone9 = wheel.addChild("bone9", ModelPartBuilder.create().uv(12, 8).cuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1464F)), ModelTransform.of(-0.8536F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData bone100 = wheel.addChild("bone100", ModelPartBuilder.create().uv(12, 8).cuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1464F)), ModelTransform.of(-0.8536F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        ModelPartData bone101 = wheel.addChild("bone101", ModelPartBuilder.create().uv(12, 8).cuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1464F)), ModelTransform.of(-0.8536F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

        ModelPartData ruler = partdefinition.addChild("ruler", ModelPartBuilder.create().uv(0, 19).cuboid(-1.0F, -12.0F, 7.0F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData box = partdefinition.addChild("box", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-8.0F, -1.75F, -8.0F, 16.0F, 1.0F, 16.0F, new Dilation(-0.25F))
                .uv(0, 0).cuboid(-8.0F, -6.25F, -8.0F, 16.0F, 1.0F, 16.0F, new Dilation(-0.25F))
                .uv(0, 0).cuboid(-8.0F, -7.0F, -8.0F, 16.0F, 1.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData bone102 = box.addChild("bone102", ModelPartBuilder.create().uv(0, 0).cuboid(4.0F, -5.5F, 5.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-8.0F, -5.5F, 5.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-8.0F, -5.5F, -7.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(4.0F, -5.5F, -7.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 17).cuboid(-7.5F, -5.5F, -6.5F, 14.0F, 4.0F, 14.0F, new Dilation(0.0F))
                .uv(0, 7).cuboid(-3.0F, -5.0F, -7.0F, 5.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, 0.0F, -0.5F));

        ModelPartData disc = partdefinition.addChild("disc", ModelPartBuilder.create().uv(0, 35).cuboid(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 10.0F, new Dilation(-0.0068F))
                .uv(12, 40).cuboid(-6.5F, -6.501F, -6.5F, 13.0F, 11.0F, 13.0F, new Dilation(-5.5F)), ModelTransform.pivot(0.0F, 17.0F, 0.0F));

        ModelPartData bone103 = disc.addChild("bone103", ModelPartBuilder.create().uv(0, 35).cuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, new Dilation(-0.0068F)), ModelTransform.of(0.0F, 7.0F, 0.0F, 0.0F, -0.3927F, 0.0F));

        ModelPartData bone104 = disc.addChild("bone104", ModelPartBuilder.create().uv(0, 35).cuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, new Dilation(-0.0068F)), ModelTransform.of(0.0F, 7.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData bone105 = disc.addChild("bone105", ModelPartBuilder.create().uv(0, 35).cuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, new Dilation(-0.0068F)), ModelTransform.of(0.0F, 7.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

        ModelPartData bone106 = disc.addChild("bone106", ModelPartBuilder.create().uv(0, 35).cuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, new Dilation(-0.0068F)), ModelTransform.of(0.0F, 7.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData bone107 = disc.addChild("bone107", ModelPartBuilder.create().uv(0, 35).cuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, new Dilation(-0.0068F)), ModelTransform.of(0.0F, 7.0F, 0.0F, 0.0F, -1.9635F, 0.0F));

        ModelPartData bone108 = disc.addChild("bone108", ModelPartBuilder.create().uv(0, 35).cuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, new Dilation(-0.0068F)), ModelTransform.of(0.0F, 7.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

        ModelPartData bone109 = disc.addChild("bone109", ModelPartBuilder.create().uv(0, 35).cuboid(-1.0F, -8.0F, -5.0F, 2.0F, 1.0F, 10.0F, new Dilation(-0.0068F)), ModelTransform.of(0.0F, 7.0F, 0.0F, 0.0F, -2.7489F, 0.0F));

        ModelPartData huahen = disc.addChild("huahen", ModelPartBuilder.create().uv(0, 47).cuboid(-2.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1022F))
                .uv(0, 47).cuboid(1.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1022F))
                .uv(0, 52).cuboid(-4.2043F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2044F))
                .uv(0, 52).cuboid(3.2043F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2044F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData bone110 = huahen.addChild("bone110", ModelPartBuilder.create().uv(0, 47).cuboid(-2.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1022F))
                .uv(0, 47).cuboid(1.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1022F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));

        ModelPartData bone111 = huahen.addChild("bone111", ModelPartBuilder.create().uv(0, 47).cuboid(-2.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1022F))
                .uv(0, 47).cuboid(1.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1022F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData bone112 = huahen.addChild("bone112", ModelPartBuilder.create().uv(0, 47).cuboid(-2.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1022F))
                .uv(0, 47).cuboid(1.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1022F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

        ModelPartData bone113 = huahen.addChild("bone113", ModelPartBuilder.create().uv(0, 47).cuboid(-2.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1022F))
                .uv(0, 47).cuboid(1.1022F, -8.1032F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(-0.1022F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData bone114 = huahen.addChild("bone114", ModelPartBuilder.create().uv(0, 52).cuboid(-4.2043F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2044F))
                .uv(0, 52).cuboid(3.2044F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2044F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));

        ModelPartData bone115 = huahen.addChild("bone115", ModelPartBuilder.create().uv(0, 52).cuboid(-4.2043F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2044F))
                .uv(0, 52).cuboid(3.2044F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2044F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        ModelPartData bone116 = huahen.addChild("bone116", ModelPartBuilder.create().uv(0, 52).cuboid(-4.2043F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2044F))
                .uv(0, 52).cuboid(3.2044F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2044F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

        ModelPartData bone117 = huahen.addChild("bone117", ModelPartBuilder.create().uv(0, 52).cuboid(-4.2043F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2044F))
                .uv(0, 52).cuboid(3.2044F, -8.2053F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(-0.2044F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData getDiscBone = partdefinition.addChild("getDiscBone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        return TexturedModelData.of(meshdefinition, 64, 64);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        laba.render(matrices, vertices, light, overlay, color);
        tube.render(matrices, vertices, light, overlay, color);
        wheel.render(matrices, vertices, light, overlay, color);
        ruler.render(matrices, vertices, light, overlay, color);
        box.render(matrices, vertices, light, overlay, color);
        disc.render(matrices, vertices, light, overlay, color);
        getDiscBone.render(matrices, vertices, light, overlay, color);
    }

    public ModelPart getDiscBone() {
        return disc;
    }
}
