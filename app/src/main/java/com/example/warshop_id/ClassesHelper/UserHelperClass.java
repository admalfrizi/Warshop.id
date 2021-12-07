package com.example.warshop_id.ClassesHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserHelperClass extends SQLiteOpenHelper {

    public static final String DBNAME = "Users.db";
    public static final String TABLE_NAME ="registeruser";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="fullname";
    public static final String COL_3 ="phonenumber";
    public static final String COL_4 ="email";
    public static final String COL_5 ="password";


    public UserHelperClass(Context context) {
        super(context, DBNAME, null , 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT, fullname TEXT , phonenumber TEXT, email TEXT, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long addUser(String fullname,  String phonenumber, String email,  String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullname", fullname);
        contentValues.put("phonenumber", phonenumber);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long res = db.insert("registeruser",null,contentValues);
        db.close();
        return res;
    }

    public boolean checkUser(String fullname, String password){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?" ;
        String[] selectionArgs = { fullname, password};
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        return count > 0;
    }

    public Cursor alldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM registeruser", null);
    }

}