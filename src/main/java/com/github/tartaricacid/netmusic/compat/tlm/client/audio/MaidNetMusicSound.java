package com.github.tartaricacid.netmusic.compat.tlm.client.audio;

import com.github.tartaricacid.netmusic.api.IUrlSound;
import com.github.tartaricacid.netmusic.compat.tlm.backpack.MusicPlayerBackpack;
import com.github.tartaricacid.netmusic.init.InitSounds;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.TickableSound;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.net.URL;

public class MaidNetMusicSound extends TickableSound implements IUrlSound {
    private final EntityMaid maid;
    private final URL songUrl;
    private final int tickTimes;
    private int tick;

    public MaidNetMusicSound(EntityMaid maid, URL songUrl, int timeSecond) {
        super(InitSounds.NET_MUSIC.get(), SoundCategory.RECORDS);
        this.maid = maid;
        this.songUrl = songUrl;
        this.x = maid.getX();
        this.y = maid.getY();
        this.z = maid.getZ();
        this.tickTimes = timeSecond * 20;
        this.volume = 4.0f;
        this.tick = 0;
    }

    @Override
    public void tick() {
        if (!this.maid.isAlive()) {
            this.stop();
        }
        if (!(maid.getMaidBackpackType() instanceof MusicPlayerBackpack)) {
            this.stop();
        }
        World world = Minecraft.getInstance().level;
        if (world == null) {
            this.stop();
            return;
        }

        tick++;
        if (tick > tickTimes + 50) {
            this.stop();
        } else {
            this.x = this.maid.getX();
            this.y = this.maid.getY();
            this.z = this.maid.getZ();
            if (world.getGameTime() % 8 == 0) {
                for (int i = 0; i < 2; i++) {
                    world.addParticle(ParticleTypes.NOTE,
                            x - 0.5 + world.random.nextDouble(),
                            y + 1.5 + world.random.nextDouble(),
                            z - 0.5 + world.random.nextDouble(),
                            world.random.nextGaussian(), world.random.nextGaussian(), world.random.nextInt(3));
                }
            }
        }
    }

    @Override
    public URL getSongUrl() {
        return songUrl;
    }

    public int getMaidId() {
        return this.maid.getId();
    }

    public void setStop() {
        this.stop();
    }
}
