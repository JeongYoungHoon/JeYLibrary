package com.jey_dev.lib.based;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.jey_dev.lib.based.util.JUtil;


/**
 * Created by JeyHoon on 16. 6. 19..
 */
public abstract class JFragment extends Fragment {
    protected Activity parentAct = null;
    protected Context ctx = null;
    protected static View root = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = getActivity().getBaseContext();
        parentAct = getActivity();
    }

//    @Override
//    public void onAttachFragment(Fragment childFragment) {
//        super.onAttachFragment(childFragment);
//    }
//
//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
//    }

    /**
     * @param resId     Layout's Resource Id e.g. R.layout.fragment_xx
     * @param inflater  onCreateView param's LayoutInflater inflater
     * @param container onCreateView param's ViewGroup container
     */
    public void setRoot(int resId, LayoutInflater inflater, ViewGroup container) {
        try {
            root = inflater.inflate(resId, container, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * When you override this method, Must first call setRoot method
     *
     * @param inflater  onCreateView param's LayoutInflater inflater
     * @param container onCreateView param's ViewGroup container
     */
    protected abstract void onCreateFragment(LayoutInflater inflater, ViewGroup container);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        onCreateFragment(inflater, container);
        return root;
    }

    /**
     * Easy to findViewById Instead of root.findViewById
     *
     * @param resId View's Resource Id
     * @return redId's View
     */
    public View findViewById(int resId) {
        if (null == root) {
            throw new NullPointerException("Root is null. Call setRoot method");
        } else
            return root.findViewById(resId);
    }

    /**
     * Easy to setOnClickListener Instead of root.findViewById(viewId).setOnClickListner
     *
     * @param viewId   apply View's id
     * @param listener OnClickListener
     */
    protected void setOnClickListener(int viewId, View.OnClickListener listener) {
        findViewById(viewId).setOnClickListener(listener);
    }

    public void startAct(Class<?> cls) {
        startAct(new Intent(ctx, cls));
    }

    public void startActFinish(Class<?> cls) {
        startActFinish(new Intent(ctx, cls));
    }

    public void startAct(Intent intent) {
        startAct(intent, false);
    }

    public void startActFinish(Intent intent) {
        startAct(intent, true);
    }

    public void startAct(Intent intent, boolean isFinish) {
        startActivity(intent);
        if (isFinish)
            parentAct.finish();
    }

    public void Log(String msg) {
        Log.d("JTest," + getClass().getSimpleName(), msg);
    }

    public void Log(JError error) {
        Log.d("JTest," + getClass().getSimpleName(), error.toString());
    }

    public void Log(Exception e) {
        Log.e("JTest" + getClass().getSimpleName(), "Exception : ", e);
    }

    public void showProgressDialog(String msg) {
        try {
            ((JActivity) parentAct).showProgressDialog(msg);
        } catch (ClassCastException cce) {
            Log(cce);
        }
    }

    public void showProgressDialog() {
        showProgressDialog("");
    }

    public void dismissProgressDialog() {
        try {
            ((JActivity) parentAct).dismissProgressDialog();
        } catch (ClassCastException cce) {
            Log(cce);
        }
    }

    public Dialog getProgressDialog(final String msg) {
        try {
            return ((JActivity) parentAct).getProgressDialog(msg);
        } catch (ClassCastException cce) {
            Log(cce);
            return null;
        }
    }

    public Dialog getProgressDialog(){
        return getProgressDialog("");
    }

    public void hideSoftKeyboard(View view) {
        JUtil.hideSoftKeyboard(ctx, view);
    }
    public void showSoftKeyboard(View view){JUtil.showSoftKeyboard(ctx,view);}

    public void regReceiver(final BroadcastReceiver receiver, final IntentFilter filter) {
        try {
            LocalBroadcastManager.getInstance(ctx).registerReceiver(receiver, filter);
        } catch (Exception e) {
            Log(e);
        }
    }

    public void unregReceiver(final BroadcastReceiver receiver) {
        try {
            LocalBroadcastManager.getInstance(ctx).unregisterReceiver(receiver);
        } catch (Exception e) {
            Log(e);
        }
    }
    public void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = parentAct.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(color);
        }
    }
    public void setStatusBarResColor(int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            final int color=getResources().getColor(resId);
            Window window = parentAct.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(color);
        }
    }
}
