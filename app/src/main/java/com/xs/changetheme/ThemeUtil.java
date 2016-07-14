package com.xs.changetheme;

import android.app.Activity;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-07-14 17:39
 * @email Xs.lin@foxmail.com
 */
public class ThemeUtil {
    private static final String TAG = "ThemeUtil";
    public static void changeTheme(Activity activity,Theme theme ) {

        if (activity == null)
            return;
        int style = R.style.RedTheme;
        switch (theme) {
            case RED:
                style = R.style.RedTheme;
                break;
            case PINK:
                style = R.style.PinkTheme;
                break;
            case BROWN:
                style = R.style.BrownTheme;
                break;
        }
        activity.setTheme(style);
    }

    public enum Theme {
        RED(0),
        PINK(1),
        BROWN(2);

        private int value;
        Theme(int value) {
            this.value = value;
        }
        public static Theme positonToTheme(int position) {
            for (Theme t :
                    Theme.values()) {
                if (position == t.getValue())
                    return t;
            }
            return RED;
        }

        private int getValue() {
            return value;
        }
    }

}
