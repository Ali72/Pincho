package com.raheshtek.pincho.di.component;

import com.raheshtek.pincho.app.G;
import com.raheshtek.pincho.di.module.AppModule;
import com.raheshtek.pincho.di.module.MainPageModule;
import com.raheshtek.pincho.di.module.RepositoryModule;
import com.raheshtek.pincho.repository.Repository;
import com.raheshtek.pincho.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface AppComponent {

    void inject(G application);

    Repository getRepository();

}
