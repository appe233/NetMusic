package com.github.tartaricacid.netmusic.receiver;

import com.github.tartaricacid.netmusic.inventory.CDBurnerMenu;
import com.github.tartaricacid.netmusic.inventory.ComputerMenu;
import com.github.tartaricacid.netmusic.networking.message.SetMusicIDMessage;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

/**
 * @author : IMG
 * @create : 2024/10/8
 */
public class SetMusicIDMessageReceiver {

    public static void receive() {
        ServerPlayNetworking.registerGlobalReceiver(SetMusicIDMessage.getPacketIdStatic(), (server, player, handler, buf, responseSender) -> {
            SetMusicIDMessage message = SetMusicIDMessage.fromBuffer(buf);
            server.execute(() -> {
                if (player == null) {
                    return;
                }
                if (player.currentScreenHandler instanceof CDBurnerMenu menu) {
                    menu.setSongInfo(message.song);
                    return;
                }
                if (player.currentScreenHandler instanceof ComputerMenu menu) {
                    menu.setSongInfo(message.song);
                }
            });
        });
    }
}
