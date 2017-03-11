package com.example.one_x_ub.rmenber.presenters;

import com.example.one_x_ub.rmenber.resources.DenyAccess;
import com.example.one_x_ub.rmenber.resources.ManageFile;
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
    private ManageFile manageFile;
    private DenyAccess deny;

    @Override
    public void onCreate(ILoginView view){
        this.view = view;
    }

    @Override
    public void checkPermits(){
        permission = view.onCreatePermits();
        permission.checkPermission();
    }

    @Override
    public void checkSession(){
        login = new Login(view.onCreateCRUD());
        if(login.getStatus() == 1){
            view.goToMainActivity();
        }
    }

    @Override
    public void onLogin(String password){
        manageFile = new ManageFile();
        deny = new DenyAccess(manageFile);

        if((manageFile.checkFiles(manageFile.base, manageFile.dir, manageFile.roottxt)) == 0){
            view.showMessage("En este punto se valida el login");
        }else{
            view.showMessage("La primera vez se debe bloquear, sino es q no estaban archivos");
        }
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
