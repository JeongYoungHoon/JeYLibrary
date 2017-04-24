package com.jey_dev.lib.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.jey_dev.lib.dialog.based.JBaseDialog;
import com.jey_dev.lib.dialog.based.JDialogInterface;
import com.jey_dev.lib.dialog.util.util;
import com.jey_dev.lib.dialog.view.JColorPickerView;
//import com.wenoun.library.tdialog.view.ColorPickerView;
//
//import static com.jey_dev.lib.dialog.JTextInputDialog.STYLE_TANSAN;
//import static com.jey_dev.lib.dialog.JTextInputDialog.STYLE_WEMOM;


//import wenoun.in.library.R;

public class JColorPickerDialog extends JBaseDialog {
//    public static final int STYLE_TANSAN = 0;
//    public static final int STYLE_WEMOM = 1;
//    public static final int STYLE_TR = 2;
    private int styleId = R.style.TranslucentTheme;
//    private boolean isTr = false;
    private JDialogInterface.OnColorPickerListener colorPickerListener=null;
    private JColorPickerView.ColorListener colorListener = new JColorPickerView.ColorListener() {
        @Override
        public void onColorChanged(int color) {
            pickColor=color;
            colorPickerListener.onColorChanged(color);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ctx.setTheme(styleId);
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.dialog_colorpicker);
        setLayout();


    }

    public JColorPickerDialog(Context context) {
        this(context, STYLE_NORMAL);
    }

    public JColorPickerDialog(Context context, int style) {
        super(context, R.style.TranslucentTheme);
        // Dialog 배경을 투명 처리 해준다.
        this.ctx = getContext();
        if (style == STYLE_NORMAL) {
            this.styleId = R.style.TranslucentTheme;
        } else if (style == STYLE_JEY) {
            this.styleId = R.style.JeYTranslucentTheme;
        }
    }
    private JColorPickerView colorPicker;
    private TextView confirmButton;
    private TextView cancelButton;
    private String confirmStr;
    private Context ctx;
    private int pickColor=0xFFFFFF;

    /*
     * Layout
     */
    private void setLayout() {
        colorPicker = (JColorPickerView) findViewById(R.id.colorpicker);

        confirmButton = (TextView) findViewById(R.id.confirm_button);
        cancelButton = (TextView) findViewById(R.id.cancel_button);
        if (!isEmpty(confirmStr))
            confirmButton.setText(confirmStr);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != colorPickerListener) {
                    colorPickerListener.onColorPick(JColorPickerDialog.this, colorPicker.getColor());
                }
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JColorPickerDialog.this.cancel();
            }
        });
//        if (isTr) {
            cancelButton.setBackgroundResource(R.color.colorTr);
            confirmButton.setBackgroundResource(R.color.colorTr);
            confirmButton.setPadding(util.dpToPx(ctx, 5), util.dpToPx(ctx, 5), util.dpToPx(ctx, 10), util.dpToPx(ctx, 5));
//        }
        if(null!=colorPicker) {
            colorPicker.setColorListener(colorListener);
            colorPicker.setColor(pickColor);
        }
    }

//    TDialogInterface.OnButtonClickListener confirmClickListener = null;

    public JColorPickerDialog setOnColorPickerListener(final JDialogInterface.OnColorPickerListener colorPickerListener) {
        this.colorPickerListener = colorPickerListener;
//        colorPicker.setColorListener(colorListener);
        return this;
    }

    public JColorPickerDialog setColor(int color){
        this.pickColor=color;
        if(null!=colorPicker)
            colorPicker.setColor(color);
        return this;
    }
}
