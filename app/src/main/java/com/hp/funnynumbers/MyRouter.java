package com.hp.funnynumbers;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.funnynumbers.R;


public class MyRouter {

    private static MyRouter instance = null;
    private static Context context;
    private static FragmentManager fragmentManager;

    public static MyRouter getInstance() {
        if(instance == null) {
            instance = new MyRouter();
        }

        return instance;
    }

    private MyRouter() {}

    private FragmentManager getSupportFragmentManager() {
        return fragmentManager;
    }

    public void setContext(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }


    public void placeFragment(@NonNull Class<?> cls, @Nullable Bundle bundle) {
        Fragment fragment = getSupportFragmentManager().getFragmentFactory().instantiate(ClassLoader.getSystemClassLoader(), cls.getName());

        if (bundle != null) fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragments, fragment, "fragment")
                .addToBackStack(null)
                .commit();
    }}