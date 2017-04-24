package com.jey_dev.lib.dialog.toast;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jey_dev.lib.dialog.R;


/**
 * Created by JeyHoon on 16. 4. 28..
 */
public class JToast {
    public static final int TYPE_JEY=JeYToast.TYPE_JEY;
    public static final int TYPE_JEY_TR=JeYToast.TYPE_JEY_TR;
    public static final int TYPE_WHITE=JeYToast.TYPE_WHITE;
    public static final int TYPE_WHITE_TR=JeYToast.TYPE_WHITE_TR;
    public static final int TYPE_BLACK=JeYToast.TYPE_BLACK;
    public static final int TYPE_BLACK_TR=JeYToast.TYPE_BLACK_TR;
    public static final int TEXT_BLACK=0xFF000000;
    public static final int TEXT_WHITE=0xFFFFFFFF;
    private Context ctx=null;
    public JToast(Context ctx){
        this.ctx=ctx;
    }
    public void showToast(String msg){
        showToast(ctx,msg,TYPE_JEY, Toast.LENGTH_SHORT);
    }
    public static void show(@NonNull Context ctx, View view, @NonNull String msg){
        if(null==view){
            showToast(ctx,msg,TYPE_JEY, Toast.LENGTH_SHORT);
        }else{
            show(ctx, view, msg, TYPE_JEY, Snackbar.LENGTH_LONG);
        }
    }
    public static void show(@NonNull Context ctx, View view, @NonNull String msg, @NonNull int duration){
        if(null==view){
            showToast(ctx,msg,TYPE_JEY,duration);
        }else{
            show(ctx, view, msg, TYPE_JEY, duration);
        }
    }
    public static void show(@NonNull Context ctx, View view, @NonNull String msg, @NonNull int type, @NonNull int duration){
        if(Build.VERSION.SDK_INT<21){
            showToast(ctx, msg, type, duration);
        }else{
            showSnackBar(view,msg,type,duration);
        }
    }
    private static void showToast(Context ctx, String msg, int type, int duration){
        new JeYToast(ctx).showToast(msg,type,duration);
    }
    private static void showSnackBar(View view, String msg, int type, int duration){
        int colorId= R.color.colorJeY;
        int textColor=TEXT_WHITE;
        switch(type){
            case TYPE_BLACK:
                colorId=R.color.colorBlack;
                textColor=TEXT_WHITE;
                break;
            case TYPE_BLACK_TR:
                colorId=R.color.colorBlackHalf;
                textColor=TEXT_WHITE;
                break;
            case TYPE_JEY:
                colorId=R.color.colorJeY;
                textColor=TEXT_WHITE;
                break;
            case TYPE_JEY_TR:
                colorId=R.color.colorJeYHalf;
                textColor=TEXT_WHITE;
                break;
            case TYPE_WHITE:
                colorId=R.color.colorWhite;
                textColor=TEXT_BLACK;
                break;
            case TYPE_WHITE_TR:
                colorId=R.color.colorWhiteHalf;
                textColor=TEXT_BLACK;
                break;
            default:
                colorId=type;
                textColor=TEXT_WHITE;
                break;
        }
        Snackbar snackbar=Snackbar.make(view, msg, duration);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        layout.setBackgroundResource(colorId);
        TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextSize(20);
        textView.setTextColor(textColor);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.FAKE_BOLD_TEXT_FLAG);
        snackbar
                .show(); // show 까먹지 마세요!
    }
}
