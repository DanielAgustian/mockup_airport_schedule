package com.example.penjadwalan_airport;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Controller extends Application{
    private static final String TAG = Application.class.getSimpleName();
    private static Controller instance;

    RequestQueue mReqQue;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized Controller getInstance(){
        return instance;
    }

    private RequestQueue getRequestQueue(){
        if(mReqQue == null){
            mReqQue = Volley.newRequestQueue(getApplicationContext());
        }
        return mReqQue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag){
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> reg){
        reg.setTag(TAG);
        getRequestQueue().add(reg);
    }

    public void cancelAllRequest(Object reg){
        if(mReqQue != null){
            mReqQue.cancelAll(reg);
        }
    }

}
