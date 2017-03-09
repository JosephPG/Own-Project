package com.example.one_x_ub.rmenber.models;

/**
 * Created by one-x-ub on 01/03/17.
 */

public class Login {

    private int codigo;
    private String password;
    private int status;


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
}
