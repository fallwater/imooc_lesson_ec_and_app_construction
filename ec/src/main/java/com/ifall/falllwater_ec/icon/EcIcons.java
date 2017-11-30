package com.ifall.falllwater_ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by
 *
 * @author ifall
 *         on 2017/11/30.
 *         description:
 */

public enum EcIcons implements Icon {
    icon_scan('\ue606'),
    icon_ali_pay('\ue602');

    private char charactor;

    EcIcons(char charactor) {
        this.charactor = charactor;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return charactor;
    }
}
