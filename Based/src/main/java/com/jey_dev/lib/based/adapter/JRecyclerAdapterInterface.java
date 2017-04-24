package com.jey_dev.lib.based.adapter;

import android.view.View;

/**
 * Created by JeyHoon on 16. 5. 26..
 */
public class JRecyclerAdapterInterface {
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
    public interface OnItemLongClickListener{
        public boolean onItemLongClick(View view, int position);
    }
    public interface EndlessScrollListener {
        /**
         * Loads more data.
         * @param position is position.
         * @return true loads data actually, false otherwise.
         */
        boolean onLoadMore(int position);
    }
}
