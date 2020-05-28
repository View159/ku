package com.lrb.form;

public class IPresenter implements MyPresenter {

    protected MyView myView;
    private final IModule iModule;

    public IPresenter(MyView myView) {
        this.myView=myView;
        iModule = new IModule();
    }

    @Override
    public void getData(int whichApi, Object... p) {
        iModule.getData(this, whichApi, p);
    }

    @Override
    public void onSuccess(int whichApi, int loadType, Object... v) {
                myView.onSuccess(whichApi,loadType,v);
    }

    @Override
    public void Failer(int whichApi, Throwable pThrowable) {
        myView.Failer(whichApi,pThrowable);
    }
}
