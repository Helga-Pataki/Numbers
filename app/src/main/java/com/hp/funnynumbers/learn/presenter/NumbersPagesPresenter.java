package com.hp.funnynumbers.learn.presenter;

import com.hp.funnynumbers.learn.model.ModelNumberPagesList;
import com.hp.funnynumbers.learn.view.IView;

public class NumbersPagesPresenter implements INumbersPagesPresenter {

    private IView iView;

    private ModelNumberPagesList modelPagesList;

    public NumbersPagesPresenter(IView iView) {
        this.iView = iView;

        modelPagesList = ModelNumberPagesList.getInstance();
        modelPagesList.initPages();
    }

    @Override
    public void onImageClicked() {

        iView.showNumbers();
    }

    @Override
    public ModelNumberPagesList getModelPagesList() {
        return modelPagesList;
    }

    @Override
    public void goToMenu() {
        try {
            iView.getParentActivity().finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
