package com.raheshtek.pincho.repository;
import com.raheshtek.pincho.model.Api;
import com.raheshtek.pincho.model.Photo;
import com.raheshtek.pincho.repository.remote.RemoteRepository;
import com.raheshtek.pincho.repository.remote.interfaces.CallBack;
import java.util.List;


public class Repository implements RepoMethod {

    private static Repository INSTANCE;
//    private final LocalRepository localSource;
    private RemoteRepository remoteSource;
//    private AppExecutors executors = new AppExecutors();

    public static Repository getInstance() {
        if (INSTANCE == null) {
            synchronized (Repository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Repository();
                }
            }
        }
        return INSTANCE;
    }

    private Repository() {
        this.remoteSource = RemoteRepository.getInstance();
//        this.localSource = LocalRepository.getInstance();
        init();
    }

    private void init() {
    }


    @Override
    public void getPhotos(CallBack<List<Photo>> apiCallBack) {
        remoteSource.getPhotos(apiCallBack);
    }
}
