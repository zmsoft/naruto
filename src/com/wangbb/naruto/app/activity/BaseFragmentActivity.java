package com.wangbb.naruto.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.wangbb.naruto.app.NarutoApplication;


public class BaseFragmentActivity extends FragmentActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	    NarutoApplication.getInstance().setActivity(this);
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	

	protected void onStart() {
		//setReplyCallBack();
		super.onStart();
	}

	
    protected void onPause() {  
    	//MobclickAgent.onPause(this);
    	super.onPause();
    }  
	
	@Override
	public void onResume() {
		NarutoApplication.getInstance().addActivityStatus(this, true);
//		MobclickAgent.onResume(this);
//		SharedPreference.getInstance(NarutoApplication.getInstance()).recordTrace(SharedPreference.TRACE_ON_START,
//				mActivity.getClass().getName());
		super.onResume();
	}
	
	@Override
	public void onStop(){
		//dismissLoading();
		NarutoApplication.getInstance().addActivityStatus(this, false);
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}	
	
}
