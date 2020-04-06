package com.raheshtek.pincho.module;

import com.raheshtek.pincho.base.BaseActivity;
import com.raheshtek.pincho.view.MainActivity;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MainActivity activity);
}
