package com.hp.funnynumbers.presenter;

import android.content.Context;
import android.content.Intent;

import com.hp.funnynumbers.learn.ScreenSlidePagerActivity;

public class PresenterActivityMain implements IPresenterActivityMain{


    @Override
    public void goToDrawNumbers(Context context) {
        Intent intent = new Intent(context, ScreenSlidePagerActivity.class);
        context.startActivity(intent);

    }

    @Override
    public void goToLearnNumbers(Context context) {

    }
}
