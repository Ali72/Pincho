package com.raheshtek.pincho.di.module;

import com.raheshtek.pincho.repository.Repository;
import com.raheshtek.pincho.repository.remote.RemoteRepository;
import com.raheshtek.pincho.repository.remote.services.ApiConnection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    Repository getRepositoryInstance() {
        return new Repository(getRemoteRepository());
    }

    @Singleton
    @Provides
    RemoteRepository getRemoteRepository() {
        return new RemoteRepository(getApiConnection());
    }

    @Singleton
    @Provides
    ApiConnection getApiConnection() {
        return new ApiConnection();
    }
}
