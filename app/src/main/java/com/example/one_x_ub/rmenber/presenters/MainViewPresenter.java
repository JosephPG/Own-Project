package com.example.one_x_ub.rmenber.presenters;

import com.example.one_x_ub.rmenber.database.CRUD;
import com.example.one_x_ub.rmenber.interfaces.IMainPresenter;
import com.example.one_x_ub.rmenber.interfaces.IMainView;
import com.example.one_x_ub.rmenber.models.Login;

/**
 * Created by one-x-ub on 25/03/17.
 */

public class MainViewPresenter implements IMainPresenter{

    private IMainView view;
    private CRUD crud;
    private Login login;

    @Override
    public void onCreate(IMainView view) {
        this.view = view;
    }

    @Override
    public void checkInstanceCRUD() {
        if(crud == null) {
            crud = view.onInstaceCRUD();
        }
    }

    @Override
    public void onCloseSession(){
        checkInstanceCRUD();
        login = new Login(crud);
        login.setStatus(0);
        view.goActivity();
    }
}
