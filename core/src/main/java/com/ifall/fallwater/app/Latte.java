package com.ifall.fallwater.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by
 *
 * @author ifall on 2017/11/30.
 */

public final class Latte {

    public static Configurator init(Context context) {
        getConfigurations()
                .put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getContext() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }


}
