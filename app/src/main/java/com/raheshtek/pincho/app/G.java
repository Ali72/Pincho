package com.raheshtek.pincho.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.preference.Preference;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.core.content.res.ResourcesCompat;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.bumptech.glide.Glide;
import com.raheshtek.pincho.R;
import com.raheshtek.pincho.module.AppComponent;
import com.raheshtek.pincho.module.AppModule;
import com.raheshtek.pincho.module.DaggerAppComponent;
import com.raheshtek.pincho.utils.FileManager;
import com.raheshtek.pincho.view.MainActivity;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Proxy;


public class G extends MultiDexApplication {

    private static final String PREFS_NAME = "Preference";
    public static SharedPreferences sharedPref;
    private static G instance;


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

    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

}
