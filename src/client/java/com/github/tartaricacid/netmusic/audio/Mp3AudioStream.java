package com.github.tartaricacid.netmusic.audio;

import com.github.tartaricacid.netmusic.config.GeneralConfig;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import net.minecraft.client.sound.AudioStream;
import org.apache.commons.compress.utils.IOUtils;
import org.lwjgl.BufferUtils;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;

/**
 * @author : IMG
 * @create : 2024/10/2
 */
public class Mp3AudioStream implements AudioStream {
    private final AudioInputStream stream;
    private final byte[] array;
    private int offset;

    public Mp3AudioStream(URL url) throws Exception {
        try {
            AudioInputStream originalInputStream = new MpegAudioFileReader().getAudioInputStream(url);
            AudioFormat originalFormat = originalInputStream.getFormat();
            AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, originalFormat.getSampleRate(), 16,
                    originalFormat.getChannels(), originalFormat.getChannels() * 2, originalFormat.getSampleRate(), false);
            AudioInputStream targetInputStream = AudioSystem.getAudioInputStream(targetFormat, originalInputStream);
            if (GeneralConfig.ENABLE_STEREO) {
                targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, originalFormat.getSampleRate(), 16,
                        1, 2, originalFormat.getSampleRate(), false);
                this.stream = AudioSystem.getAudioInputStream(targetFormat, targetInputStream);
            } else {
                this.stream = targetInputStream;
            }
            this.array = IOUtils.toByteArray(stream);
            this.offset = 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public AudioFormat getFormat() {
        return stream.getFormat();
    }

    @Override
    public ByteBuffer read(int size) {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(size);
        if (array.length >= offset + size) {
            byteBuffer.put(array, offset, size);
        } else {
            byteBuffer.put(new byte[size]);
        }
        offset += size;
        byteBuffer.flip();
        return byteBuffer;
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }
}
