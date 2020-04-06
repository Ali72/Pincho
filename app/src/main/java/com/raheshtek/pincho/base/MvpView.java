package com.raheshtek.pincho.base;

import android.content.Context;

public interface MvpView<T> {

    void functionView();

    T getPresenter();

}
