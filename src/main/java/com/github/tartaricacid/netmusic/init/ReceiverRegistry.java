package com.github.tartaricacid.netmusic.init;

import com.github.tartaricacid.netmusic.receiver.SetMusicIDMessageReceiver;

/**
 * @author : IMG
 * @create : 2024/10/8
 */
public class ReceiverRegistry {

    public static void register() {
        SetMusicIDMessageReceiver.receive();
    }
}
