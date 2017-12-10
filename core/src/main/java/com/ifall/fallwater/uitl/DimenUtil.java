package com.ifall.fallwater.uitl;

import com.ifall.fallwater.app.Latte;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by
 *
 * @author Fallwater潘建波
 *         on 2017/12/10.
 * @mail 1667376033@qq.com
 * description:
 */

public class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Latte.getContext().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getContext().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

}
