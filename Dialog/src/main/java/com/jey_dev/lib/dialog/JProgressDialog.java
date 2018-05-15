package com.jey_dev.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

//import wenoun.in.library.R;

/**
 * Created by jeyhoon on 15. 11. 2..
 */
public class JProgressDialog extends Dialog {
    private String titleStr="";
    private String msgStr="";
    private boolean isNotifyShow=false;
    private TextView titleView=null;
    private TextView msgView=null;
    private View notifyRoot=null;

    public JProgressDialog(Context ctx){
        super(ctx, R.style.jey_dialog);
        setContentView(R.layout.jey_dialog_progress);
        setCanceledOnTouchOutside(false);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout();
    }

    private void setLayout(){
        Log.d("JTest","setLayout()");
        notifyRoot=findViewById(R.id.jey_dialog_progress_notify_root);
        titleView = (TextView) findViewById(R.id.title_tv);
        msgView = (TextView) findViewById(R.id.msg_tv);
        Log.d("JTest","title : "+titleStr+", msg : "+msgStr+", isNotifyShow : "+isNotifyShow);
        if(isNotifyShow){
            if(isEmpty(titleStr)&&isEmpty(msgStr)){
                setNotifyShow(false);
//                isNotifyShow=false;
                notifyRoot.setVisibility(View.GONE);
            }else {
                notifyRoot.setVisibility(View.VISIBLE);
                if (isEmpty(titleStr))
                    findViewById(R.id.title_layout).setVisibility(View.GONE);
                else {
                    findViewById(R.id.title_layout).setVisibility(View.VISIBLE);
                    titleView.setText(titleStr);
                }
                msgView.setText(msgStr);
            }

        }else{
            notifyRoot.setVisibility(View.GONE);
        }
    }
    public boolean isEmpty(String str){
        if(null==str||str.length()<=0||str.equals(""))
            return true;
        else
            return false;
    }



    public JProgressDialog setNotifyShow(final boolean isNotifyShow){
        this.isNotifyShow=isNotifyShow;
        return this;
    }

    public JProgressDialog setTitle(final String title){
        Log.d("JTest","setTitle() title is "+title);
        if(!isEmpty(title)){
            setNotifyShow(true);
//            isNotifyShow=true;
            this.titleStr=title;
        }

        return this;
    }

    public JProgressDialog setMsg(final String msg){
        Log.d("JTest","setMsg() msg is "+msg);
        if(!isEmpty((msg))){
            setNotifyShow(true);
//            isNotifyShow=true;
            this.msgStr=msg;
        }
        return this;
    }

    public boolean isNotifyShow() {
        return isNotifyShow;
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
