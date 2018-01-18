package com.xw.programmer_nucleus.delegetes;

/**
 * Created by nazi on
 * date： 2017/12/6
 */

public abstract class LatteDelegate extends PermissionCheckerDelegate{

    public <T extends LatteDelegate> T getParentDelegate(){
        return (T) getParentFragment();
    }
}
