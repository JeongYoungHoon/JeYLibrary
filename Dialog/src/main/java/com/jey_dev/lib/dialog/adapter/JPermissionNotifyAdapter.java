package com.jey_dev.lib.dialog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jey_dev.lib.dialog.R;
import com.jey_dev.lib.dialog.data.JPermissionNotifyData;

import java.util.ArrayList;

/**
 * Created by JeYHoon on 2018. 1. 13..
 */

public class JPermissionNotifyAdapter extends JBasedRecyclerAdapter<JPermissionNotifyAdapter.JPermissionViewHolder,JPermissionNotifyData> {

    public JPermissionNotifyAdapter(Context ctx, ArrayList<JPermissionNotifyData> dataList, JBasedRecyclerAdapterInterface.OnItemClickListener onItemClickListener, JBasedRecyclerAdapterInterface.OnItemLongClickListener onItemLongClickListener) {
        super(ctx, dataList, onItemClickListener, onItemLongClickListener);
    }

    public JPermissionNotifyAdapter(Context ctx, ArrayList<JPermissionNotifyData> dataList, JBasedRecyclerAdapterInterface.OnItemClickListener onItemClickListener) {
        super(ctx, dataList, onItemClickListener);
    }

    public JPermissionNotifyAdapter(Context ctx, ArrayList<JPermissionNotifyData> dataList, JBasedRecyclerAdapterInterface.OnItemLongClickListener onItemLongClickListener) {
        super(ctx, dataList, onItemLongClickListener);
    }

    public JPermissionNotifyAdapter(Context ctx, ArrayList<JPermissionNotifyData> dataList) {
        super(ctx, dataList);
    }

    @Override
    public void onBindJViewHolder(JPermissionViewHolder holder, int position) {
        final JPermissionNotifyData data=getItem(position);
        if(data.isNecessary()) {
            holder.necessaryView.setTextColor(ctx.getResources().getColor(R.color.colorRed));
            holder.necessaryView.setText(R.string.permission_necessary);
        }else{
            holder.necessaryView.setTextColor(ctx.getResources().getColor(R.color.colorGray));
            holder.necessaryView.setText(R.string.permission_select);
        }

        holder.iconView.setImageResource(data.getIcResId());
        holder.nameView.setText(data.getStringResId());
        holder.descView.setText(data.getDesc());

    }

    @Override
    public JPermissionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int resId = R.layout.item_permission_notify;
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(resId, parent, false);
        return new JPermissionNotifyAdapter.JPermissionViewHolder(itemView);
    }

    public class JPermissionViewHolder extends JBasedRecyclerAdapter.JViewHolder{

        private TextView nameView=null;
        private TextView necessaryView=null;
        private ImageView iconView=null;
        private TextView descView=null;

        public JPermissionViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView) findViewById(R.id.item_permission_name);
            necessaryView = (TextView) findViewById(R.id.item_permission_necessary);
            descView = (TextView) findViewById(R.id.item_permission_desc);
            iconView=(ImageView)findViewById(R.id.item_permission_ic);
        }
    }
}
