package com.github.tartaricacid.netmusic.receiver;

import com.github.tartaricacid.netmusic.config.MusicListManage;
import com.github.tartaricacid.netmusic.networking.message.GetMusicListMessage;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.concurrent.CompletableFuture;

/**
 * @author : IMG
 * @create : 2024/10/11
 */
public class GetMusicListMessageReceiver implements ClientPlayNetworking.PlayPayloadHandler<GetMusicListMessage> {

    @Override
    public void receive(GetMusicListMessage message, ClientPlayNetworking.Context context) {
        context.client().execute(() -> {
            CompletableFuture.runAsync(() -> {
                ClientPlayerEntity player = MinecraftClient.getInstance().player;
                try {
                    if (message.getMusicListId() == GetMusicListMessage.RELOAD_MESSAGE) {
                        MusicListManage.loadConfigSongs(MinecraftClient.getInstance().getResourceManager());
                        if (player != null) {
                            player.sendMessage(Text.translatable("command.netmusic.music_cd.reload.success"));
                        }
                    }else {
                        MusicListManage.add163List(message.getMusicListId());
                        if (player != null) {
                            player.sendMessage(Text.translatable("command.netmusic.music_cd.add163.success"));
                        }
                    }
                }catch (Exception e){
                    if (player != null) {
                        player.sendMessage(Text.translatable("command.netmusic.music_cd.add163.fail").formatted(Formatting.RED));
                    }
                    e.printStackTrace();
                }
            });
        });
    }
}
