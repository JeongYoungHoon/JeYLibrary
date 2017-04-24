package com.jey_dev.lib.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.jey_dev.lib.dialog.based.JBaseDialog;
import com.jey_dev.lib.dialog.based.JDialogInterface;

//import wenoun.in.library.R;

public class JTextInputDialog extends JBaseDialog {
//	public static final int STYLE_TANSAN=0;
//	public static final int STYLE_WEMOM=1;
	private int styleId= R.style.TranslucentTheme;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ctx.setTheme(styleId);
		super.onCreate(savedInstanceState);
		WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
		lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
		lpWindow.dimAmount = 0.8f;
		getWindow().setAttributes(lpWindow);
		setContentView(R.layout.dialog_edittext);
		setLayout();


	}
	public JTextInputDialog(Context context){
		this(context, STYLE_NORMAL);
	}
	public JTextInputDialog(Context context, String editMsg){
		this(context, STYLE_NORMAL,editMsg);
	}
	public JTextInputDialog(Context context, int style) {
		super(context,R.style.TranslucentTheme);
		// Dialog 배경을 투명 처리 해준다.
		this.ctx = getContext();
		if(style==STYLE_NORMAL) {
			this.styleId=R.style.TranslucentTheme;
		}else if(style==STYLE_JEY){
			this.styleId=R.style.JeYTranslucentTheme;
		}
	}
	public JTextInputDialog(Context context, int style, String editMsg) {
		this(context,style);
		this.editMsg=editMsg;
	}
	private TextView titleTv;
	private TextView msgTv;
	private EditText et;
	private TextView confirmButton;
	private TextView cancelButton;
	private String titleStr;
	private String msgStr;
	private String confirmStr;
	private String cancelStr;
	private Context ctx;
	private String editMsg="";
	/*
	 * Layout
	 */
	private void setLayout() {
		titleTv = (TextView) findViewById(R.id.title_tv);
		msgTv = (TextView) findViewById(R.id.msg_tv);
		et=(EditText)findViewById(R.id.et);
		confirmButton=(TextView)findViewById(R.id.confirm_button);
		cancelButton=(TextView)findViewById(R.id.cancel_button);
		if(null!=editMsg){
			et.setText(editMsg);
		}
		if(isEmpty(titleStr))
			findViewById(R.id.title_layout).setVisibility(View.GONE);
		else {
			findViewById(R.id.title_layout).setVisibility(View.VISIBLE);
			titleTv.setText(titleStr);
		}
		msgTv.setText(msgStr);
		if(null==msgStr||msgStr.length()<=0||msgStr.isEmpty())
			msgTv.setVisibility(View.GONE);
		if(!isEmpty(confirmStr))
			confirmButton.setText(confirmStr);
		confirmButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (null != confirmClickListener) {
					confirmClickListener.onConfirm(JTextInputDialog.this, et.getText().toString(),v);
				}
			}
		});
		if(!isEmpty(cancelStr))
			cancelButton.setText(cancelStr);
		cancelButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(null!=cancelClickListener){
					cancelClickListener.onClick(JTextInputDialog.this,v);
				}else{
					JTextInputDialog.this.cancel();
				}
			}
		});
	}
	JDialogInterface.OnEditConfirmListener confirmClickListener=null;
	JDialogInterface.OnButtonClickListener cancelClickListener=null;
	public JTextInputDialog setTitle(String str){
		titleStr=str;
		return this;
	}
	public JTextInputDialog setMsg(String str){
		msgStr=str;
		return this;
	}
	public JTextInputDialog setConfirm(String str, final JDialogInterface.OnEditConfirmListener confirmClickListener){
		this.confirmClickListener=confirmClickListener;
		this.confirmStr=str;

		return this;
	}
	public JTextInputDialog setCancel(String str, final JDialogInterface.OnButtonClickListener cancelClickListener){
		this.cancelClickListener=cancelClickListener;
		this.cancelStr=str;

		return this;
	}
}
