package ru.gurps.generator.android.helpers;

import android.content.Context;
import android.os.Build;

public class DeprecatedHelper {
    public static int getColor(Context mContext, int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            return mContext.getResources().getColor(id, mContext.getTheme());
        else return mContext.getResources().getColor(id);
    }
}
