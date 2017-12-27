package com.xw.programmer.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.xw.programmer.ec.R;
import com.xw.programmer.ec.R2;
import com.xw.programmer_nucleus.delegetes.LatteDelegate;
import com.xw.programmer_nucleus.net.Callback.ISuccess;
import com.xw.programmer_nucleus.net.RestClient;
import com.xw.programmer_nucleus.util.log.LatterLogger;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by nazi on
 * date： 2017/12/25
 */

public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    private ISignListener mISignListener = null;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof  ISignListener){
            mISignListener = (ISignListener) activity;

        }
    }

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn(){
        if (checkForm()){
            RestClient.builder()
                    .params("email",mEmail.getText().toString())
                    .params("pawssword",mPassword.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatterLogger.json("USER_PROFILE",response);
                            SignHandler.onSignIn(response,mISignListener);
                        }
                    })
                    .build()
                    .pst();
           //  Toast.makeText(getContext(),"邮箱"+mEmail.getText().toString(),Toast.LENGTH_SHORT).show();
        }
    }
    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWeChat(){
            Toast.makeText(getContext(),"被点击" ,Toast.LENGTH_SHORT).show();
    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink(){
        start(new SignUpDelegate());
    }


    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        //检查邮箱格式
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }


        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }
    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindview(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
