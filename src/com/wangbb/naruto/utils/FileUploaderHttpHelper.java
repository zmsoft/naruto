package com.wangbb.naruto.utils;

public class FileUploaderHttpHelper {
    public static interface ProgressListener {
        public void transferred(long data);

        public void waitServerResponse();

        public void completed();
    }
}
