package com.jey_dev.lib.view;

import android.content.Context;
import android.os.Build;
import android.util.TypedValue;

/**
 * Created by JeyHoon on 16. 6. 2..
 */
 class JImageUtils {
    protected static int dpToPx(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
    protected static boolean isOverAPI16(){
        return Build.VERSION.SDK_INT >= 16;
    }
}
