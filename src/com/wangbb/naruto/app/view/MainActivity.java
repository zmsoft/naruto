package com.wangbb.naruto.app.view;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;

import com.wangbb.naruto.R;
import com.wangbb.naruto.app.BaseActivity;

public class MainActivity extends BaseActivity implements OnClickListener {

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

    @Override
    public void onClick(View v) {

    }
}
