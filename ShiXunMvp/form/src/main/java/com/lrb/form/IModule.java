package com.lrb.form;

import com.lrb.form.service.ApiService;
import com.lrb.text.InfoBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class IModule implements MyModel {
    @Override
    public void getData(final MyPresenter presenter, final int whichApi, final Object[] m) {
        final int loadType = (int) m[0];
        HashMap hashMap = (HashMap) m[1];
        int pageId = (int) m[2];
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://static.owspace.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Observable<InfoBean> data = retrofit.create(ApiService.class).getData(hashMap, pageId);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<InfoBean>() {
                    @Override
                    public void accept(InfoBean infoBean) throws Exception {
                        presenter.onSuccess(whichApi,loadType,infoBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        presenter.Failer(loadType,throwable);
                    }
                });
    }
}
