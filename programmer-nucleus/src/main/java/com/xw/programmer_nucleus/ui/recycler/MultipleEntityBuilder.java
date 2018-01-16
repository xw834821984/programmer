package com.xw.programmer_nucleus.ui.recycler;

import java.util.LinkedHashMap;
import java.util.WeakHashMap;

/**
 * Created by nazi on
 * date： 2018/1/11
 * MultipleItemEntity 建造者
 */

public class MultipleEntityBuilder {

    private static final LinkedHashMap<Object, Object> FIELDS = new LinkedHashMap<>();

    public MultipleEntityBuilder() {

        FIELDS.clear();
    }

    public final MultipleEntityBuilder setItemType(int itemType) {
        FIELDS.put(MultipleFields.ITEM_TYPE, itemType);
        return this;
    }

    public final MultipleEntityBuilder setField(Object key, Object value) {
        FIELDS.put(key, value);
        return this;
    }

    public final MultipleEntityBuilder setFields(WeakHashMap<?,? > map) {
        FIELDS.putAll(map);
        return this;
    }
    public final MultipleItemEntity build(){
        return new MultipleItemEntity(FIELDS);
    }
}
