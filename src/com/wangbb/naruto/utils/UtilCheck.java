package com.wangbb.naruto.utils;

public class UtilCheck {
	static public Boolean checkSearch(String checkContents){
		if(checkContents.length()>=1){
			return true;
		}
		return false;
	}
}
