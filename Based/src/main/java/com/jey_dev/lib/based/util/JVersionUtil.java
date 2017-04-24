package com.jey_dev.lib.based.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by JeyHoon on 16. 6. 2..
 */
public class JVersionUtil {
    public static boolean isUpLol(){
        return Build.VERSION.SDK_INT>=21;
    }
    public static boolean isUpMash(){ return Build.VERSION.SDK_INT>=23; }
    public static final String getCurrentVersion(final Context ctx,final String initVersion){
        String version=initVersion;
        try {
            PackageInfo i = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
            version = i.versionName;
            return version;
        } catch(PackageManager.NameNotFoundException e) {
            return initVersion;
        }
    }
    public static final String getCurrentVersion(final Context ctx){
        return getCurrentVersion(ctx,"1.0.0");
    }
}
