package com.raheshtek.pincho.module;


import android.app.Activity;

import com.raheshtek.pincho.presenter.MVPMainPagePresenter;
import com.raheshtek.pincho.presenter.MainPagePresenter;
import com.raheshtek.pincho.view.MVPMainPageView;
import com.raheshtek.pincho.view.MainPagerAdapter;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.Module;
import dagger.Provides;

@Module
public
class AppModule {

    private MVPMainPageView mvpMainPageView;

    public AppModule(MVPMainPageView mvpMainPageView) {
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
