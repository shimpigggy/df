package org.techtown.capstoneproject;

import android.content.Context;
import android.content.SharedPreferences;

/*
 * Created by ShimPiggy on 2018-05-25.
 */

@SuppressWarnings("static-access")
public class SharedPreferencesUtil {

    /**
     * Filtering 대한 SharedPreferences
     */
    //Filtering Boolean 값을 가져오기
    public static boolean getBooleanPreferences(Context context, String key) {
        SharedPreferences p = context.getSharedPreferences("filtering", context.MODE_PRIVATE);
        return p.getBoolean(key, false);
    }

    //Filtering Boolean 값 저장
    public static void saveBooleanPreferences(Context context, String key, boolean value) {
        SharedPreferences p = context.getSharedPreferences("filtering", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = p.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    // 값(Key Data) 삭제하기
    public static void removeFilteringPreferences(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences("filtering", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.commit();
    }

    // 값(ALL Data) 삭제하기
    public static void removeFilteringAllPreferences(Context context) {
        SharedPreferences pref = context.getSharedPreferences("filtering", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }

    /**
     * email 대한 SharedPreferences
     */
    //email 값을 가져오기
    public static String getEmailPreferences(Context context) {
        SharedPreferences p = context.getSharedPreferences("Email", context.MODE_PRIVATE);
        return p.getString("email", "해당 이메일 없음");
    }

    //email 값 저장
    public static void saveEmailPreferences(Context context, String email) {
        SharedPreferences p = context.getSharedPreferences("Email", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = p.edit();
        editor.putString("email", email);
        editor.commit();
    }

    // 값(Key Data) 삭제하기
    public static void removeEmailPreferences(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences("KaKao_email", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.commit();
    }

    // 값(ALL Data) 삭제하기
    public static void removeEmailAllPreferences(Context context) {
        SharedPreferences pref = context.getSharedPreferences("KaKao_email", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}