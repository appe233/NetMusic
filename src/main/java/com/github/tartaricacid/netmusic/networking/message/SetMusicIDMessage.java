package com.github.tartaricacid.netmusic.networking.message;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.item.ItemMusicCD;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/3
 */
public class SetMusicIDMessage implements CustomPayload {
    private final static Identifier PACKET_ID = Identifier.of(NetMusic.MOD_ID, "set_music_id");
    public static final CustomPayload.Id<SetMusicIDMessage> TYPE = new CustomPayload.Id<>(PACKET_ID);
    public static final PacketCodec<PacketByteBuf, SetMusicIDMessage> STREAM_CODEC = PacketCodec.tuple(
            ItemMusicCD.SongInfo.STREAM_CODEC,
            SetMusicIDMessage::getSong,
            SetMusicIDMessage::new
    );
    public final ItemMusicCD.SongInfo song;

    public SetMusicIDMessage(ItemMusicCD.SongInfo song) {
        this.song = song;
    }

    public ItemMusicCD.SongInfo getSong() {
        return song;
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return TYPE;
    }
}