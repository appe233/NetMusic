package com.github.tartaricacid.netmusic.compat.tlm.message;

import com.github.tartaricacid.netmusic.compat.tlm.client.audio.MaidNetMusicSound;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ChannelManager;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.Map;
import java.util.function.Supplier;

public class MaidStopMusicMessage {
    private final int entityId;

    public MaidStopMusicMessage(int entityId) {
        this.entityId = entityId;
    }

    public static MaidStopMusicMessage decode(PacketBuffer buffer) {
        return new MaidStopMusicMessage(buffer.readInt());
    }

    public static void encode(MaidStopMusicMessage message, PacketBuffer buf) {
        buf.writeInt(message.entityId);
    }

    public static void handle(MaidStopMusicMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        if (context.getDirection().getReceptionSide().isClient()) {
            context.enqueueWork(() -> onHandle(message));
        }
        context.setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    private static void onHandle(MaidStopMusicMessage message) {
        ClientWorld level = Minecraft.getInstance().level;
        if (level == null) {
            return;
        }
        Map<ISound, ChannelManager.Entry> sounds = Minecraft.getInstance().getSoundManager().soundEngine.instanceToChannel;
        for (ISound instance : sounds.keySet()) {
            if (!(instance instanceof MaidNetMusicSound)) {
                continue;
            }
            MaidNetMusicSound sound = (MaidNetMusicSound) instance;
            if (sound.getMaidId() == message.entityId) {
                sound.setStop();
            }
        }
    }
}
