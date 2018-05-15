package com.jey_dev.lib.dialog.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

//import butterknife.ButterKnife;

/**
 * Created by JeyHoon on 2016. 11. 28..
 */

 abstract class JBasedRecyclerAdapter<VH extends JBasedRecyclerAdapter.JViewHolder, O extends Object> extends RecyclerView.Adapter<VH> {
    protected Context ctx=null;
    private ArrayList<O> dataList=new ArrayList<>();
    private JBasedRecyclerAdapterInterface.OnItemClickListener onItemClickListener=new JBasedRecyclerAdapterInterface.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {

        }
    };

    private JBasedRecyclerAdapterInterface.OnItemLongClickListener onItemLongClickListener=new JBasedRecyclerAdapterInterface.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(View view, int position) {
            return false;
        }
    };
    private JBasedRecyclerAdapterInterface.EndlessScrollListener endlessScrollListener=null;
    public JBasedRecyclerAdapterInterface.EndlessScrollListener getEndlessScrollListener() {
        return endlessScrollListener;
    }

    public void setEndlessScrollListener(JBasedRecyclerAdapterInterface.EndlessScrollListener endlessScrollListener) {
        this.endlessScrollListener = endlessScrollListener;
    }

    public JBasedRecyclerAdapter(Context ctx, ArrayList<O> dataList, JBasedRecyclerAdapterInterface.OnItemClickListener onItemClickListener, JBasedRecyclerAdapterInterface.OnItemLongClickListener onItemLongClickListener) {
        if (null == dataList) {
            throw new IllegalArgumentException(
                    "DataList must not be null");
        }
        this.ctx = ctx;
        this.dataList = dataList;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public JBasedRecyclerAdapter(Context ctx, ArrayList<O> dataList, JBasedRecyclerAdapterInterface.OnItemClickListener onItemClickListener) {
        if (null == dataList) {
            throw new IllegalArgumentException(
                    "DataList must not be null");
        }
        this.ctx = ctx;
        this.dataList = dataList;
        this.onItemClickListener = onItemClickListener;
    }
    public JBasedRecyclerAdapter(Context ctx, ArrayList<O> dataList, JBasedRecyclerAdapterInterface.OnItemLongClickListener onItemLongClickListener) {
        if (null == dataList) {
            throw new IllegalArgumentException(
                    "DataList must not be null");
        }
        this.ctx = ctx;
        this.dataList = dataList;
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public JBasedRecyclerAdapter(Context ctx, ArrayList<O> dataList) {
        if (null == dataList) {
            throw new IllegalArgumentException(
                    "DataList must not be null");
        }
        this.ctx = ctx;
        this.dataList = dataList;
    }

    @Override
    public void onBindViewHolder(VH holder,int position) {
        final int itemPosition=position;
        holder.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,itemPosition);
            }
        });
        holder.getRootView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return onItemLongClickListener.onItemLongClick(view,itemPosition);
            }
        });
        if(position == getItemCount() - 1) {
            if(null!=endlessScrollListener ) {
                endlessScrollListener.onLoadMore(position);
            }
        }
        onBindJViewHolder(holder, position);
    }
    public abstract void onBindJViewHolder(VH holder,int position);

    public O getItem(final int position){
        return dataList.get(position);
    }
//
//    @Override
//    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void deleteItem(final int position){
        dataList.remove(position);
    }

    public void removeItem(final int position){
        deleteItem(position);
    }


    public static class JViewHolder extends RecyclerView.ViewHolder{
        View itemView=null;
        View rootView=null;
        public JViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            rootView=itemView;
//            ButterKnife.bind(this, itemView);
        }

        public View getRootView(){return rootView;}

        public View findViewById(final int viewId){return itemView.findViewById(viewId);}

    }
    public void setOnItemClickListener(JBasedRecyclerAdapterInterface.OnItemClickListener itemClickListener){this.onItemClickListener=itemClickListener;}
    public void setOnItemLongClickListener(JBasedRecyclerAdapterInterface.OnItemLongClickListener itemLongClickListener){this.onItemLongClickListener=itemLongClickListener;}
}
