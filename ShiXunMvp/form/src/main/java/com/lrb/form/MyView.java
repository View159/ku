package com.lrb.form;

public interface MyView <V>{

    void onSuccess(int whichApi,int loadType,V... v);
    void Failer(int whichApi,Throwable pThrowable);

}
