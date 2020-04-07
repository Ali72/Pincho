package com.raheshtek.pincho.view;

import androidx.viewpager.widget.ViewPager;

import com.raheshtek.pincho.R;
import com.raheshtek.pincho.base.BaseActivity;
import com.raheshtek.pincho.di.component.DaggerAppComponent;
import com.raheshtek.pincho.di.component.DaggerMainPageComponent;
import com.raheshtek.pincho.di.component.MainPageComponent;
import com.raheshtek.pincho.di.module.AppModule;
import com.raheshtek.pincho.di.module.MainPageModule;
import com.raheshtek.pincho.model.Photo;
import com.raheshtek.pincho.di.component.AppComponent;
import com.raheshtek.pincho.presenter.MVPMainPagePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MVPMainPagePresenter> implements MVPMainPageView {

    List<Photo> data = new ArrayList<>();
    @BindView(R.id.pager) ViewPager pager;
    @Inject MainPagerAdapter adapter;


    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerMainPageComponent.builder().appComponent(appComponent)
                .mainPageModule(new MainPageModule(this))
                .build().inject(this);
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
        setOnRetryBtnClicked(v -> getPresenter().requestLoadData());
        getPresenter().requestLoadData();
    }

    @Override
    public void onDataLoaded(List<Photo> result) {
        data.addAll(result);
        adapter.notifyDataSetChanged();
    }


}
