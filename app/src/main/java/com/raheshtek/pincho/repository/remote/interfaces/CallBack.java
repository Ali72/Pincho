package com.raheshtek.pincho.repository.remote.interfaces;


public abstract class CallBack<T> implements CallBacks<T> {
    private Runnable onSuccessRunnable;
    private Runnable onFailRunnable;
    CallBacks<T> tCallBacks;


    @Override
    public void onSuccess(T t) {
        if (tCallBacks != null) {
            tCallBacks.onSuccess(t);
        }
    }


    @Override
    public void onFail(Exception e) {
        if (tCallBacks != null) {
            tCallBacks.onFail(e);
        }
    }

    public void settCallBacks(CallBacks<T> tCallBacks) {
        this.tCallBacks = tCallBacks;
    }
}
