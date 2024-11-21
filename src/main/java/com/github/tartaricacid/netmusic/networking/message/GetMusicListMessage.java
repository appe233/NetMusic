package com.github.tartaricacid.netmusic.networking.message;

import com.github.tartaricacid.netmusic.NetMusic;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/11
 */
public class GetMusicListMessage implements Message<GetMusicListMessage> {
    private static final Identifier PACKET_ID = new Identifier(NetMusic.MOD_ID, "get_music_list");
    private final long musicListId;
    public static final long RELOAD_MESSAGE = -1;

    public GetMusicListMessage(long musicListId) {
        this.musicListId = musicListId;
    }

    public static GetMusicListMessage getMessageFromBuffer(PacketByteBuf buf) {
        return new GetMusicListMessage(buf.readLong());
    }

    public long getMusicListId() {
        return musicListId;
    }

    @Override
    public PacketByteBuf toBuffer() {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeLong(musicListId);
        return buf;
    }

    @Override
    public Identifier getPacketId() {
        return PACKET_ID;
    }
}
