package com.jey_dev.lib.based.util;

import android.os.Build;

/**
 * Created by JeyHoon on 16. 6. 2..
 */
public class JVersionUtil {
    public static boolean isUpLol(){
        return Build.VERSION.SDK_INT>=21;
    }
    public static boolean isUpMash(){ return Build.VERSION.SDK_INT>=23; }
}
