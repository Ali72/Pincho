package com.raheshtek.pincho.repository.remote.interfaces;


public interface CallBacks<T> {
    void onSuccess(T t);

    void onFail(Exception e);
}