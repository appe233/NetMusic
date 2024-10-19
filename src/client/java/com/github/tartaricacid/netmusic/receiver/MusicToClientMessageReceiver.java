package com.github.tartaricacid.netmusic.receiver;

import com.github.tartaricacid.netmusic.audio.MusicPlayManager;
import com.github.tartaricacid.netmusic.audio.NetMusicSound;
import com.github.tartaricacid.netmusic.networking.message.MusicToClientMessage;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Util;

import java.util.concurrent.CompletableFuture;

/**
 * @author : IMG
 * @create : 2024/10/4
 */
public class MusicToClientMessageReceiver implements ClientPlayNetworking.PlayPayloadHandler<MusicToClientMessage> {

    @Override
    public void receive(MusicToClientMessage message, ClientPlayNetworking.Context context) {
        context.client().execute(() -> {
            CompletableFuture.runAsync(() -> {
                MusicPlayManager.play(
                        message.getUrl(),
                        message.getSongName(),
                        url -> new NetMusicSound(
                                message.getPos(),
                                url,
                                message.getTimeSecond()
                        )
                );
            }, Util.getMainWorkerExecutor());
        });
    }
}
