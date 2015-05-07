package com.wangbb.naruto.http;

import android.net.Uri;

import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.wangbb.naruto.app.NarutoApplication;
import com.wangbb.naruto.common.Config;
import com.wangbb.naruto.utils.Logger;

/**
 * Created by wangbinbin on 15/5/7.
 */
public class Requester {
    private static void addRequest(int requestMethod, String tag,
                                   boolean shouldCache, boolean isForceRefresh, String url,
                                   final Response.Listener<String> listener,
                                   final Response.ErrorListener errorListener) {
        Logger.e("request url=" + url);
        StringRequest stringRequest = new StringRequest(requestMethod, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 != null)
                            Logger.e("response=" + arg0.toString());
                        if (listener != null)
                            listener.onResponse(arg0);
                    }

                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Logger.e("response error " + error);
                if (errorListener != null)
                    errorListener.onErrorResponse(error);
            }

        });
//		 RetryPolicy retryPolicy = new DefaultRetryPolicy(10000, 0, 1.0f);
//		 stringRequest.setRetryPolicy(retryPolicy);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(300000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        stringRequest.setTag(tag);
        stringRequest.setShouldCache(shouldCache);
        if (shouldCache) {
            if (isForceRefresh)
                forceRefresh(url);
        }
        NarutoApplication.mVolleyQueue.add(stringRequest);
    }

    public static void cancel(String tag) {
        NarutoApplication.mVolleyQueue.cancelAll(tag);
    }

    //

    /**
     * Ç¿ÖÆË¢ÐÂ
     *
     * @param url
     */
    public static void forceRefresh(String url) {
        final Cache.Entry entry = NarutoApplication.mVolleyQueue.getCache().get(url);
        if (entry != null && entry.data != null && entry.data.length > 0)
            if (!entry.isExpired()) {
                NarutoApplication.mVolleyQueue.getCache().invalidate(url, true);
            }
    }


    // ËÑË÷
    public static void TourData(String tag, boolean shouldCache, boolean isForceRefresh, int count, String keyword, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        String url = Config.SERVER_ADDR + "api/TourData";
        Uri.Builder builder = Uri.parse(url).buildUpon();
        builder.appendQueryParameter("count", "" + count);
        builder.appendQueryParameter("keyword", keyword);
        addRequest(Request.Method.GET, tag, shouldCache, isForceRefresh, builder.toString(), listener, errorListener);
    }

}

