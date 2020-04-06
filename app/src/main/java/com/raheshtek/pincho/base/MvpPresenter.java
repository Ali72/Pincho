package com.raheshtek.pincho.base;

import android.content.Context;

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

}
