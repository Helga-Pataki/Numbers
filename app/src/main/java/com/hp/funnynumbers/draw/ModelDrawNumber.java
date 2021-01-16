package com.hp.funnynumbers.draw;

import com.example.funnynumbers.R;

public class ModelDrawNumber {
    private static ModelDrawNumber instance;
    int[] imageShapeArr = new int[10];
    int[] colorArr = new int[10];


    public static ModelDrawNumber getInstance() {
        if (instance == null) {
            instance = new ModelDrawNumber();
        }
        return instance;
    }

    public int[] getImageShapeArr() {
        return imageShapeArr;
    }

    public int[] getColorArr() {
        return colorArr;
    }

    public void initDrawNumbers() {
        initDrawable();
        initColor();
    }

    private void initColor() {
        colorArr[0] = R.color.colorOne;
        colorArr[1] = R.color.colorTwo;
        colorArr[2] = R.color.colorThree;
        colorArr[3] = R.color.colorFour;
        colorArr[4] = R.color.colorFive;
        colorArr[5] = R.color.colorSix;
        colorArr[6] = R.color.colorSeven;
        colorArr[7] = R.color.colorEight;
        colorArr[8] = R.color.colorFour;
        colorArr[9] = R.color.colorTen;
    }
    private void initDrawable(){
        imageShapeArr[0] = R.drawable.ic_v_1_shape_1;
        imageShapeArr[1] = R.drawable.ic_v_2_shape_1;
        imageShapeArr[2] = R.drawable.ic_v_3_shape_1;
        imageShapeArr[3] = R.drawable.ic_v_4_shape_1;
        imageShapeArr[4] = R.drawable.ic_v_5_shape_1;
        imageShapeArr[5] = R.drawable.ic_v_6_shape_1;
        imageShapeArr[6] = R.drawable.ic_v_7_shape_1;
        imageShapeArr[7] = R.drawable.ic_v_8_shape_1;
        imageShapeArr[8] = R.drawable.ic_v_9_shape_1;
        imageShapeArr[9] = R.drawable.ic_v_10_shape_1;

    }
}
