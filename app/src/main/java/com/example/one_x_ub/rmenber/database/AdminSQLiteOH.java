package com.example.one_x_ub.rmenber.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.one_x_ub.rmenber.interfaces.DBConstants;

public class AdminSQLiteOH extends SQLiteOpenHelper implements DBConstants{

    private final String sql = "create table " + Constants_table + "(" + Constants_id_field +
            Constants_password_field + Constants_status_field + Constants_text_param_field +
            Constants_text_salt_field + Constants_text_param2_field + Constants_text_salt2_field +
            Constants_tema_pri_field + Constants_codigo_tema_field + Constants_subtema_field +
            Constants_codigo_subtema_field + ")";

    private final String consulta = "insert into " + Constants_table + "(" + Constants_id + "," +
            Constants_password + "," + Constants_status + "," +
            Constants_text_param + "," + Constants_text_salt + "," +
            Constants_text_param2 + "," + Constants_text_salt2 + "," +
            Constants_tema_pri + "," + Constants_codigo_tema + "," +
            Constants_subtema + "," + Constants_codigo_subtema + ") values(" +
            Constants_id_data + "," + Constants_password_data + "," + Constants_status_data + "," +
            Constants_text_data + "," + Constants_text_data + "," + Constants_text_data + "," +
            Constants_text_data + "," + Constants_text_data + "," + Constants_text_data + "," +
            Constants_text_data + "," + Constants_text_data + ")";

    public AdminSQLiteOH(Context context){
        super(context, Constants_DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        db.execSQL(consulta);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
