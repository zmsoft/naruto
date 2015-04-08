/*
 * WelcomePagerAdapter.java
 * classes : com.wangbb.naruto.app.adapter.WelcomePagerAdapter
 * @author 王彬彬
 * V 1.0.0
 * Create at 2014-3-26 下午12:38:58
 */
package com.wangbb.naruto.app.adapter;

import java.util.List;

import android.animation.Animator;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.wangbb.naruto.R;

/**
 * com.wangbb.naruto.app.adapter.WelcomePagerAdapter
 * 
 * @author 王彬彬 <br/>
 *         create at 2014-3-26 下午12:38:58
 */
public class WelcomePagerAdapter extends PagerAdapter implements AnimationListener {
    private static final String TAG = "WelcomePagerAdapter";
    private List<View> mListViews;
    private Context context;
    private Animation animation1;
    private Animation animation2;
    private Animation animation3;
    private Animation animation4;
    private Animation animation5;
    private Animation animation6;
    private Animation animation7;
    private Animation animation8;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private ImageView iv5;
    private ImageView iv6;
    private ImageView iv7;
    private ImageView iv8;

    public WelcomePagerAdapter(Context context, List<View> mListViews) {
        this.context = context;
        this.mListViews = mListViews;// 构造方法，参数是我们的页卡，这样比较方便。
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mListViews.get(position));// 删除页卡
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) { // 这个方法用来实例化页卡
        View v = mListViews.get(position);

        if (position == 0) {

            iv1 = (ImageView) v.findViewById(R.id.ImageView01);
            // iv2 = (ImageView) v.findViewById(R.id.ImageView02);
            iv3 = (ImageView) v.findViewById(R.id.ImageView03);
            // iv4 = (ImageView) v.findViewById(R.id.ImageView04);
//            iv5 = (ImageView) v.findViewById(R.id.ImageView05);
            // iv6 = (ImageView) v.findViewById(R.id.ImageView06);
//            iv7 = (ImageView) v.findViewById(R.id.imageView1);
            // iv8 = (ImageView) v.findViewById(R.id.imageView2);
            animation1 = AnimationUtils.loadAnimation(context, R.anim.viewpager_scale1);
            animation1.setAnimationListener((AnimationListener) this);
            // animation2 = AnimationUtils.loadAnimation(context,
            // R.anim.viewpager_scale2);
            // animation2.setAnimationListener((AnimationListener) this);
//            animation3 = AnimationUtils.loadAnimation(context, R.anim.viewpager_scale3);
//            animation3.setAnimationListener((AnimationListener) this);
            // animation4 = AnimationUtils.loadAnimation(context,
            // R.anim.viewpager_scale4);
            // animation4.setAnimationListener((AnimationListener) this);
//            animation5 = AnimationUtils.loadAnimation(context, R.anim.viewpager_scale5);
//            animation5.setAnimationListener((AnimationListener) this);
            // animation6 = AnimationUtils.loadAnimation(context,
            // R.anim.viewpager_scale6);
            // animation6.setAnimationListener((AnimationListener) this);
//            animation7 = AnimationUtils.loadAnimation(context, R.anim.viewpager_scale7);
//            animation7.setAnimationListener((AnimationListener) this);
            // animation8 = AnimationUtils.loadAnimation(context,
            // R.anim.viewpager_scale8);
            // animation8.setAnimationListener((AnimationListener) this);
            iv1.setAnimation(animation1);
            // iv2.setAnimation(animation2);
//            iv3.setAnimation(animation3);
            // iv4.setAnimation(animation4);
//            iv5.setAnimation(animation5);
            // iv6.setAnimation(animation6);
//            iv7.setAnimation(animation7);
            // iv8.setAnimation(animation8);
            animation1.start();
            // animation2.start();
            // animation3.start();
            // animation4.start();
            // animation5.start();
            // animation6.start();
            // animation7.start();
            // animation8.start();
        }

        container.addView(v, 0);// 添加页卡
        return mListViews.get(position);
    }

    @Override
    public int getCount() {
        return mListViews.size();// 返回页卡的数量
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;// 官方提示这样写
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation.hashCode() == animation1.hashCode()) {
            animation3 = AnimationUtils.loadAnimation(context, R.anim.viewpager_scale3);
            animation3.setAnimationListener((AnimationListener) this);
            iv3.setAnimation(animation3);
            iv3.setVisibility(View.VISIBLE);
            // iv4.setVisibility(View.VISIBLE);
            animation3.start();
            // animation4.start();
//        } else if (animation.hashCode() == animation3.hashCode()) {
//            iv5.setVisibility(View.VISIBLE);
//            // iv6.setVisibility(View.VISIBLE);
//            animation5.start();
//            // animation6.start();
//        } else if (animation.hashCode() == animation5.hashCode()) {
//            iv7.setVisibility(View.VISIBLE);
//            // iv8.setVisibility(View.VISIBLE);
//            animation7.start();
            // animation8.start();
        }
    }
    @Override
    public void onAnimationRepeat(Animation animation) {
    }
    @Override
    public void onAnimationStart(Animation animation) {
        if (animation.hashCode() == animation1.hashCode()) {
            iv1.setVisibility(View.VISIBLE);
            // iv2.setVisibility(View.VISIBLE);
        } 
    }

}
