package com.github.tartaricacid.netmusic.compat.tlm.client.model;

import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MusicPlayerBackpackModel extends EntityModel<EntityMaid> {
    private final ModelRenderer main;
    private final ModelRenderer bone466;
    private final ModelRenderer bone36;
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer bone22;
    private final ModelRenderer bone23;
    private final ModelRenderer bone30;
    private final ModelRenderer bone31;
    private final ModelRenderer bone24;
    private final ModelRenderer bone25;
    private final ModelRenderer bone26;
    private final ModelRenderer bone27;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;

    public MusicPlayerBackpackModel() {
        texWidth = 256;
        texHeight = 256;

        main = new ModelRenderer(this);
        main.setPos(0.0F, 13.25F, 1.0F);


        bone466 = new ModelRenderer(this);
        bone466.setPos(0.0F, 20.0F, 0.0F);
        main.addChild(bone466);
        bone466.texOffs(0, 26).addBox(-5.0F, -27.0F, -2.0F, 1.0F, 16.0F, 1.0F, 0.0F, false);
        bone466.texOffs(4, 26).addBox(4.0F, -27.0F, -2.0F, 1.0F, 16.0F, 1.0F, 0.0F, false);
        bone466.texOffs(0, 24).addBox(-6.0F, -20.0F, -2.0F, 12.0F, 1.0F, 1.0F, -0.1F, false);

        bone36 = new ModelRenderer(this);
        bone36.setPos(0.0F, -28.5F, -1.5F);
        bone466.addChild(bone36);
        bone36.texOffs(0, 20).addBox(-6.0F, 3.5F, -0.5F, 12.0F, 1.0F, 1.0F, -0.1F, false);
        bone36.texOffs(0, 16).addBox(-6.0F, 5.5F, -0.5F, 12.0F, 1.0F, 1.0F, -0.1F, false);

        bone = new ModelRenderer(this);
        bone.setPos(-3.5F, -19.5F, -1.5F);
        bone466.addChild(bone);
        setRotationAngle(bone, 0.7854F, 0.0F, 0.0F);
        bone.texOffs(0, 6).addBox(6.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.15F, false);
        bone.texOffs(0, 6).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.15F, false);

        bone2 = new ModelRenderer(this);
        bone2.setPos(-3.5F, -13.5F, -1.5F);
        bone466.addChild(bone2);
        setRotationAngle(bone2, 0.7854F, 0.0F, 0.0F);
        bone2.texOffs(0, 6).addBox(6.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.15F, false);
        bone2.texOffs(0, 6).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.15F, false);

        bone22 = new ModelRenderer(this);
        bone22.setPos(4.0F, -18.9017F, -3.8731F);
        bone466.addChild(bone22);


        bone23 = new ModelRenderer(this);
        bone23.setPos(0.0F, 0.0F, 0.0F);
        bone22.addChild(bone23);
        bone23.texOffs(0, 0).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.025F, true);

        bone30 = new ModelRenderer(this);
        bone30.setPos(0.0F, 0.0F, 0.0F);
        bone22.addChild(bone30);
        bone30.texOffs(0, 8).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 6.0F, 1.0F, 0.0F, true);

        bone31 = new ModelRenderer(this);
        bone31.setPos(-0.5F, 5.5F, 2.0F);
        bone22.addChild(bone31);
        setRotationAngle(bone31, -0.2443F, 0.0F, 0.0F);
        bone31.texOffs(10, 0).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 5.0F, 0.025F, true);

        bone24 = new ModelRenderer(this);
        bone24.setPos(-4.0F, -18.9017F, -3.8731F);
        bone466.addChild(bone24);


        bone25 = new ModelRenderer(this);
        bone25.setPos(0.0F, 0.0F, 0.0F);
        bone24.addChild(bone25);
        bone25.texOffs(0, 0).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.025F, false);

        bone26 = new ModelRenderer(this);
        bone26.setPos(0.0F, 0.0F, 0.0F);
        bone24.addChild(bone26);
        bone26.texOffs(0, 8).addBox(0.0F, -1.0F, -3.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

        bone27 = new ModelRenderer(this);
        bone27.setPos(0.5F, 5.5F, 2.0F);
        bone24.addChild(bone27);
        setRotationAngle(bone27, -0.2443F, 0.0F, 0.0F);
        bone27.texOffs(10, 0).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 5.0F, 0.025F, false);

        bone4 = new ModelRenderer(this);
        bone4.setPos(0.0F, -12.3139F, 1.237F);
        bone466.addChild(bone4);
        bone4.texOffs(24, 0).addBox(-5.5F, -2.3361F, -2.487F, 11.0F, 1.0F, 8.0F, -0.25F, false);
        bone4.texOffs(0, 22).addBox(-6.0F, -1.6861F, -3.237F, 12.0F, 1.0F, 1.0F, -0.1F, false);
        bone4.texOffs(0, 18).addBox(-6.0F, -1.6861F, 3.263F, 12.0F, 1.0F, 1.0F, -0.1F, false);
        bone4.texOffs(13, 0).addBox(-5.0F, -1.6861F, -3.737F, 1.0F, 1.0F, 9.0F, -0.1F, false);
        bone4.texOffs(0, 6).addBox(4.0F, -1.6861F, -3.737F, 1.0F, 1.0F, 9.0F, -0.1F, false);

        bone5 = new ModelRenderer(this);
        bone5.setPos(0.0F, 0.0F, 0.0F);
        bone4.addChild(bone5);
        setRotationAngle(bone5, 0.3927F, 0.0F, 0.0F);
        bone5.texOffs(8, 33).addBox(4.0F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, -0.2F, false);
        bone5.texOffs(8, 26).addBox(-5.0F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, -0.2F, false);

        bone6 = new ModelRenderer(this);
        bone6.setPos(0.0F, -2.6139F, 2.237F);
        main.addChild(bone6);
        bone6.texOffs(35, 0).addBox(-15.0F, -13.1861F, -13.237F, 30.0F, 32.0F, 27.0F, -10.5F, false);
        bone6.texOffs(0, 59).addBox(-11.5F, -7.9861F, -6.187F, 24.0F, 24.0F, 18.0F, -8.5F, false);
        bone6.texOffs(86, 59).addBox(-8.0F, -6.1861F, -2.187F, 13.0F, 13.0F, 10.0F, -4.5F, false);
    }

    @Override
    public void setupAnim(EntityMaid entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}