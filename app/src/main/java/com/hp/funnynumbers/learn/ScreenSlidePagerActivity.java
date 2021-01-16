package com.hp.funnynumbers.learn;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.funnynumbers.R;
import com.hp.funnynumbers.learn.view.NumbersPageFragment;
import com.hp.funnynumbers.service.SoundLoader;

public class ScreenSlidePagerActivity extends FragmentActivity {
    private static final int NUM_PAGES = 10;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    SoundLoader soundLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePageAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        viewPager.setPageTransformer(new ZoomOutPageTransform());
        soundLoader = new SoundLoader(this);

    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePageAdapter extends FragmentStateAdapter {

        public ScreenSlidePageAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return new NumbersPageFragment(position);
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        soundLoader.cleanSoundPool();
        this.finish();
    }


    public void playSound(int currentPage) {
        soundLoader.playSound(currentPage);
    }
}
