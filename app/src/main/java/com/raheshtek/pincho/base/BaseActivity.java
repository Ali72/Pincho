package com.raheshtek.pincho.base;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.raheshtek.pincho.R;
import com.raheshtek.pincho.app.G;
import com.raheshtek.pincho.di.component.AppComponent;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity<V extends MvpPresenter>
        extends AppCompatActivity implements MvpViewActivity {

    final static String TAG = BaseActivity.class.getName();
    private V presenter;
    private Unbinder unbinder;

    @Nullable
    @BindView(R.id.btn_retry)
    AppCompatButton retryBtn;

    @Nullable
    @BindView(R.id.txt_error_message)
    AppCompatTextView txtErrorMessage;

    @Nullable
    @BindView(R.id.ll_progress)
    LinearLayout llProgress;
    @Nullable
    @BindView(R.id.ll_retry)
    LinearLayout llRetry;

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewLayoutId());
        unbinder = ButterKnife.bind(this);
        setupComponent(G.getInstance().component());
        if (presenter != null)
            presenter.onAttach(this);
        else
            Log.e(TAG, "Presenter is NULL");
        functionView();
    }

    protected abstract void setupComponent(AppComponent appComponent);

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
        hideProgressView();
        if (llRetry != null && txtErrorMessage != null) {
            llRetry.setVisibility(View.VISIBLE);
            txtErrorMessage.setText(e.getMessage());
        }
    }

    @Override
    public void hideErrorView() {
        if (llRetry != null) llRetry.setVisibility(View.GONE);
    }

    @Override
    public void showProgressView() {
        hideErrorView();
        if (llProgress != null) llProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressView() {
        if (llProgress != null) llProgress.setVisibility(View.GONE);
    }


    @Override
    public void setOnRetryBtnClicked(View.OnClickListener onRetryBtnClicked) {
        if (retryBtn != null) {
            retryBtn.setOnClickListener(onRetryBtnClicked);
        }
    }
}
