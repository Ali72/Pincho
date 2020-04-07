package com.raheshtek.pincho.di.module;


import com.raheshtek.pincho.presenter.MVPMainPagePresenter;
import com.raheshtek.pincho.presenter.MainPagePresenter;
import com.raheshtek.pincho.view.MVPMainPageView;
import com.raheshtek.pincho.view.MainPagerAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainPageModule {

    private MVPMainPageView mvpMainPageView;

    public MainPageModule(MVPMainPageView mvpMainPageView) {
        this.mvpMainPageView = mvpMainPageView;
    }

    @Provides
    MainPagerAdapter getMainAdapter() {
        return new MainPagerAdapter();
    }

    @Provides
    MVPMainPagePresenter getMainPresenter() {
        return new MainPagePresenter();
    }

    @Provides
    MVPMainPageView getMainPageView() {
        return mvpMainPageView;
    }

}
