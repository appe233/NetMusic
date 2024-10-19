package com.github.tartaricacid.netmusic.networking.message;

import com.github.tartaricacid.netmusic.NetMusic;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

/**
 * @author : IMG
 * @create : 2024/10/3
 */
public class MusicToClientMessage implements CustomPayload {
    private static final Identifier PACKET_ID = Identifier.of(NetMusic.MOD_ID, "play_music");

    public static final CustomPayload.Id<MusicToClientMessage> TYPE = new CustomPayload.Id<>(PACKET_ID);
    public static final PacketCodec<PacketByteBuf, MusicToClientMessage> STREAM_CODEC = PacketCodec.tuple(
            BlockPos.PACKET_CODEC,
            MusicToClientMessage::getPos,
            PacketCodecs.STRING,
            MusicToClientMessage::getUrl,
            PacketCodecs.VAR_INT,
            MusicToClientMessage::getTimeSecond,
            PacketCodecs.STRING,
            MusicToClientMessage::getSongName,
            MusicToClientMessage::new
    );
    private final BlockPos pos;
    private final String url;
    private final int timeSecond;
    private final String songName;

    public MusicToClientMessage(BlockPos pos, String url, int timeSecond, String songName) {
        this.pos = pos;
        this.url = url;
        this.timeSecond = timeSecond;
        this.songName = songName;
    }

    public BlockPos getPos() {
        return pos;
    }

    public String getUrl() {
        return url;
    }

    public int getTimeSecond() {
        return timeSecond;
    }

    public String getSongName() {
        return songName;
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return TYPE;
    }
}
