package com.nelson.roomsample;

import android.app.Application;
import android.content.Context;

/**
 * Created by Nelson on 2020/3/7.
 */
class ContextGetter {

    private static Context CONTEXT_INSTANCE;

    public ContextGetter() {
    }

    public static Context getContext() {
        if (CONTEXT_INSTANCE == null) {
            Class var0 = ContextGetter.class;
            synchronized (ContextGetter.class) {
                if (CONTEXT_INSTANCE == null) {
                    try {
                        Application app = getApplicationUsingReflection();
                        CONTEXT_INSTANCE = app.getApplicationContext();
                    } catch (Exception var3) {
                        var3.printStackTrace();
                    }
                }
            }
        }

        return CONTEXT_INSTANCE;
    }

    private static Application getApplicationUsingReflection() throws Exception {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke((Object) null, (Object[]) null);
    }
}
