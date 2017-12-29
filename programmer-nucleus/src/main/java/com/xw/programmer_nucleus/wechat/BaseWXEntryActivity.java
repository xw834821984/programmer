package com.xw.programmer_nucleus.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.xw.programmer_nucleus.net.Callback.IError;
import com.xw.programmer_nucleus.net.Callback.IFailure;
import com.xw.programmer_nucleus.net.Callback.ISuccess;
import com.xw.programmer_nucleus.net.RestClient;
import com.xw.programmer_nucleus.util.log.LatterLogger;

/**
 * Created by nazi on
 * date： 2017/12/29
 */

public abstract class BaseWXEntryActivity extends BaseWXActivity {
    //用户登录成功后的回调
    protected abstract void onSignInSuccess(String userInfo);

    //微信发送请求到第三方应用后的回调

    @Override
    public void onReq(BaseReq baseReq) {

    }

    //第三方应用发送请求微信后的回调
    @Override
    public void onResp(BaseResp baseResp) {

        final String code = ((SendAuth.Resp) baseResp).code;
        final StringBuffer authUrl = new StringBuffer();
        authUrl
                .append("https://api.weixin.qq.con/sns/oauth2/access_token?appid=")
                .append(LatterWeChat.APP_ID)
                .append("&secret=")
                .append(LatterWeChat.APP_SECRET)
                .append("&code=")
                .append(code)
                .append("&grant_type=authorization_code");
        LatterLogger.d("authUrl", authUrl.toString());
        getAuth(authUrl.toString());
    }

    private void getAuth(String authUrl) {
        RestClient
                .builder()
                .url(authUrl)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                        final JSONObject authObj = JSON.parseObject(response);
                        final String accessToken = authObj.getString("access_token");
                        final String openId = authObj.getString("openid");

                        //获取用户信息
                        final StringBuffer userInfoUrl = new StringBuffer();
                        userInfoUrl
                                .append("https://api.weixin.qq.con/sns/oauth2/access_token?appid=")
                                .append(accessToken)
                                .append("&openid=")
                                .append(openId)
                                .append("&lang=")
                                .append("zh_CN");

                        LatterLogger.d("userInfoUrl", userInfoUrl.toString());

                        getUserInfo(userInfoUrl.toString());
                    }
                })
                .build()
                .get();
    }

    private  void getUserInfo (String userInfoUrl){
        RestClient
                .builder()
                .url(userInfoUrl)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                        onSignInSuccess(response);
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
