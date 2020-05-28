package com.lrb.shixunmvp.test.contract;


import com.lrb.form.service.ApiService;
import com.lrb.text.InfoBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
public class DataPresenter extends AbStractPresenter<Contract.View> implements Contract.Presenter {

    @Override
    public void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Observable<InfoBean> data = retrofit.create(ApiService.class).getData();
        data.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InfoBean infoBean) {
                        view.Success(infoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.Failed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
*/
