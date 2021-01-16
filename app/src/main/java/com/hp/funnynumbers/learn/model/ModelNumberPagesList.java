package com.hp.funnynumbers.learn.model;

import com.example.funnynumbers.R;


public class ModelNumberPagesList {
    private static ModelNumberPagesList instance;
    int[] imageArr = new int[10];


    public static ModelNumberPagesList getInstance() {
        if (instance == null) {
            instance = new ModelNumberPagesList();
        }
        return instance;
    }

    public int[] getImageArr() {
        return imageArr;
    }


    public void initPages() {
        initDrawable();
    }


    private void initDrawable() {
        imageArr[0] = R.drawable.number_1;
        imageArr[1] = R.drawable.number_2;
        imageArr[2] = R.drawable.number_3;
        imageArr[3] = R.drawable.number_4;
        imageArr[4] = R.drawable.number_5;
        imageArr[5] = R.drawable.number_6;
        imageArr[6] = R.drawable.number_7;
        imageArr[7] = R.drawable.number_8;
        imageArr[8] = R.drawable.number_9;
        imageArr[9] = R.drawable.number_10;

    }
}

