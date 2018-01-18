package com.xw.programmer_nucleus.ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * Created by nazi on
 * date： 2018/1/18
 * 存储色值
 */
@AutoValue
public abstract class RgbValue {

    public abstract int red();

    public abstract int green();

    public abstract int blue();

    public static RgbValue create(int red, int green, int blue) {
        return new AutoValue_RgbValue(red, green, blue);
    }
}
