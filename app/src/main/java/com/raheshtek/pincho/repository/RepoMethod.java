package com.raheshtek.pincho.repository;



import com.raheshtek.pincho.model.Api;
import com.raheshtek.pincho.model.Photo;
import com.raheshtek.pincho.repository.remote.interfaces.CallBack;
import java.util.List;

public interface RepoMethod {


    void getPhotos(CallBack<List<Photo>> apiCallBack);

}

