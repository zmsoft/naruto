package com.wangbb.naruto.app.adapter;

/**
 * Created by wangbinbin on 15/5/7.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangbb.naruto.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<DataViewHolder> {

    private Context context;
    private ArrayList<String> list;

    public HomeAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DataViewHolder holder = new DataViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.getView(TextView.class, R.id.num).setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}