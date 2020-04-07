package com.raheshtek.pincho.repository;
import com.raheshtek.pincho.model.Api;
import com.raheshtek.pincho.model.Photo;
import com.raheshtek.pincho.repository.remote.RemoteRepository;
import com.raheshtek.pincho.repository.remote.interfaces.CallBack;
import java.util.List;


public class Repository implements RepoMethod {

//    private final LocalRepository localSource;
    private RemoteRepository remoteSource;

    public Repository(RemoteRepository remoteSource) {
        this.remoteSource = remoteSource;
//        this.localSource = LocalRepository.getInstance();
    }


    @Override
    public void getPhotos(CallBack<List<Photo>> apiCallBack) {
        remoteSource.getPhotos(apiCallBack);
    }
}
