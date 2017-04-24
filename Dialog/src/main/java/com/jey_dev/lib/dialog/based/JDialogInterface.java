package com.jey_dev.lib.dialog.based;

import android.view.View;

/**
 * Created by jeyhoon on 15. 12. 16..
 */
public class JDialogInterface {
    public interface OnMenuClickListener{
        public void onClick(JBaseDialog d, View v, int position);
    }

    public interface OnButtonClickListener {
        public void onClick(JBaseDialog d, View v);
    }
    public interface OnEditConfirmListener{
        void onConfirm(final JBaseDialog d, final String str, final View v);
    }
    public interface OnLocationConfirmListener{
        void onConfirm(JBaseDialog d, View v, String locationCode, String locationName);
    }
    public interface OnColorPickerListener{
        void onColorChanged(int color);
        void onColorPick(JBaseDialog dialog, int color);
    }
}
