package com.lrb.shixunmvp.test.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initData();
    }

    protected abstract void initData();

    protected  void initView(){

    }

    protected abstract int getLayout();
}
