package com.github.tartaricacid.netmusic.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.packet.CustomPayload;

/**
 * @author : IMG
 * @create : 2024/10/8
 */
public class ClientNetWorkHandler {

    public static void sendToServer(CustomPayload toSend) {
        ClientPlayNetworking.send(toSend);
    }
}
