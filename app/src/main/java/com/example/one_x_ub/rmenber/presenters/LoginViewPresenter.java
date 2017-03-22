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
    private ControlAccessHelper denyaccess;
    private static int count_intent;

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
    public void onAccess(){
        denyaccess = new ControlAccessHelper(manageFile, login);
        if((manageFile.checkFiles(manageFile.base, manageFile.dir, manageFile.roottxt,
                manageFile.optionmsg)) == 0){

            if(!denyaccess.checkDenyTime()) {

                if ((count_intent = denyaccess.getDenyCont()) >= 4) {
                    view.onDisabledButtonLogin(false);
                    view.showMessage("Bloqueado");
                } else {
                    view.onDisabledButtonLogin(true);
                }

            } else {
                view.onDisabledButtonLogin(false);
                view.showMessage("Bloqueado");
            }

        } else {
            denyaccess.setDenyAll(0);
            view.onDisabledButtonLogin(false);
            view.showMessage("Bloqueado");
        }
    }

    @Override
    public void onLoginValidation(String password){
        if (login.getPassword().equals(password)) {
            login.setStatus(1);
            view.goToMainActivity();

        } else {
            count_intent++;

            if(count_intent >= 4){
                denyaccess.setDenyAll(0);
                view.onDisabledButtonLogin(false);
                view.showMessage("Bloqueado");

            } else {
                denyaccess.setDenyCount(count_intent);
                view.showMessage("Contraseña incorrecta");
            }
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
