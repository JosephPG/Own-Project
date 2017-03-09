package com.example.one_x_ub.rmenber.presenters;

import com.example.one_x_ub.rmenber.resources.Permission;
import com.example.one_x_ub.rmenber.resources.ViewDialog;
import com.example.one_x_ub.rmenber.interfaces.ILoginPresenter;
import com.example.one_x_ub.rmenber.interfaces.ILoginView;
import com.example.one_x_ub.rmenber.models.Login;

/**
 * Created by one-x-ub on 01/03/17.
 */

public class LoginViewPresenter implements ILoginPresenter{

    private ILoginView view;
    private Login login;
    private Permission permission;

    @Override
    public void onCreate(ILoginView view){
        this.view = view;
    }

    @Override
    public void checkPermits(){
        permission = view.onCreatePermits();
        permission.checkPermissionWriteExternalStorage();
    }

    @Override
    public void onLogin(String password){

    }

    @Override
    public Object[] getViewDialog(ViewDialog viewDialog){
        Object[] o_dialog = new Object[2];
        viewDialog.createAlertDialog();
        o_dialog[0] = viewDialog.getView();
        o_dialog[1] = viewDialog.getAlertDialog();
        return o_dialog;
    }

}
