package com.example.chenduo.cdtemplate;

import android.app.Application;

/**
 * Created by chenduo on 16-11-25.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        sApp = this;
    }

    private static MyApplication sApp;

    public static Application getInstance() {
        return sApp;
    }

}
