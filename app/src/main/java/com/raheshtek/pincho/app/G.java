package com.raheshtek.pincho.app;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.bumptech.glide.Glide;
import com.raheshtek.pincho.di.component.AppComponent;
import com.raheshtek.pincho.di.component.DaggerAppComponent;
import com.raheshtek.pincho.di.module.AppModule;


public class G extends MultiDexApplication {

    private static final String PREFS_NAME = "Preference";
    public static SharedPreferences sharedPref;
    private static G instance;
    private AppComponent component;


    public static G getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        sharedPref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        setupGraph();
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    private void setupGraph() {
        component = DaggerAppComponent.builder().build();
        component.inject(this);
    }

    public AppComponent component() {
        return component;
    }

}
