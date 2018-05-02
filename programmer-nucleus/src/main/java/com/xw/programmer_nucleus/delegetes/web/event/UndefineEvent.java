package com.xw.programmer_nucleus.delegetes.web.event;

import com.xw.programmer_nucleus.util.log.LatterLogger;

/**
 * Created by nazi on
 * date： 2018/3/20
 */

public class UndefineEvent extends Event{


    @Override
    public String execute(String params) {
        LatterLogger.e("UndefineEvent",params);
        return null;
    }
}
