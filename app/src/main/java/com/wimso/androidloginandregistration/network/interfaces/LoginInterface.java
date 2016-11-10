package com.wimso.androidloginandregistration.network.interfaces;

import com.wimso.androidloginandregistration.model.User;
import com.wimso.androidloginandregistration.network.config.Config;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Wim on 11/3/16.
 */
public interface LoginInterface {

    @FormUrlEncoded
    @POST(Config.API_LOGIN)
    Call<User> login(
            @Field("email") String email,
            @Field("password") String password);

}
