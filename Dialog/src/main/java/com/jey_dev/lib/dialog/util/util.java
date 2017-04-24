package com.jey_dev.lib.dialog.util;

import android.content.Context;
import android.os.Build;
import android.util.TypedValue;

/**
 * Created by JeyHoon on 16. 4. 28..
 */
public class util {
    public static int dpToPx(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
    public static boolean checkApi(){
        if (Build.VERSION.SDK_INT >= 16) {
            return true;
        } else {
            return false;
        }
    }
}
