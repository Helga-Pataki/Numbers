package com.hp.funnynumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.funnynumbers.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyRouter.getInstance().setContext(this, getSupportFragmentManager());
        MyRouter.getInstance().placeFragment(FirstFragment.class, null);

    }


    @Override
    public void onBackPressed() {

        finish();

    }
}