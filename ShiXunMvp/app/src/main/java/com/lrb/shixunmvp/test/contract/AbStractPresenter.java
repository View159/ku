package com.lrb.shixunmvp.test.contract;

import java.lang.ref.WeakReference;

public abstract class AbStractPresenter<V> implements Contract.BasePresenter<V> {

    V view;
    @Override
    public void attach(V view) {
        WeakReference<V> vWeakReference = new WeakReference<>(view);
        this.view=vWeakReference.get();
    }

    @Override
    public void detach() {
        if(view!=null){
            view=null;
        }
    }
}
