package com.lrb.form.service;


import com.lrb.text.InfoBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {


    public String baseUrl="http://static.owspace.com/";

    @GET("?c=api&a=getList&page_id=0")
    Observable<InfoBean> getData(@QueryMap HashMap<String,Object> hashMap, @Query("page_id") int id);
}
