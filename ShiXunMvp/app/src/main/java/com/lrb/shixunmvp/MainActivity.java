package com.lrb.shixunmvp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.lrb.form.ApiConfig;
import com.lrb.form.IPresenter;
import com.lrb.form.LoadTypeConfig;
import com.lrb.form.MyView;
import com.lrb.form.ParamHashMap;
import com.lrb.shixunmvp.test.adapter.RecyclerAdapter;
import com.lrb.shixunmvp.test.base.BaseMvpActivity;
import com.lrb.shixunmvp.test.contract.Contract;
import com.lrb.text.InfoBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseMvpActivity implements MyView {


    private RecyclerView recycler;
    private RecyclerAdapter recyclerAdapter;
    private int pageId;
    private IPresenter iPresenter;
    private SmartRefreshLayout smart;

    @Override
    protected Contract.BasePresenter initPresenter() {
        //V与M绑定
        /* return new DataPresenter();*/
        return null;
    }

    @Override
    protected void initView() {
        super.initView();

        recycler=findViewById(R.id.recycler);
        smart = findViewById(R.id.smart);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter(this);
        recycler.setAdapter(recyclerAdapter);

        final Map add = new ParamHashMap().add("c", "api").add("a", "getList");


        iPresenter = new IPresenter(this);
        iPresenter.getData(ApiConfig.TEST_GET, LoadTypeConfig.NORMAL,add,pageId);
        smart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                pageId++;
                iPresenter.getData(ApiConfig.TEST_GET, LoadTypeConfig.MORE,add,pageId);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageId = 0;
                iPresenter.getData(ApiConfig.TEST_GET, LoadTypeConfig.REFRESH,add,pageId);
            }
        });


    }

    @Override
    protected void initData() {
        //MVP调用方法获取数据
      /*  Contract.Presenter presenter = (Contract.Presenter) this.presenter;
        presenter.getData();*/

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(int whichApi, int loadType, Object[] v) {


                List<InfoBean.DatasBean> datas = ((InfoBean) v[0]).getDatas();
                if (loadType == LoadTypeConfig.MORE){
                    smart.finishLoadMore();
                    recyclerAdapter.addList(datas);
                } else if (loadType == LoadTypeConfig.REFRESH){
                    smart.finishRefresh();
                    recyclerAdapter.refresh(datas);
                }



    }

    @Override
    public void Failer(int whichApi, Throwable pThrowable) {

    }



  /*  //   获取数据成功
    public void Success(InfoBean infoBean) {

        List<Info> datas = infoBean.getDatas();
        Log.i("Tag",datas.toString());
        recyclerAdapter.addList(datas);
    }
    //获取失败 及失败信息
    @Override
    public void Failed(String msg) {

    }*/
}
