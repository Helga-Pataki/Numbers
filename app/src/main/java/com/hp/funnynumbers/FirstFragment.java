package com.hp.funnynumbers;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.funnynumbers.databinding.FirstFragmentBinding;
import com.hp.funnynumbers.draw.DrawNumberFragment;
import com.hp.funnynumbers.learn.ScreenSlidePagerActivity;

public class FirstFragment extends Fragment { private FirstFragmentBinding firstFragmentBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        firstFragmentBinding = FirstFragmentBinding.inflate(inflater, container, false);
        View view = firstFragmentBinding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        firstFragmentBinding.imageViewLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScreenSlidePagerActivity.class);
                startActivity(intent);

            }
        });
        firstFragmentBinding.imageViewDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goDrawNumbers();
            }
        });
    }


    private void goDrawNumbers() {
        MyRouter.getInstance().placeFragment(DrawNumberFragment.class,null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        firstFragmentBinding=null;
    }
}
