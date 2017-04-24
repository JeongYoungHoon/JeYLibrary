package com.jey_dev.lib.dialog;

import android.app.Dialog;
import android.content.Context;

//import wenoun.in.library.R;

/**
 * Created by jeyhoon on 15. 11. 2..
 */
public class JProgressDialog extends Dialog {
    public JProgressDialog(Context ctx){
        super(ctx, R.style.jey_dialog);
        setContentView(R.layout.jey_dialog_progress);
        setCanceledOnTouchOutside(false);
    }

    public static JProgressDialog getProgressDialog(Context ctx) {
        JProgressDialog dialog=new JProgressDialog(ctx);
        return dialog;
    }
    public static JProgressDialog getProgressDialog(Context ctx,boolean isCanceldOnTouchOutside) {
        JProgressDialog dialog=new JProgressDialog(ctx);
        dialog.setCanceledOnTouchOutside(isCanceldOnTouchOutside);
        return dialog;
    }
}
