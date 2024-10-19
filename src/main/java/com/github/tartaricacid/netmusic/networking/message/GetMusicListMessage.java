package com.github.tartaricacid.netmusic.networking.message;

import com.github.tartaricacid.netmusic.NetMusic;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/11
 */
public class GetMusicListMessage implements CustomPayload {
    private static final Identifier PACKET_ID = Identifier.of(NetMusic.MOD_ID, "get_music_list");

    public static final CustomPayload.Id<GetMusicListMessage> TYPE = new CustomPayload.Id<>(PACKET_ID);
    public static final PacketCodec<PacketByteBuf, GetMusicListMessage> STREAM_CODEC = PacketCodec.tuple(PacketCodecs.VAR_LONG, GetMusicListMessage::getMusicListId, GetMusicListMessage::new);

    private final long musicListId;
    public static final long RELOAD_MESSAGE = -1;

    public GetMusicListMessage(long musicListId) {
        this.musicListId = musicListId;
    }

    public long getMusicListId() {
        return musicListId;
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return TYPE;
    }
}
