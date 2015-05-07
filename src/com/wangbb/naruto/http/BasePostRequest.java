package com.wangbb.naruto.http;

/**
 * Created by wangbinbin on 15/5/7.
 */

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.wangbb.naruto.utils.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * post������������� hashmap�������
 *
 */
public class BasePostRequest<T> extends BaseRequest<T> {

    private Gson mGson = new Gson();
    private Class<T> mClazz;
    private Response.Listener<T> mListener;
    private Map<String, String> mHeaders;
    private HashMap<String, String> parameterMap;
    private String interfaceNameForPrint;

    /**
     * ע���޸�Ϊpost ����
     *
     * @param url
     *            �����ַ+����
     * @param clazz
     *            ����JavaBeen��
     * @param listener
     *            ���ؽӿ� ���洫��
     * @param errorListener
     *            ����ӿ� ���洫��
     */
    public BasePostRequest(String url, Class<T> clazz, Response.Listener<T> listener,
                           Response.ErrorListener errorListener, HashMap<String, String> parameter,
                           String interfaceName) {
        this(Method.POST, url, clazz, null, listener, errorListener, parameter,
                interfaceName);

    }

    public BasePostRequest(int method, String url, Class<T> clazz,
                           Map<String, String> headers, Response.Listener<T> listener,
                           Response.ErrorListener errorListener, HashMap<String, String> parameter,
                           String interfaceName) {
        super(method, url, errorListener);
        this.mClazz = clazz;
        this.mHeaders = headers;
        this.mListener = listener;
        this.parameterMap = parameter;
        this.interfaceNameForPrint = interfaceName;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return mHeaders != null ? mHeaders : super.getHeaders();
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }

    // ������Ϣ
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

        try {
            String json = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            Logger.d("json----------------");
            Logger.d("json----" + interfaceNameForPrint + json);
            Logger.d("json----------------");
            return Response.success(mGson.fromJson(json, mClazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        StringBuilder keysValue = new StringBuilder();

        for (Map.Entry<String, String> entry : parameterMap.entrySet()) {
            keysValue.append(entry.getKey()).append("=")
                    .append(entry.getValue()).append("/");
        }
        Logger.d("keysValue: " + keysValue.toString());

        return parameterMap;
    }

    // ���ó�ʱʱ��
    @Override
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        return super.setRetryPolicy(retryPolicy);
    }

}