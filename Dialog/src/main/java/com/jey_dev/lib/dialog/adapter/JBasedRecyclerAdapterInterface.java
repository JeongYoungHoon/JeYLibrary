package com.jey_dev.lib.dialog.adapter;

import android.view.View;

/**
 * Created by JeyHoon on 16. 5. 26..
 */
 class JBasedRecyclerAdapterInterface {
    protected interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
    protected interface OnItemLongClickListener{
        public boolean onItemLongClick(View view, int position);
    }
    protected interface EndlessScrollListener {
        /**
         * Loads more data.
         * @param position is position.
         * @return true loads data actually, false otherwise.
         */
        boolean onLoadMore(int position);
    }
}
