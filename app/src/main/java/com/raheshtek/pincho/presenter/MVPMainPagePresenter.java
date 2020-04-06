package com.raheshtek.pincho.presenter;


import com.raheshtek.pincho.base.MvpPresenter;
import com.raheshtek.pincho.view.MVPMainPageView;

public interface MVPMainPagePresenter<V extends MVPMainPageView>
        extends MvpPresenter<V> {
    void requestLoadData();
}
