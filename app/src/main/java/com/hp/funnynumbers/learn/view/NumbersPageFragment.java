package com.hp.funnynumbers.learn.view;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.funnynumbers.R;

import com.example.funnynumbers.databinding.NumbersPageBinding;
import com.hp.funnynumbers.learn.ScreenSlidePagerActivity;
import com.hp.funnynumbers.learn.presenter.INumbersPagesPresenter;
import com.hp.funnynumbers.learn.presenter.NumbersPagesPresenter;


public class NumbersPageFragment extends Fragment implements IView {

    private NumbersPageBinding binding;
    private INumbersPagesPresenter numbersPagesPresenter = new NumbersPagesPresenter(this);
    int currentPage;
    AnimationDrawable animationDrawable;


    public NumbersPageFragment(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = NumbersPageBinding.inflate(inflater, container, false);
        if (currentPage == 0) {
            binding.swipe.setBackgroundResource(R.drawable.ic_swipe);
        }
        binding.goToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMenu();
            }
        });

        binding.number.setBackgroundResource(numbersPagesPresenter.getModelPagesList().getImageArr()[currentPage]);

        binding.number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersPagesPresenter.onImageClicked();
            }
        });
        animationDrawable = (AnimationDrawable) binding.number.getBackground();
        return binding.getRoot();


    }


    @Override
    public void showNumbers() {

        if (getActivity() != null) {
            ScreenSlidePagerActivity ma = (ScreenSlidePagerActivity) getActivity();

            ma.playSound(currentPage);
        }
        animationDrawable.start();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animationDrawable.stop();
            }
        }, 900);

    }

    @Override
    public FragmentActivity getParentActivity() {
        return getActivity();

    }

    @Override
    public void onPause() {
        super.onPause();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }

    public void goToMenu() {
        numbersPagesPresenter.goToMenu();
    }

}

