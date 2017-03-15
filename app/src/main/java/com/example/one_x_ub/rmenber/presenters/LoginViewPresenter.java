package com.example.one_x_ub.rmenber.presenters;

import com.example.one_x_ub.rmenber.helpers.ControlAccessHelper;
import com.example.one_x_ub.rmenber.helpers.ManageFileHelper;
import com.example.one_x_ub.rmenber.helpers.PermissionHelper;
import com.example.one_x_ub.rmenber.interfaces.ILoginPresenter;
import com.example.one_x_ub.rmenber.interfaces.ILoginView;
import com.example.one_x_ub.rmenber.models.Login;
import com.example.one_x_ub.rmenber.ui.views.AlertDialogView;

/**
 * Created by one-x-ub on 01/03/17.
 */

public class LoginViewPresenter implements ILoginPresenter{

    private ILoginView view;
    private Login login;
    private PermissionHelper permission;
    private ManageFileHelper manageFile;
    private ControlAccessHelper deny;

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
        deny = new ControlAccessHelper(manageFile, login);
        if((manageFile.checkFiles(manageFile.base, manageFile.dir, manageFile.roottxt,
            manageFile.optionmsg)) == 0){
            view.showMessage("En este punto se valida el login");
        }else{
            view.showMessage("La primera vez se debe bloquear, sino es q no estaban archivos");
        }
    }

    @Override
    public Object[] getViewDialog(AlertDialogView viewDialog){
        Object[] o_dialog = new Object[2];
        viewDialog.createAlertDialog();
        o_dialog[0] = viewDialog.getView();
        o_dialog[1] = viewDialog.getAlertDialog();
        return o_dialog;
    }

}
