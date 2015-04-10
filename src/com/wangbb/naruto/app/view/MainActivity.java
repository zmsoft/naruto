package com.wangbb.naruto.app.view;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

import com.wangbb.naruto.R;
import com.wangbb.naruto.app.BaseActivity;
import com.wangbb.naruto.app.module.SlidingMenu;
import com.wangbb.naruto.app.module.SlidingMenu.OnCloseListener;
import com.wangbb.naruto.app.module.SlidingMenu.OnClosedListener;
import com.wangbb.naruto.app.module.SlidingMenu.OnOpenListener;
import com.wangbb.naruto.app.module.SlidingMenu.OnOpenedListener;

public class MainActivity extends BaseActivity implements OnClickListener {

    private ImageButton mImageButtonLeft;
    private ImageButton mImageButtonRight;
    private SlidingMenu menu;
    private MotionEvent e1;
    private MotionEvent e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = new SlidingMenu(this);
        mImageButtonLeft = (ImageButton) findViewById(R.id.btn_left);
        mImageButtonRight = (ImageButton) findViewById(R.id.btn_right);
        mImageButtonLeft.setOnClickListener(this);
        mImageButtonRight.setOnClickListener(this);
        /** 不能既使用behindOffset，又使用behindWidth。如果你这样做，程序会抛出异常 */
        menu.setMode(SlidingMenu.LEFT_RIGHT);// 侧滑模式（左，右，左右同时打开）
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);// 设置是全屏启用，还是在某一视图中启用
        menu.setShadowWidthRes(R.dimen.shadow_width);// 设置阴影宽度
        menu.setShadowDrawable(R.drawable.shadow);// 设置左边阴影
        menu.setSecondaryShadowDrawable(R.drawable.shadow_right);// 设置右边阴影
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);// 设置侧滑菜相对于屏幕的距离
        menu.setFadeDegree(0.5f);// 滑动过程中的渐变程度
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);// SLIDING_WINDOW会在SlidingMenu的内容部分包含ActionBar，而SLIDING_CONTENT不会
        // 当上面的视图显示时，它指定了屏幕的哪部分是可触摸的。margin意味着只有左边缘。fullscreen意味着整个屏幕
        // 有这三中枚举，TOUCHMODE_FULLSCREEN TOUCHMODE_MARGIN TOUCHMODE_NONE
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setMenu(R.layout.slidingmenu_left); // 设置左侧视图
        menu.setSecondaryMenu(R.layout.slidingmenu_right);// 设置右侧视图
        initMenuListener();
    }

    private boolean isScrollingLeft(MotionEvent e1, MotionEvent e2) {
        return e2.getX() > e1.getX();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                e1 = event;
                break;
            case MotionEvent.ACTION_UP:
                e2 = event;

                if (isScrollingLeft(e1, e2)) {
                    this.menu.showMenu();
                } else {
                    this.menu.showSecondaryMenu();
                }

                // if (e2.getX()>e1.getX()) {
                // this.menu.showMenu();
                // } else {
                // this.menu.showSecondaryMenu();
                // }
                
                break;
        }

        return super.onTouchEvent(event);
    }

    public void initMenuListener() {
        /**
         * 打开左侧布局
         */
        menu.setOnOpenListener(new OnOpenListener() {

            @Override
            public void onOpen() {
                Toast.makeText(MainActivity.this, "打开了左侧布局", Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * 打开右侧布局
         */
        menu.setSecondaryOnOpenListner(new OnOpenListener() {

            @Override
            public void onOpen() {
                Toast.makeText(MainActivity.this, "打开了右侧布局", Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * 关闭侧滑
         */
        menu.setOnCloseListener(new OnCloseListener() {

            @Override
            public void onClose() {
                Toast.makeText(MainActivity.this, "关闭侧滑", Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * 不分左右，只要侧滑打开就调用
         */
        menu.setOnOpenedListener(new OnOpenedListener() {

            @Override
            public void onOpened() {
                Toast.makeText(MainActivity.this, "setOnOpenedListener", Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * 不分左右，只要侧滑关闭就调用
         */
        menu.setOnClosedListener(new OnClosedListener() {

            @Override
            public void onClosed() {
                Toast.makeText(MainActivity.this, "setOnClosedListener", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                menu.showMenu();
                break;

            case R.id.btn_right:
                menu.showSecondaryMenu();
                break;
        }
    }
}
