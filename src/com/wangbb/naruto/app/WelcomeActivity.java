package com.wangbb.naruto.app;

import android.content.Intent;
import android.os.Bundle;

import com.wangbb.naruto.R;
import com.wangbb.naruto.app.view.MainActivity;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//        initViews();
//        startAnim();
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
    }

    private void initViews() {

    }

    /**
     * 等待页面
     */
//    private void startAnim() {
//        AlphaAnimation showMainActivityAnimation = new AlphaAnimation(1.0f,
//                1.0f);
//        showMainActivityAnimation.setDuration(320);
//        showMainActivityAnimation.setFillAfter(true);
//        showMainActivityAnimation.setAnimationListener(new Animation.AnimationListener() {
//            public void onAnimationEnd(Animation animation) {
//                if (BaseActivity.isNetworkAvailable(WelcomeActivity.this)) {
//                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
//                    // overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
//                    finish();
//                }
//            }
//
//            public void onAnimationStart(Animation animation) {
//            }
//
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });
//    }
}
