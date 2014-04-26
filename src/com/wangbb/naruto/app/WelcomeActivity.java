package com.wangbb.naruto.app;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.wangbb.naruto.R;
import com.wangbb.naruto.app.adapter.WelcomePagerAdapter;
import com.wangbb.naruto.app.view.MainActivity;

public class WelcomeActivity extends BaseActivity {
    private static final String TAG = "WelcomeActivity";
    // private RelativeLayout welcome;
    private ViewPager vp;
    private ArrayList<View> viewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initPagers();
        initViews();
        // startAnim();
    }

    /**
     * 加载欢迎页页面
     */
    private void initPagers() {
        LayoutInflater lf = getLayoutInflater().from(this);
        View view1 = lf.inflate(R.layout.viewpager_item1, null);
        View view2 = lf.inflate(R.layout.viewpager_item2, null);
        View view3 = lf.inflate(R.layout.viewpager_item3, null);

        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
    }

    private void initViews() {
        // welcome = (RelativeLayout)findViewById(R.id.welcome);

        vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new WelcomePagerAdapter(this, viewList));
        vp.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                View v = viewList.get(1);
                Button bt = (Button) v.findViewById(R.id.button1);
                TranslateAnimation translateAnimation = new TranslateAnimation(0f, 100f, 100.0f, 0.0f);
                bt.setAnimation(translateAnimation);
                translateAnimation.start();
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                Log.i("info", arg0 + "    " + arg1 + "     " + arg2);

                View v = viewList.get(1);
                Button bt = (Button) v.findViewById(R.id.button1);
                // TranslateAnimation translateAnimation = new
                // TranslateAnimation(0f, arg1, 100.0f, 0.0f);
                // bt.setAnimation(translateAnimation);
                // translateAnimation.start();
                bt.layout(arg2, 200, arg2+100, 200);
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    public void onClick(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }

    /**
     * 等待页面
     */
    // private void startAnim() {
    // AlphaAnimation showMainActivityAnimation = new AlphaAnimation(1.0f,
    // 1.0f);
    // showMainActivityAnimation.setDuration(3000);
    // showMainActivityAnimation.setFillAfter(true);
    // welcome.startAnimation(showMainActivityAnimation);
    // showMainActivityAnimation.setAnimationListener(new AnimationListener() {
    // public void onAnimationEnd(Animation animation) {
    // if(BaseActivity.isNetworkAvailable(WelcomeActivity.this)){
    // startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
    // // overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    // finish();
    // }else{
    // // startActivity(new Intent(WelcomeActivity.this,
    // NetworkErrorActivity.class));
    // // overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    // // finish();
    // startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
    // // overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    // finish();
    // }
    // }
    // public void onAnimationStart(Animation animation) {
    // }
    // public void onAnimationRepeat(Animation animation) {
    // }
    // });
    // }
}
