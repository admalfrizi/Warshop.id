package com.example.warshop_id.ClassesHelper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionHelperClass {

    SharedPreferences sessionloggedin;
    SharedPreferences.Editor editor;
    Context context;

    private static final String LOGGED_IN = "isLoggedIn";

    public static final String KEY_FULLNAME = "fullname";
    public static final String KEY_PHONENUMBER = "phonenumber";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    public SessionHelperClass(Context _context){
        context = _context;
        sessionloggedin = _context.getSharedPreferences("userLoginSession",Context.MODE_PRIVATE);
        editor = sessionloggedin.edit();
    }

    public void createLoginSession(String fullname, String password){
        editor.putBoolean(LOGGED_IN, true);

        editor.putString(KEY_FULLNAME,fullname);
        editor.putString(KEY_PASSWORD,password);

        editor.commit();
    }
    public HashMap<String, String> getUserDetailFromSession(){
        HashMap<String,String> userData = new HashMap<String, String>();

        userData.put(KEY_FULLNAME, sessionloggedin.getString(KEY_FULLNAME, null));
        userData.put(KEY_PASSWORD, sessionloggedin.getString(KEY_PASSWORD, null));

        return userData;
    }
    public boolean checkLogin(){
        if (sessionloggedin.getBoolean(LOGGED_IN,true)){
            return true;

        }else
            return false;
    }

    public void logout(){
        editor.clear();
        editor.commit();
    }
}
