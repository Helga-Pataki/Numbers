package com.hp.funnynumbers.service;

import com.example.funnynumbers.R;

public class SoundModel {
    private static SoundModel instance;

    public static SoundModel getInstance() {
        if (instance == null) {
            instance = new SoundModel();
            instance.initSound();
        }
        return instance;
    }

    int[] soundArr = new int[10];
    public int[] getSoundArr() {
        return soundArr;
    }

    public void initSound() {
        soundArr[0] = R.raw.sound_1;
        soundArr[1] = R.raw.sound_2;
        soundArr[2] = R.raw.sound_3;
        soundArr[3] = R.raw.sound_4;
        soundArr[4] = R.raw.sound_5;
        soundArr[5] = R.raw.sound_6;
        soundArr[6] = R.raw.sound_7;
        soundArr[7] = R.raw.sound_8;
        soundArr[8] = R.raw.sound_9;
        soundArr[9] = R.raw.sound_10;

    }

}

