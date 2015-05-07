package com.wangbb.naruto.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import java.util.HashMap;

/**
 * Created by wangbinbin on 15/4/15.
 */
public class DataViewHolder extends RecyclerView.ViewHolder {
    private View convertView;
    private SparseArray<View> mapView = new SparseArray<View>();
    private HashMap<String, Object> mapData = new HashMap<String, Object>();
    
    public DataViewHolder(View convertView){
        super(convertView);
        this.convertView = convertView;
    }

    public <T extends View> T getView(int key) {
        View view = this.mapView.get(key);
        if(view == null) {
            view = convertView.findViewById(key);
            mapView.put(key, view);
        }
        return (T) view;
    }

    public <T> T getView(Class<T> clazz, int key) {
        View view = this.mapView.get(key);
        if(view == null) {
            view = convertView.findViewById(key);
            mapView.put(key, view);
        }
        return (T) view;
    }

    public void setData(String key, Object value) {
        mapData.put(key, value);
    }

    public <T> T getData(String key) {
        return (T) mapData.get(key);
    }

    public <T> T getData(Class<T> clazz, String key) {
        return (T) mapData.get(key);
    }
}
