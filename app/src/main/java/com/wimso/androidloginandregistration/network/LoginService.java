package com.wimso.androidloginandregistration.network;

import android.content.Context;

import com.wimso.androidloginandregistration.network.config.RetrofitBuilder;
import com.wimso.androidloginandregistration.network.interfaces.LoginInterface;

import retrofit2.Callback;

/**
 * Created by Wim on 11/4/16.
 */
public class LoginService {

    private LoginInterface loginInterface;

    public LoginService(Context context) {
        loginInterface = RetrofitBuilder.builder(context)
                .create(LoginInterface.class);
    }

    public void doLogin(String email, String password, Callback callback) {
        loginInterface.login(email, password).enqueue(callback);
    }

}
