package com.raheshtek.pincho.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.Preference;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.raheshtek.pincho.R;
import com.raheshtek.pincho.app.G;
import com.raheshtek.pincho.model.Photo;
import com.raheshtek.pincho.module.AppComponent;
import com.raheshtek.pincho.module.AppModule;
import com.raheshtek.pincho.module.DaggerAppComponent;


import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;


public abstract class BaseActivity<V extends MvpPresenter>
        extends AppCompatActivity implements MvpViewActivity {

    final static String TAG = BaseActivity.class.getName();
    private V presenter;
    private Unbinder unbinder;
    public G application;
    private AppComponent appComponent = getComponent();

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewLayoutId());
        application = (G) this.getApplicationContext();
        unbinder = ButterKnife.bind(this);
        if (presenter != null)
            presenter.onAttach(this);
        else
            Log.e(TAG, "Presenter is NULL");
        functionView();
    }

    protected abstract AppComponent getComponent();

    @Inject
    public void setPresenter(V presenter) {
        this.presenter = presenter;
    }

    @Override
    public V getPresenter() {
        return presenter;
    }

    @LayoutRes
    public abstract int getViewLayoutId();

    public void functionView() {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.onDetach();
        unbinder.unbind();
    }


    @Override
    public void showError(Exception e) {

    }

    @Override
    public void hideErrorView() {

    }

    @Override
    public void setOnRetryBtnClicked(View.OnClickListener onRetryBtnClicked) {

    }
}
