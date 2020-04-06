package com.raheshtek.pincho.repository.remote;

import android.util.Log;

import com.raheshtek.pincho.model.Api;
import com.raheshtek.pincho.model.Photo;
import com.raheshtek.pincho.repository.remote.interfaces.CallBack;
import com.raheshtek.pincho.repository.remote.services.ApiConnection;
import com.raheshtek.pincho.repository.remote.utils.RetriableCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class RemoteRepository implements RemoteSource {

    private static RemoteRepository INSTANCE;
    private ApiConnection apiConnection;
    private static final String TAG = RemoteRepository.class.getName();

    public static RemoteRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (RemoteRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RemoteRepository();
                }
            }
        }
        return INSTANCE;
    }

    private RemoteRepository() {
        apiConnection = ApiConnection.getInstance();
    }


    private <T> RetriableCallback<T> makeCallBack(final CallBack<T> callBack) {
        return makeCallBack(0, 0, callBack);
    }

    private <T> RetriableCallback<T> makeCallBack(int maxRetry, int maxTimerRetry, final CallBack<T> callBack) {
        return new RetriableCallback<T>(maxRetry, maxTimerRetry) {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                super.onResponse(call, response);
                if (response.body() != null && response.isSuccessful()) {
                    callBack.onSuccess(response.body());
                } else {
                    callBack.onFail(new Exception("Fail Parse Json To POJO "));
                    Log.e(TAG, "Fail Parse Json To POJO");
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                super.onFailure(call, t);
                callBack.onFail(new Exception(t.getMessage()));
            }
        };
    }

    @Override
    public void getPhotos(CallBack<List<Photo>> apiCallBack) {
        apiConnection.getService().getPhotos().enqueue(makeCallBack(apiCallBack));
    }
}
