package com.jey_dev.lib.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.jey_dev.lib.dialog.based.JBaseDialog;
import com.jey_dev.lib.dialog.based.JDialogInterface;

public class JAlertDialog extends JBaseDialog {
	private int styleId= R.style.TranslucentTheme;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ctx.setTheme(styleId);
		super.onCreate(savedInstanceState);
		WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
		lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
		lpWindow.dimAmount = 0.8f;
		getWindow().setAttributes(lpWindow);
		setContentView(R.layout.dialog_alert);
		setLayout();


	}
	public JAlertDialog(Context context){
		this(context, STYLE_NORMAL);
	}
	public JAlertDialog(Context context, int style) {
		super(context,R.style.TranslucentTheme);
		// Dialog 배경을 투명 처리 해준다.
		this.ctx = getContext();
		if(style==STYLE_NORMAL) {
			this.styleId=R.style.TranslucentTheme;
		}else if(style==STYLE_JEY){
			this.styleId=R.style.JeYTranslucentTheme;
		}
	}
	private TextView titleTv;
	private TextView msgTv;
	private TextView closeButton;
	private String titleStr;
	private String msgStr;
	private String closeStr;
	private Context ctx;
	/*
	 * Layout
	 */
	private void setLayout() {
		titleTv = (TextView) findViewById(R.id.title_tv);
		msgTv = (TextView) findViewById(R.id.msg_tv);
		closeButton=(TextView)findViewById(R.id.close_button);
		if(isEmpty(titleStr))
			findViewById(R.id.title_layout).setVisibility(View.GONE);
		else {
			findViewById(R.id.title_layout).setVisibility(View.VISIBLE);
			titleTv.setText(titleStr);
		}
		msgTv.setText(msgStr);
		if(!isEmpty(closeStr))
			closeButton.setText(closeStr);

		closeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (null != closeClickListener) {
					closeClickListener.onClick(JAlertDialog.this, v);
				}else{
					dismiss();
				}
			}
		});
	}
	JDialogInterface.OnButtonClickListener closeClickListener=null;
	public JAlertDialog setTitle(String str){
		titleStr=str;
		return this;
	}
	public JAlertDialog setMsg(String str){
		msgStr=str;
		return this;
	}
	public JAlertDialog setClose(String str, final JDialogInterface.OnButtonClickListener closeClickListener){
		this.closeClickListener=closeClickListener;
		this.closeStr=str;

		return this;
	}
}
