package com.lrb.form;

public interface MyModel <M>{
    void getData(MyPresenter presenter,int whichApi,M... m);

}
