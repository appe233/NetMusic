package com.github.tartaricacid.netmusic.networking.message;

import com.github.tartaricacid.netmusic.NetMusic;
import com.github.tartaricacid.netmusic.item.ItemMusicCD;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

/**
 * @author : IMG
 * @create : 2024/10/3
 */
public class SetMusicIDMessage implements Message<SetMusicIDMessage> {
    private final static Identifier PACKET_ID = new Identifier(NetMusic.MOD_ID, "set_music_id");
    public final ItemMusicCD.SongInfo song;

    public SetMusicIDMessage(ItemMusicCD.SongInfo song) {
        this.song = song;
    }

    @Override
    public PacketByteBuf toBuffer() {
        PacketByteBuf buf = PacketByteBufs.create();
        NbtCompound nbt = new NbtCompound();
        ItemMusicCD.SongInfo.serializeNBT(song, nbt);
        return buf.writeNbt(nbt);
    }

    public static SetMusicIDMessage fromBuffer(PacketByteBuf buf) {
        NbtCompound nbt = buf.readNbt();
        ItemMusicCD.SongInfo songData = ItemMusicCD.SongInfo.deserializeNBT(nbt);
        return new SetMusicIDMessage(songData);
    }

    @Override
    public Identifier getPacketId() {
        return PACKET_ID;
    }

    public static Identifier getPacketIdStatic() {
        return PACKET_ID;
    }
}