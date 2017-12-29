package com.xw.programmer_nucleus.wechat;

import android.app.Activity;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xw.programmer_nucleus.app.ConfigKeys;
import com.xw.programmer_nucleus.app.Latte;
import com.xw.programmer_nucleus.wechat.callbacks.IWeChatSignInCallback;

/**
 * Created by nazi on
 * date： 2017/12/28
 */

public class LatterWeChat {
  public   static  final String APP_ID = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_ID);
   public static  final String APP_SECRET = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_SECRET);

    private final IWXAPI WXAPI;

    private IWeChatSignInCallback mSignInCallbake=null;

    private static final class Holder{
        private static final LatterWeChat INSTANCE = new LatterWeChat();
    }
    public static LatterWeChat getInstance(){
        return Holder.INSTANCE;
    }
    private LatterWeChat(){
        final Activity activity = Latte.getConfiguration(ConfigKeys.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity,APP_ID,true);
        WXAPI.registerApp(APP_ID);
    }
    public final IWXAPI getWXAPI(){
        return WXAPI;
    }
    public LatterWeChat onSignSuccess(IWeChatSignInCallback callback){
        this.mSignInCallbake = callback;
        return this;
    }

    public IWeChatSignInCallback getmSignInCallbake(){
        return mSignInCallbake;
    }
    public final  void signIn(){
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }
}
