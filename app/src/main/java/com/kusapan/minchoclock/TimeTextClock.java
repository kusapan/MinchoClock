package com.kusapan.minchoclock;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by kusapan on 2017/01/18.
 */

public class TimeTextClock extends android.widget.TextClock {
    public TimeTextClock(Context context) {
        super(context);
    }

    public TimeTextClock(Context context, AttributeSet attrs) {
        super(context, attrs);

        // return early for eclipse preview mode
        if (isInEditMode()) return;

        FontManager.getInstance().setFont(this, attrs);
    }

    public void setFont(String fontPath) {
        FontManager.getInstance().setFont(this, fontPath);
    }

    public void setFont(int resId) {
        String fontPath = getContext().getString(resId);
        setFont(fontPath);
    }
}