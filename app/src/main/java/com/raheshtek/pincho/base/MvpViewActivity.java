package com.raheshtek.pincho.base;

import android.view.View;

public interface MvpViewActivity<T> extends MvpView<T> {

    void showError(Exception e);

    void hideErrorView();

    void setOnRetryBtnClicked(View.OnClickListener onRetryBtnClicked);
}
