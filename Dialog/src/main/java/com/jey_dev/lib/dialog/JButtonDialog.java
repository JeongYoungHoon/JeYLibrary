package com.jey_dev.lib.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.jey_dev.lib.dialog.based.JBaseDialog;
import com.jey_dev.lib.dialog.based.JDialogInterface;
import com.jey_dev.lib.dialog.util.util;


public class JButtonDialog extends JBaseDialog {
    //	public static final int STYLE_TANSAN=0;
//	public static final int STYLE_WEMOM=1;
//	public static final int STYLE_TR=2;
    private int styleId = R.style.TranslucentTheme;

    //	private boolean isTr=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ctx.setTheme(styleId);
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.dialog_button);
        setLayout();


    }

    public JButtonDialog(Context context) {
        this(context, STYLE_NORMAL);
    }

    public JButtonDialog(Context context, int style) {
        super(context, R.style.TranslucentTheme);
        // Dialog 배경을 투명 처리 해준다.
        this.ctx = getContext();
        if (style == STYLE_NORMAL) {
            this.styleId = R.style.TranslucentTheme;
        } else if (style == STYLE_JEY) {
            this.styleId = R.style.JeYTranslucentTheme;
        }
    }

    private TextView titleTv;
    private TextView msgTv;
    private TextView confirmButton;
    private TextView cancelButton;
    private String titleStr;
    private String msgStr;
    private String confirmStr;
    private String cancelStr;
    private Context ctx;

    /*
     * Layout
     */
    private void setLayout() {
        titleTv = (TextView) findViewById(R.id.title_tv);
        msgTv = (TextView) findViewById(R.id.msg_tv);
        confirmButton = (TextView) findViewById(R.id.confirm_button);
        cancelButton = (TextView) findViewById(R.id.cancel_button);
        if (isEmpty(titleStr))
            findViewById(R.id.title_layout).setVisibility(View.GONE);
        else {
            findViewById(R.id.title_layout).setVisibility(View.VISIBLE);
            titleTv.setText(titleStr);
        }
        msgTv.setText(msgStr);
        if (!isEmpty(confirmStr))
            confirmButton.setText(confirmStr);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != confirmClickListener) {
                    confirmClickListener.onClick(JButtonDialog.this, v);
                }
            }
        });
        if (!isEmpty(cancelStr))
            cancelButton.setText(cancelStr);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != cancelClickListener) {
                    cancelClickListener.onClick(JButtonDialog.this, v);
                } else {
                    JButtonDialog.this.cancel();
                }
            }
        });
        cancelButton.setBackgroundResource(R.color.colorTr);
        confirmButton.setBackgroundResource(R.color.colorTr);
        confirmButton.setPadding(util.dpToPx(ctx, 5), util.dpToPx(ctx, 5), util.dpToPx(ctx, 10), util.dpToPx(ctx, 5));
    }

    JDialogInterface.OnButtonClickListener confirmClickListener = null;
    JDialogInterface.OnButtonClickListener cancelClickListener = null;

    public JButtonDialog setTitle(String str) {
        titleStr = str;
        return this;
    }

    public JButtonDialog setMsg(String str) {
        msgStr = str;
        return this;
    }

    public JButtonDialog setConfirm(String str, final JDialogInterface.OnButtonClickListener confirmClickListener) {
        this.confirmClickListener = confirmClickListener;
        this.confirmStr = str;

        return this;
    }

    public JButtonDialog setCancel(String str, final JDialogInterface.OnButtonClickListener cancelClickListener) {
        this.cancelClickListener = cancelClickListener;
        this.cancelStr = str;

        return this;
    }
}
