package com.example.one_x_ub.rmenber.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by one-x-ub on 01/03/17.
 */

public class CRUD {

    AdminSQLiteOH adminSQLiteOH;

    public CRUD(Context context){
        adminSQLiteOH = new AdminSQLiteOH(context);
    }

    public Cursor getSelect(String sql){
        Cursor data = null;
        try{
            data = adminSQLiteOH.getWritableDatabase().rawQuery(sql, null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public int setUpdate(String table, ContentValues contentValues, String cond){
        int resp = 0;
        try {
            resp = adminSQLiteOH.getWritableDatabase().update(table, contentValues, cond, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
