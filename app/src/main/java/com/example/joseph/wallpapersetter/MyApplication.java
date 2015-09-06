package com.example.joseph.wallpapersetter;

import android.app.Application;
import android.content.Context;

/**
 * Created by Joseph on 9/5/15.
 */
public class MyApplication extends Application
{
    private static Context context;

    public void onCreate()
    {
        super.onCreate();
        MyApplication.context = context;
    }

    public static Context getContext()
    {
        return context;
    }
}
