package com.xw.programmer.ec.sign;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xw.programmer.ec.database.DatabaseManager;
import com.xw.programmer.ec.database.UserProfile;
import com.xw.programmer_nucleus.app.AccountManager;


/**
 * Created by nazi on
 * date： 2017/12/26
 */

public class SignHandler {
    public static void onSignIn(String response,ISignListener signListener){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);

        //保存用户状态
        AccountManager.setSignState(true);

        signListener.onSignInSuccess();

    }


    public static void onSignUp(String response,ISignListener signListener){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);

        //保存用户状态
        AccountManager.setSignState(true);

        signListener.onSignUpSuccess();

    }
}
