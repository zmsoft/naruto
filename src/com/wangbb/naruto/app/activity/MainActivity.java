package com.wangbb.naruto.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.wangbb.naruto.R;

public class MainActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {

        }

        return super.onTouchEvent(event);
    }

    public void likelistview(View v) {
        startActivity(new Intent(this, NewListViewActivity.class));
    }

    public void likegridview(View v) {
        startActivity(new Intent(this, NewGridViewActivty.class));
    }

    public void likestaggeredgrid(View v) {
        startActivity(new Intent(this, NewStaggeredGridActivity.class));
    }
}
