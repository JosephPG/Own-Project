package com.example.one_x_ub.rmenber.interfaces;

import android.support.v4.app.Fragment;

import com.example.one_x_ub.rmenber.database.CRUD;
import com.example.one_x_ub.rmenber.models.Login;

/**
 * Created by one-x-ub on 22/03/17.
 */

public interface IMainView {

    public void goFragment(Fragment fragment);

    public void goActivity();

    public CRUD onInstaceCRUD();
}
