package com.github.tartaricacid.netmusic.compat.tlm.client.event;

import com.github.tartaricacid.netmusic.NetMusic;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ReloadResourceEvent {
    public static final ResourceLocation BLOCK_ATLAS_TEXTURE = new ResourceLocation("textures/atlas/blocks.png");
    public static final ResourceLocation MUSIC_CD_SLOT = new ResourceLocation(NetMusic.MOD_ID, "slot/music_cd_slot");

    @SubscribeEvent
    public static void onTextureStitchEventPost(TextureStitchEvent.Pre event) {
        if (BLOCK_ATLAS_TEXTURE.equals(event.getAtlas().location())) {
            event.addSprite(MUSIC_CD_SLOT);
        }
    }
}
