package com.wimso.androidloginandregistration.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.wimso.androidloginandregistration.model.User;

/**
 * Created by Wim on 11/3/16.
 */
public class PrefUtil {

    public static final String USER_SESSION = "user_session";

    public static SharedPreferences getSharedPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void putUser(Context context, String key, User user) {
        Gson gson = new Gson();
        String json = gson.toJson(user);
        putString(context, key, json);
    }

    public static User getUser(Context context, String key) {
        Gson gson = new Gson();
        String json = getString(context, key);
        User user = gson.fromJson(json, User.class);
        return user;
    }

    public static void putString(Context context, String key, String value) {
        getSharedPreference(context).edit().putString(key, value).apply();
    }

    public static String getString(Context context, String key) {
        return getSharedPreference(context).getString(key, null);
    }

    public static void clear(Context context) {
        getSharedPreference(context).edit().clear().apply();
    }

}
