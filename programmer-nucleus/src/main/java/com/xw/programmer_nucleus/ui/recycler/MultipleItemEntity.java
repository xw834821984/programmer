package com.xw.programmer_nucleus.ui.recycler;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/**
 * Created by nazi on
 * date： 2018/1/10
 */

public class MultipleItemEntity implements MultiItemEntity {

    private final ReferenceQueue<LinkedHashMap<Object,Object>> ITEM_QUENE = new ReferenceQueue<>();
    //这里用到linke 是处理我们数据的键值对，因为是有序的，能够保证RecyclerView 里面的数组是有序的，不会因为添加数据的紊乱而添加错误的数据，所以使用linkedHashMap
    private final LinkedHashMap<Object,Object> MULTIPLE_FIELDS =  new LinkedHashMap<>();

    //
    private final SoftReference<LinkedHashMap<Object,Object>> FIELDS_REFERENCE =
            new SoftReference<>(MULTIPLE_FIELDS,ITEM_QUENE);

     MultipleItemEntity(LinkedHashMap<Object,Object> fields) {
        FIELDS_REFERENCE.get().putAll(fields);
    }

    public static MultipleEntityBuilder builder(){
        return new MultipleEntityBuilder();
    }

    @Override
    public int getItemType() {
        return (int) FIELDS_REFERENCE.get().get(MultipleFields.ITEM_TYPE);
    }

    // T 是泛型类型 ，不需要强制转换成具体的类型 ，
    // 泛型在java里面不但能提高代码的准确度，而且有很多的错误扼杀在编译器，能提高效率

    public final <T> T getField(Object key){
        return (T) FIELDS_REFERENCE.get().get(key);
    }

    public final LinkedHashMap<?,?> getFields(){
        return FIELDS_REFERENCE.get();
    }

    public final MultipleItemEntity setField(Object key , Object value){
        FIELDS_REFERENCE.get().put(key,value);
        return this;
    }
}
