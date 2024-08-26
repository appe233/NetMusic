package com.github.tartaricacid.netmusic.compat.tlm.message;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.compat.tlm.client.audio.MaidNetMusicSound;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.ChannelAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.Map;

public class MaidStopMusicMessage implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<MaidStopMusicMessage> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(NetMusic.MOD_ID, "maid_music_to_client"));
    public static final StreamCodec<ByteBuf, MaidStopMusicMessage> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, MaidStopMusicMessage::getEntityId,
            MaidStopMusicMessage::new);

    private final int entityId;

    public MaidStopMusicMessage(int entityId) {
        this.entityId = entityId;
    }

    public static MaidStopMusicMessage decode(FriendlyByteBuf buffer) {
        return new MaidStopMusicMessage(buffer.readInt());
    }

    public static void encode(MaidStopMusicMessage message, FriendlyByteBuf buf) {
        buf.writeInt(message.entityId);
    }

    public static void handle(MaidStopMusicMessage message, IPayloadContext context) {
        if (context.flow().isClientbound()) {
            context.enqueueWork(() -> onHandle(message));
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void onHandle(MaidStopMusicMessage message) {
        ClientLevel level = Minecraft.getInstance().level;
        if (level == null) {
            return;
        }
        Map<SoundInstance, ChannelAccess.ChannelHandle> sounds = Minecraft.getInstance().getSoundManager().soundEngine.instanceToChannel;
        for (SoundInstance instance : sounds.keySet()) {
            if (!(instance instanceof MaidNetMusicSound sound)) {
                continue;
            }
            if (sound.getMaidId() == message.entityId) {
                sound.setStop();
            }
        }
    }

    public int getEntityId() {
        return entityId;
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
