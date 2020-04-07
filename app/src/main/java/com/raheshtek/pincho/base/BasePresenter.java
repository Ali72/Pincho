package com.raheshtek.pincho.base;

import com.raheshtek.pincho.app.G;
import com.raheshtek.pincho.di.component.AppComponent;
import com.raheshtek.pincho.di.component.DaggerAppComponent;
import com.raheshtek.pincho.repository.Repository;

import javax.inject.Inject;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private static final String TAG = BasePresenter.class.getName();
    private V mMvpView;
    private Repository repository = G.getInstance().component().getRepository();

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }


    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }


    public V getMvpView() {
        return mMvpView;
    }

    public Repository getRepository() {
        return repository;
    }
//
//    public AppComponent getComp() {
//        return comp;
//    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
