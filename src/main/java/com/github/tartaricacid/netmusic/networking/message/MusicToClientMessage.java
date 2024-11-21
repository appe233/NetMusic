package com.github.tartaricacid.netmusic.networking.message;

import com.github.tartaricacid.netmusic.NetMusic;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

/**
 * @author : IMG
 * @create : 2024/10/3
 */
public class MusicToClientMessage implements Message<MusicToClientMessage> {
    private static final Identifier PACKET_ID = new Identifier(NetMusic.MOD_ID, "play_music");
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

    public static PacketByteBuf toBuffer(MusicToClientMessage message) {
        if (message == null) return PacketByteBufs.empty();

        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeBlockPos(message.pos);
        buf.writeString(message.url);
        buf.writeInt(message.timeSecond);
        buf.writeString(message.songName);
        return buf;
    }

    public static MusicToClientMessage getMessageFromBuffer(PacketByteBuf buf) {
        return new MusicToClientMessage(
                buf.readBlockPos(),
                buf.readString(),
                buf.readInt(),
                buf.readString()
        );
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
    public PacketByteBuf toBuffer() {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeBlockPos(pos);
        buf.writeString(url);
        buf.writeInt(timeSecond);
        buf.writeString(songName);
        return buf;
    }

    @Override
    public Identifier getPacketId() {
        return PACKET_ID;
    }
}
