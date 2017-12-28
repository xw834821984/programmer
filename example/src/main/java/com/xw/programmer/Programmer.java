package com.xw.programmer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.xw.programmer.ec.launcher.LauncherDelegate;
import com.xw.programmer.ec.sign.ISignListener;
import com.xw.programmer_nucleus.activities.ProxyActivitie;
import com.xw.programmer_nucleus.delegetes.LatteDelegate;
import com.xw.programmer_nucleus.ui.launcher.ILauncherListener;
import com.xw.programmer_nucleus.ui.launcher.OnLauncherFinishTag;

public class Programmer extends ProxyActivitie implements
        ISignListener ,
        ILauncherListener{


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

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag){
            case SIGNED:
                Toast.makeText(this,"你是老大不用登陆",Toast.LENGTH_LONG).show();
                startWithPop(new ExampleDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this,"你是老大不用登陆",Toast.LENGTH_LONG).show();
                startWithPop(new ExampleDelegate());
                break;
            default:
                break;
        }
    }
}
