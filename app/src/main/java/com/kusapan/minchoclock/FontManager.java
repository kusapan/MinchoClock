package com.kusapan.minchoclock;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kusapan on 2017/01/18.
 */

public class FontManager {
    private static FontManager sInstance;
    private Map<String, Typeface> mCache;
    private static int sDefaultStyle = R.attr.fontifyStyle;

    private FontManager() {
        mCache = new HashMap<String, Typeface>();
    }

    public static FontManager getInstance() {
        if (sInstance == null) {
            sInstance = new FontManager();
        }

        return sInstance;
    }

    public void setFont(TextView tv, AttributeSet attrs) {
        String fontName = getFontName(tv.getContext(), attrs);
        setFont(tv, fontName);
    }

    public void setFont(TextView tv, String fontName) {
        if (fontName == null) return;

        Typeface typeface = mCache.get(fontName);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(tv.getContext().getAssets(), fontName);
            mCache.put(fontName, typeface);
        }

        tv.setTypeface(typeface);
    }

    public static String getFontName(Context c, AttributeSet attrs) {
        TypedArray arr = c.obtainStyledAttributes(
                attrs,
                R.styleable.Fontify,
                sDefaultStyle,
                0
        );

        String fontName = arr.getString(R.styleable.Fontify_font);
        arr.recycle();
        return fontName;
    }
}
