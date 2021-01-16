package com.hp.funnynumbers.service;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;


public class SoundLoader {

    Context context;

    public SoundLoader(Context context) {
        this.context = context;
    }

    AudioAttributes attributes = new AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build();
    SoundPool soundPool = new SoundPool.Builder()
            .setAudioAttributes(attributes)
            .setMaxStreams(1)
            .build();

    public void playSound(final int currentPage) {

        final int soundId = soundPool.load(context, SoundModel.getInstance().getSoundArr()[currentPage % 10], 1);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                soundPool.play(soundId, 20, 20, 1, 0, 1f);
            }
        });

    }


    public void stopSound(int currentPage) {////todo удалить
        soundPool.unload(currentPage);
    }

    public void cleanSoundPool() {
        soundPool.release();
    }
}
