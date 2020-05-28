package com.lrb.shixunmvp.test.contract;

public interface Contract {


    interface BasePresenter<V>{
        void attach(V view);
        void detach();
    }

    interface View<T>{
        void Success(T t);
        void Failed(String msg);
    }

    interface Presenter extends BasePresenter<View>{
        void getData();
    }
}
