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
 * date： 2017/12/23
 * 登录业务
 */

public class SignUpDelegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText mName = null;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText mPhone = null;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText mPassword = null;
    @BindView(R2.id.edit_sign_up_re_password)
    TextInputEditText mRePassword = null;

    private ISignListener mISignListener = null;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof  ISignListener){
            mISignListener = (ISignListener) activity;

        }
    }

    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp(){
        if (checkForm()){
            RestClient.builder()
                    //.url("sign_up")
                    .params("name","111")
                    .params("email","123@123.com")
                    .params("phone","12345612345")
                    .params("pawssword",123123)
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatterLogger.json("USER_PROFILE",response);
                            SignHandler.onSignUp(response,mISignListener);
                        }
                    })
                    .build()
                    .pst();

           Toast.makeText(getContext(),mName.getText().toString(),Toast.LENGTH_LONG).show();
        }
    }


    @OnClick(R2.id.tv_link_sign_in)
    void onClickLink(){
        start(new SignInDelegate());
    }

    private boolean checkForm() {
        final String name = mName.getText().toString();
        final String email = mEmail.getText().toString();
        final String phone = mPhone.getText().toString();
        final String password = mPassword.getText().toString();
        final String rePassword = mRePassword.getText().toString();

        boolean isPass = true;
        if (name.isEmpty()) {
            mName.setError("请输入姓名");
            isPass = false;
        } else {
            mName.setError(null);
        }
        //检查邮箱格式
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (phone.isEmpty() || phone.length() != 11) {
            mPhone.setError("手机号码错误");
            isPass = false;
        } else {
            mPhone.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }
        if (rePassword.isEmpty() || rePassword.length() < 6 || !(rePassword.equals(password))) {
            mRePassword.setError("密码验证错误，请重新输入");
            isPass = false;
        } else {
            mRePassword.setError(null);
        }
        return isPass;
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindview(@Nullable Bundle savedInstanceState, View rootView) {


    }
}
