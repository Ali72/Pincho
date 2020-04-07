package com.raheshtek.pincho.di.component;

import com.raheshtek.pincho.app.G;
import com.raheshtek.pincho.di.ActivityScope;
import com.raheshtek.pincho.di.module.MainPageModule;
import com.raheshtek.pincho.di.module.RepositoryModule;
import com.raheshtek.pincho.repository.Repository;
import com.raheshtek.pincho.view.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {MainPageModule.class})
public interface MainPageComponent {
    void inject(MainActivity activity);
}
