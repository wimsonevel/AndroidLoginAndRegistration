package com.wimso.androidloginandregistration.network.interfaces;

import com.wimso.androidloginandregistration.model.BaseResponse;
import com.wimso.androidloginandregistration.network.config.Config;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Wim on 11/4/16.
 */
public interface RegisterInterface {

    @FormUrlEncoded
    @POST(Config.API_REGISTER)
    Call<BaseResponse> register(
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("email") String email,
            @Field("password") String password);

}
