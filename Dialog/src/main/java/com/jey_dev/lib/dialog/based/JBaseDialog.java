package com.jey_dev.lib.dialog.based;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.jey_dev.lib.dialog.R;


/**
 * Created by jeyhoon on 15. 10. 28..
 */
public class JBaseDialog extends Dialog {
    public static final int STYLE_NORMAL=0;
    public static final int STYLE_JEY=1;
    protected Context ctx=null;
    public JBaseDialog(Context ctx){
        super(ctx, R.style.dialog);
        this.ctx=ctx;
    }
    public JBaseDialog(Context context, int style) {
        super(context,style);
        this.ctx=context;
    }
    public boolean isEmpty(String str){
        if(null==str||str.length()<=0||str.equals(""))
            return true;
        else
            return false;
    }
    public boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx.setTheme(R.style.dialog);
    }
}
