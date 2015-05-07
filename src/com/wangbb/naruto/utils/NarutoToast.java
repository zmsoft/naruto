package com.wangbb.naruto.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.wangbb.naruto.app.NarutoApplication;

public class NarutoToast {

	static public void toastShow(final Context context,final int resId){
		toastShow(context, context.getResources().getString(resId));
	}
	
	static public void toastShow(final Context context,final String str){
		if(!TextUtils.isEmpty(str)){
			//BaseApplication.getApplication()
			Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
		}
	}
	
	static public void toastShow(final String str){
		Toast.makeText(NarutoApplication.getApplication(), str, Toast.LENGTH_SHORT).show();
	}
	
	static public void toastShow(final int resId){
		Toast.makeText(NarutoApplication.getApplication(),
                NarutoApplication.getApplication().getString(resId), Toast.LENGTH_SHORT).show();
	}
}
