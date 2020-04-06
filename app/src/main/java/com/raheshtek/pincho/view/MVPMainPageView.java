package com.raheshtek.pincho.view;

import com.raheshtek.pincho.base.MvpView;
import com.raheshtek.pincho.base.MvpViewActivity;
import com.raheshtek.pincho.model.Photo;

import java.util.List;

public interface MVPMainPageView extends MvpViewActivity {

    void onDataLoaded(List<Photo> result);
}
