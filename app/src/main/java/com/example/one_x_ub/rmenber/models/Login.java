package com.example.one_x_ub.rmenber.models;

import android.database.Cursor;

import com.example.one_x_ub.rmenber.database.CRUD;
import com.example.one_x_ub.rmenber.interfaces.DBConstants;

/**
 * Created by one-x-ub on 01/03/17.
 */

public class Login implements DBConstants{

    private int codigo;
    private String password;
    private int status;

    private CRUD crud;

    public Login(CRUD crud){
        this.crud = crud;
        selectLoginInfo();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void selectLoginInfo(){
        if(password == null) {
            Cursor cursor = crud.getSelect(Constants_select_login_info);
            if (cursor.moveToFirst()) {
                codigo = Integer.parseInt(cursor.getString(0));
                password = cursor.getString(1);
                status = Integer.parseInt(cursor.getString(2));
            }
        }
    }
}
