package com.wangbb.naruto.http;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.wangbb.naruto.utils.Logger;

/**
 * 请求基类设置超时时间
 *
 * @param <T>
 */
public class BaseRequest<T> extends Request<T> {

    // 连接超时时间35000
    public static final int CONNECTION_TIME = 35000;

    public BaseRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }

    @Override
    protected void deliverResponse(T arg0) {

    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse arg0) {
        return null;
    }

    @Override
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        retryPolicy = new DefaultRetryPolicy(CONNECTION_TIME, 0, 1.0f);
        int a = retryPolicy.getCurrentRetryCount();
        Logger.d(a + "recount");
        return super.setRetryPolicy(retryPolicy);
    }

}
