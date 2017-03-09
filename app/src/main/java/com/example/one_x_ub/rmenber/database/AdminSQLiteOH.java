package com.example.one_x_ub.rmenber.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOH extends SQLiteOpenHelper{

    private static final String DBNAME = "RRMEMBER";

    private final String id_table = "id integer primary key,";
    private final String password = "password text,";
    private final String status = "status integer,";
    private final String text_param = "text_param text,";
    private final String text_salt = "text_salt text,";
    private final String text_param2 = "text_param2 text,";
    private final String text_salt2 = "text_salt2 text,";
    private final String tema_principal = "tema_pri text,";
    private final String cod_tema = "codigo_tema text,";
    private final String subtema = "subtema text,";
    private final String cod_subtema = "codigo_subtema txt";

    private final String id_data = "616,";
    private final String password_data = "'correon2',";
    private final String status_data = "0,";
    private final String param_data = "'-',";
    private final String salt_data = "'-',";
    private final String param_data2 = "'-',";
    private final String salt_data2 = "'-',";
    private final String tema_data = "'-',";
    private final String codtema_data = "'-',";
    private final String subtema_data = "'-',";
    private final String codsubtema_data = "'-'";

    private final String sql = "create table login_data("+id_table+password+status+
            text_param+text_salt+
            text_param2+text_salt2+tema_principal+cod_tema+
            subtema+cod_subtema+")";

    private final String consulta = "insert into login_data (id, password, status, text_param, text_salt, text_param2, text_salt2, tema_pri, codigo_tema, " +
            "subtema, codigo_subtema) values("+id_data+password_data+status_data+param_data+salt_data+param_data2+salt_data2+tema_data+codtema_data+
            subtema_data+codsubtema_data+")";

    public AdminSQLiteOH(Context context){
        super(context, DBNAME, null, 1);
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
