package com.hp.funnynumbers.learn.presenter;

import com.hp.funnynumbers.learn.model.ModelNumberPagesList;

public interface INumbersPagesPresenter {
    void onImageClicked();
    ModelNumberPagesList getModelPagesList();
    void goToMenu();
}
