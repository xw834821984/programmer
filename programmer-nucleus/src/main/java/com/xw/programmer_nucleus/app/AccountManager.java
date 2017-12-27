package com.xw.programmer_nucleus.app;

import com.xw.programmer_nucleus.util.storage.LattePreference;

/**
 * Created by nazi on
 * date： 2017/12/26
 */

public class AccountManager {
    private enum SignTag{
        SIGN_TAG
    }
    //保存用户登录状态，登录后调用
    public  static void setSignState(boolean state){
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(),state);
    }

    private static boolean isSignIn(){
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker){
        if (isSignIn()){
            checker.onSignIn();
        }else {
            checker.onNotSignIn();
        }

    }
}
