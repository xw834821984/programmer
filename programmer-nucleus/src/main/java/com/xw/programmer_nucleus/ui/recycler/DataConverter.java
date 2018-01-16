package com.xw.programmer_nucleus.ui.recycler;

import java.util.ArrayList;

/**
 * Created by nazi on
 * date： 2018/1/11
 */

public abstract class DataConverter {
    protected final ArrayList<MultipleItemEntity> ENTITIES = new ArrayList<>();

    private String mJsonData = null;
    public abstract ArrayList<MultipleItemEntity>convert();
    public DataConverter setJsonData (String json){
        this.mJsonData = json;
        return this;
    }

    protected String getJsonData(){
        if (mJsonData == null || mJsonData.isEmpty()){
            throw  new NullPointerException("DATA IS NULL!");
        }
        return mJsonData;
    }
}


