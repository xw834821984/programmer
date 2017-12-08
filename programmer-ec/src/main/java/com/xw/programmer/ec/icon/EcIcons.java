package com.xw.programmer.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by nazi on
 * date： 2017/12/4
 */

public enum EcIcons implements Icon {


    icon_scon('\ue6b5'),
    icon_all('\ue65b');


    char character;

    EcIcons(char character) {
        this.character = character;
    }


    @Override
    public String key() {
        return name().replace('_', '-');
    }



    @Override
    public char character() {
        return character;
    }
}

