package com.hp.funnynumbers.draw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.funnynumbers.databinding.DrawNumberBinding;
import com.hp.funnynumbers.service.SoundLoader;

import java.util.Objects;

public class DrawNumberFragment extends Fragment {
    SoundLoader soundLoader;
    ModelDrawNumber model = ModelDrawNumber.getInstance();
    int current = 0;
    DrawNumberBinding drawNumberBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDrawNum();
        soundLoader= new SoundLoader(getContext());
    }

    private void initDrawNum() {
        model.initDrawNumbers();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        drawNumberBinding = DrawNumberBinding.inflate(inflater, container, false);
        goNext();
        drawNumberBinding.clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawNumberBinding.drawing.clearView();
            }
        });
        drawNumberBinding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current++; goNext();
            }
        });
        drawNumberBinding.goToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMenu();
            }
        });
        drawNumberBinding.repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundLoader.playSound(current % 10);
            }
        });
        return drawNumberBinding.getRoot();

    }

    private void goToMenu() {
        drawNumberBinding = null;
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
    }

    public void goNext() {

        if (current>0){
        drawNumberBinding.drawing.clearView(); }

        soundLoader.playSound(current % 10);
        drawNumberBinding.porterShapeImageView.setImageResource(model.getImageShapeArr()[current % 10]);
        drawNumberBinding.drawing.changeColor(model.getColorArr()[current % 10]);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        drawNumberBinding = null;
        soundLoader.cleanSoundPool();
    }
}
