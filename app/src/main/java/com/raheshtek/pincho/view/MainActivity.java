package com.raheshtek.pincho.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.raheshtek.pincho.R;
import com.raheshtek.pincho.base.BaseActivity;
import com.raheshtek.pincho.model.Photo;
import com.raheshtek.pincho.module.AppComponent;
import com.raheshtek.pincho.module.AppModule;
import com.raheshtek.pincho.module.DaggerAppComponent;
import com.raheshtek.pincho.presenter.MVPMainPagePresenter;
import com.raheshtek.pincho.presenter.MainPagePresenter;
import com.raheshtek.pincho.repository.remote.services.ServiceApi;
import com.raheshtek.pincho.utils.PinchImageView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity<MVPMainPagePresenter> implements MVPMainPageView {

    List<Photo> data = new ArrayList<>();
    @BindView(R.id.pager) ViewPager pager;
    @Inject MainPagerAdapter adapter;


    @Override
    protected AppComponent getComponent() {
        AppComponent comp = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        comp.inject(this);
        return comp;
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void functionView() {
        super.functionView();
        adapter.setData(this, data);
        pager.setAdapter(adapter);
        getPresenter().requestLoadData();
    }

    @Override
    public void onDataLoaded(List<Photo> result) {
        data.addAll(result);
        adapter.notifyDataSetChanged();
    }


}
