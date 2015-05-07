package com.wangbb.naruto.app.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.wangbb.naruto.R;
import com.wangbb.naruto.app.adapter.HomeAdapter;
import com.wangbb.naruto.utils.Utility;
import com.wangbb.naruto.view.DividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by wangbinbin on 15/5/7.
 */
public class NewListViewActivity extends BaseFragmentActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> list;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinearLayoutManager mLayoutManager;
    private boolean canLoadMore = true;
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_listview);

        list = new ArrayList<String>();
        initView();
        setListerner();
        initData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_listview, menu);
        return true;
    }

    private void setListerner() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                int totalItemCount = mLayoutManager.getItemCount();
                //lastVisibleItem >= totalItemCount - 4 表示剩下4个item自动加载，各位自由选择 dy>0 表示向下滑动
                if (lastVisibleItem >= totalItemCount - 4 && dy > 0) {
                    initData();//这里多线程也要手动控制isLoadingMore
                }
            }
        });
    }

    private void initView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.YELLOW);
//        mSwipeRefreshLayout.setProgressBackgroundColor(R.color.primary_dark_material_dark);
        mSwipeRefreshLayout.setProgressViewOffset(false, Utility.dip2px(1), Utility.dip2px(80));
        //下拉刷新距离对应系数  越大越难下拉
//        mSwipeRefreshLayout.setDistanceToTriggerSync(80);
        mSwipeRefreshLayout.setHorizontalFadingEdgeEnabled(true);
        mSwipeRefreshLayout.setHapticFeedbackEnabled(true);
        mSwipeRefreshLayout.setHasTransientState(true);
        mSwipeRefreshLayout.setHovered(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new HomeAdapter(this, list));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    protected void initData() {
        for (int i = 'A'; i < 'z'; i++) {
            list.add("" + (char) i);
        }
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }
}