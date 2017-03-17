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

    private String textparam_1;
    private String textsalt_1;
    private String textparam_2;
    private String textsalt_2;

    private String[] level_tema;
    private String[] level_cod;

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

    public String getTextparam_1(){
        return textparam_1;
    }

    public void setTextparam_1(String textparam_1){
        this.textparam_1 = textparam_1;
    }

    public String getTextparam_2(){
        return textparam_2;
    }

    public void setTextparam_2(String textparam_2){
        this.textparam_2 = textparam_2;
    }

    public String getTextsalt_1(){
        return textsalt_1;
    }

    public void setTextsalt_1(String textsalt_1){
        this.textsalt_1 = textsalt_1;
    }

    public String getTextsalt_2(){
        return textsalt_2;
    }

    public void setTextsalt_2(String textsalt_2){
        this.textsalt_2 = textsalt_2;
    }

    public void selectLoginInfo(){
        if(password == null) {
            Cursor cursor = crud.getSelect(Constants_select_login_info);
            if (cursor.moveToFirst()) {
                codigo = Integer.parseInt(cursor.getString(0));
                password = cursor.getString(1);
                status = Integer.parseInt(cursor.getString(2));
                textparam_1 = cursor.getString(3);
                textsalt_1 = cursor.getString(4);
                textparam_2 = cursor.getString(5);
                textsalt_2 = cursor.getString(6);
            }
        }
    }


    public void selectLoginTema(){
        /** Obtener el tema y codigos **/
    }

}
