package com.wangbb.naruto.app.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wangbb.naruto.R;
import com.wangbb.naruto.app.adapter.HomeAdapter;
import com.wangbb.naruto.view.DividerGridItemDecoration;

import java.util.ArrayList;

/**
 * Created by wangbinbin on 15/5/7.
 */
public class NewGridViewActivty extends Activity {

    private RecyclerView mRecyclerView;
    private ArrayList<String> list;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinearLayoutManager mLayoutManager;
    private boolean canLoadMore = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        list = new ArrayList<String>();
        initView();
        setListerner();
        initData();
    }

    private void setListerner() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000l);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mSwipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                }.start();
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
                //lastVisibleItem >= totalItemCount - 4 ��ʾʣ��4��item�Զ����أ���λ����ѡ�� dy>0 ��ʾ���»���
                if (lastVisibleItem >= totalItemCount - 4 && dy > 0) {
                    initData();//������߳�ҲҪ�ֶ�����isLoadingMore
                }
            }
        });
    }

    private void initView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.YELLOW);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //�������ȷ��ÿ��item�ĸ߶��ǹ̶��ģ��������ѡ������������
        mRecyclerView.setHasFixedSize(false);

        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new HomeAdapter(this, list));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
    }

    protected void initData() {
        for (int i = 'A'; i < 'z'; i++) {
            list.add("" + (char) i);
        }
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }
}