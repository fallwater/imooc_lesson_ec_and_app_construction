package com.ifall.fallwater21071129;

import android.app.Application;

import com.ifall.falllwater_ec.icon.FontEcModule;
import com.ifall.fallwater.app.Latte;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by
 *
 * @author ifall
 *         on 2017/11/30.
 *         description:
 *
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
