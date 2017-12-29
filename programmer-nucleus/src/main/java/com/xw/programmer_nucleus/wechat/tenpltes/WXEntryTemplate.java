package com.xw.programmer_nucleus.wechat.tenpltes;

import com.xw.programmer_nucleus.wechat.BaseWXEntryActivity;
import com.xw.programmer_nucleus.wechat.LatterWeChat;

/**
 * Created by nazi on
 * date： 2017/12/28
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    /* 微信登录返回回来后是在WXEntryTemplate activity里面，
      也就是在这个模板生成之后的activity 这个activity是不会自动取消
      这个时候就会有迂回的办法*/

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        //不需要动画
        overridePendingTransition(0,0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {

        LatterWeChat.getInstance().getmSignInCallbake().onSignInSuccess(userInfo);

    }


}
