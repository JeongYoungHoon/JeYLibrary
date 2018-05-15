package com.jey_dev.lib.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

import com.jey_dev.lib.dialog.adapter.JPermissionNotifyAdapter;
import com.jey_dev.lib.dialog.based.JBaseDialog;
import com.jey_dev.lib.dialog.data.JPermissionNotifyData;

import java.util.ArrayList;

//import wenoun.in.library.R;

public class JPermissionNotifyDialog extends JBaseDialog {



	private ArrayList<JPermissionNotifyData> dataList=new ArrayList<>();
	private JPermissionNotifyAdapter Adapter=null;

	private RecyclerView recyclerView=null;

	private boolean hasSms=false;
	private boolean hasCall=false;
	private boolean hasCamera=false;
	private boolean hasLocation=false;
	private boolean hasStorage=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
		lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
		lpWindow.dimAmount = 0.8f;
		getWindow().setAttributes(lpWindow);
		setContentView(R.layout.dialog_permission_notify);
		setLayout();

//		Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE


	}
	public JPermissionNotifyDialog(Context context){
		super(context,R.style.TranslucentTheme);
		this.ctx=context;
	}
	private Context ctx;
	private View agreeView=null;

	public JPermissionNotifyDialog addCamera(final boolean isNecessary, final String desc){
		if(!hasCamera){
			hasCamera=true;
			return addPermission(com.jey_dev.lib.dialog.R.drawable.ic_photo_camera_dark_gray_24dp, com.jey_dev.lib.dialog.R.string.permission_camera_name,isNecessary,desc);
		}else{
			return this;
		}
	}
	public JPermissionNotifyDialog addSms(final boolean isNecessary, final String desc){
		if(!hasSms){
			hasSms=true;
			return addPermission(com.jey_dev.lib.dialog.R.drawable.ic_sms_dark_gray_24dp, com.jey_dev.lib.dialog.R.string.permission_sms_name,isNecessary,desc);
		}else{
			return this;
		}
	}
	public JPermissionNotifyDialog addCall(final boolean isNecessary, final String desc){
		if(!hasCall){
			hasCall=true;
			return addPermission(com.jey_dev.lib.dialog.R.drawable.ic_call_dark_gray_24dp, com.jey_dev.lib.dialog.R.string.permission_call_name,isNecessary,desc);
		}else{
			return this;
		}
	}
	public JPermissionNotifyDialog addLocation(final boolean isNecessary, final String desc){
		if(!hasLocation){
			hasLocation=true;
			return addPermission(com.jey_dev.lib.dialog.R.drawable.ic_location_on_dark_gray_24dp, com.jey_dev.lib.dialog.R.string.permission_location_name,isNecessary,desc);
		}else{
			return this;
		}
	}
	public JPermissionNotifyDialog addStorage(final boolean isNecessary, final String desc){
		if(!hasStorage){
			hasStorage=true;
			return addPermission(com.jey_dev.lib.dialog.R.drawable.ic_folder_dark_gray_24dp, com.jey_dev.lib.dialog.R.string.permission_storage_name,isNecessary,desc);
		}else{
			return this;
		}
	}

	private JPermissionNotifyDialog addPermission(final int icResId, final int nameStrId, boolean isNecessary, String desc){
		final JPermissionNotifyData data=new JPermissionNotifyData(icResId,nameStrId,isNecessary,desc);
		dataList.add(data);
		return this;
	}
	/*
	 * Layout
	 */
	private void setLayout() {
		agreeView=findViewById(R.id.dialog_permission_notify_agree);
		recyclerView=(RecyclerView)findViewById(R.id.dialog_permission_notify_rv);
		recyclerView.setLayoutManager(new LinearLayoutManager(ctx));

		Adapter=new JPermissionNotifyAdapter(ctx,dataList);
		recyclerView.setAdapter(Adapter);

		agreeView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				listener.onAgree(JPermissionNotifyDialog.this);
			}
		});

	}

	OnJPermissionNotifyListener listener = new OnJPermissionNotifyListener() {
		@Override
		public void onAgree(JPermissionNotifyDialog d) {
			d.dismiss();
		}

		@Override
		public void onDisagree(JPermissionNotifyDialog d) {

		}
	};


	public JPermissionNotifyDialog setAgreeListener(OnJPermissionNotifyListener listener){
		this.listener=listener;
		return this;
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		listener.onDisagree(JPermissionNotifyDialog.this);
	}

	public interface OnJPermissionNotifyListener{
		public void onAgree(JPermissionNotifyDialog d);
		public void onDisagree(JPermissionNotifyDialog d);
	}
}
