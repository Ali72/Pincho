package com.raheshtek.pincho.presenter;


import android.preference.Preference;
import android.widget.Toast;

import com.raheshtek.pincho.R;
import com.raheshtek.pincho.base.BasePresenter;
import com.raheshtek.pincho.model.Api;
import com.raheshtek.pincho.model.Photo;
import com.raheshtek.pincho.repository.Repository;
import com.raheshtek.pincho.repository.remote.interfaces.CallBack;
import com.raheshtek.pincho.view.MVPMainPageView;

import java.util.List;

public class MainPagePresenter<V extends MVPMainPageView>
        extends BasePresenter<V>
        implements MVPMainPagePresenter<V> {


    @Override
    public void requestLoadData() {
        Repository.getInstance().getPhotos(new CallBack<List<Photo>>() {
            @Override
            public void onSuccess(List<Photo> result) {
                super.onSuccess(result);
                if (getMvpView() == null) return;
                getMvpView().onDataLoaded(result);
                getMvpView().hideErrorView();
            }

            @Override
            public void onFail(Exception e) {
                super.onFail(e);
                if (getMvpView() == null) return;
                getMvpView().showError(e);
            }
        });
    }
}
