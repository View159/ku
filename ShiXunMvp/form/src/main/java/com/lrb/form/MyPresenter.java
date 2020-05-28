package com.lrb.form;

public interface MyPresenter<P> extends MyView{

    void getData(int whichApi,P... p);

}
