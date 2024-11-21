package com.github.tartaricacid.netmusic.networking;

import com.github.tartaricacid.netmusic.networking.message.Message;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

/**
 * @author : IMG
 * @create : 2024/10/5
 */
public class NetworkHandler {

    public static void sendToNearBy(World world, BlockPos pos, Message<?> message) {
        if (world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) world;

            PacketByteBuf buffer = message.toBuffer();
            serverWorld.getChunkManager().threadedAnvilChunkStorage.getPlayersWatchingChunk(new ChunkPos(pos), false).stream()
                    .filter(p -> p.squaredDistanceTo(pos.getX(), pos.getY(), pos.getZ()) < 96 * 96)
                    .forEach(p -> ServerPlayNetworking.send(p, message.getPacketId(), buffer));
        }
    }

    public static void sendToClientPlayer(Message<?> message, ServerPlayerEntity player) {
        ServerPlayNetworking.send(player, message.getPacketId(), message.toBuffer());
    }
}
