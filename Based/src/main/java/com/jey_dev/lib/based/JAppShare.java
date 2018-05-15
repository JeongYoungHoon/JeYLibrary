package com.jey_dev.lib.based;

import android.content.Context;
import android.content.Intent;

/**
 * Created by JeyHoon on 2017. 5. 12..
 */

public class JAppShare {

    private static final String URL_ROOT="http://jey-dev.com/";
    private static final String URL_GO_STORE=URL_ROOT+"apps/go_store.php?";
    private static final String URL_GO_STORE_IDX=URL_GO_STORE+"target_app=";
    private static final String URL_GO_STORE_NAME=URL_GO_STORE+"target_app_name=";

    public static final void appShare(final Context ctx, final String appName) {
        appShare(ctx,appName,"");
    }

    public static final void appShare(final Context ctx, final long idx) {
        appShare(ctx,idx,"");
    }

    public static final void appShare(final Context ctx, final int idx) {
        appShare(ctx,idx,"");
    }

    public static final void appShare(final Context ctx, final String appName, final String title) {
        appShareWithURL(ctx,URL_GO_STORE_NAME+appName,title);
    }
    public static final void appShare(final Context ctx, final long idx, final String title) {
        appShareWithURL(ctx,URL_GO_STORE_IDX+String.valueOf(idx),title);
    }
    public static final void appShare(final Context ctx, final int idx, final String title) {
        appShareWithURL(ctx,URL_GO_STORE_IDX+String.valueOf(idx),title);
    }

    public static final void appShareWithURL(final Context ctx, final String url, final String title) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, url);
        Intent chooser = Intent.createChooser(intent, title);
        ctx.startActivity(chooser);
    }

}
