/*
 * LogUtil.java
 * classes : com.wangbb.naruto.utils.LogUtil
 * @author 王彬彬
 * V 1.0.0
 * Create at 2014-3-20 下午2:52:23
 */
package com.wangbb.naruto.utils;

import android.util.Log;

import com.wangbb.naruto.common.Config;

/**
 * com.wangbb.naruto.utils.LogUtil
 * 
 * @author 王彬彬 <br/>
 *         create at 2014-3-20 下午2:52:23
 */
public class LogUtil {

    public static void log(String tag, String log) {
        if (Config.isDebug) {
            Log.i(tag, log);
        }
    }
}

