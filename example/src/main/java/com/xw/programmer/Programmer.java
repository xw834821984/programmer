package com.xw.programmer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.xw.programmer.ec.launcher.LauncherDelegate;
import com.xw.programmer_nucleus.activities.ProxyActivitie;
import com.xw.programmer_nucleus.delegetes.LatteDelegate;

public class Programmer extends ProxyActivitie {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       final ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

}
