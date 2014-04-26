/*
 * BaseActivity.java
 * classes : com.wangbb.naruto.app.BaseActivity
 * @author 王彬彬
 * V 1.0.0
 * Create at 2014-3-20 下午2:49:29
 */
package com.wangbb.naruto.app;

import com.wangbb.naruto.R;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

/**
 * 所有页面基类
 * com.wangbb.naruto.app.BaseActivity
 * @author 王彬彬 <br/>
 * create at 2014-3-20 下午2:49:29
 */
public class BaseActivity extends Activity {
    private static final String TAG = "BaseActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
    
    /*
     * check network
     */
    public static boolean isNetworkAvailable(Activity mActivity) { 
        Context context = mActivity.getApplicationContext(); 
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE); 
        if (connectivity == null) { 
            return false; 
        } else { 
            NetworkInfo[] info = connectivity.getAllNetworkInfo(); 
            if (info != null) { 
                for (int i = 0; i < info.length; i++) { 
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) { 
                        return true; 
                    } 
                } 
            } 
        } 
        return false; 
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        
    }
}
