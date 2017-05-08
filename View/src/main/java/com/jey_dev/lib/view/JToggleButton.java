package com.jey_dev.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by JeyHoon on 2017. 5. 6..
 */

public class JToggleButton extends android.support.v7.widget.AppCompatImageView {
    private boolean isChecked=false;
    public JToggleButton(Context context) {
        super(context);
    }

    public JToggleButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttrs(attrs);
        initView();

    }

    public JToggleButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(attrs,defStyleAttr);
        initView();
    }


    private void initView(){
        setScaleType(ScaleType.CENTER_INSIDE);
//        setImageResource(R.drawable.bg_jtoggle_off);
        setClickable(true);
//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    isChecked=!isChecked;
                    onClicked();
                }
                return false;
            }
        });
        onClicked();
    }

    public void onClick(View view){

    }

    private void onClicked(){
        if(isChecked){
            setImageResource(R.drawable.bg_jtoggle_on);
        }else{
            setImageResource(R.drawable.bg_jtoggle_off);
        }
    }

    public void setChecked(final boolean isChecked){
        this.isChecked=isChecked;
        onClicked();
    }

    public boolean isChecked(){
        return isChecked;
    }

    public boolean getChecked(){
        return isChecked;
    }

    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.JToggleButton);

        setTypeArray(typedArray);
    }


    private void getAttrs(AttributeSet attrs, int defStyle) {
        getAttrs(attrs, defStyle,0);

    }
    private void getAttrs(AttributeSet attrs, int defStyle, int defStyleRes) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.JToggleButton, defStyle, defStyleRes);
        setTypeArray(typedArray);

    }


    private void setTypeArray(TypedArray typedArray) {

        isChecked = typedArray.getBoolean(R.styleable.JToggleButton_checked, true);
        typedArray.recycle();

    }
}
