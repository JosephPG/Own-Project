package com.example.one_x_ub.rmenber.interfaces;

import android.support.v7.app.AlertDialog;
import android.view.View;

import com.example.one_x_ub.rmenber.database.CRUD;
import com.example.one_x_ub.rmenber.helpers.PermissionHelper;
import com.example.one_x_ub.rmenber.ui.views.AlertDialogView;

/**
 * Created by one-x-ub on 01/03/17.
 */

public interface ILoginView {

    public PermissionHelper onCreatePermits();

    public CRUD onCreateCRUD();

    public AlertDialogView onCreateAlertDialog();

    public void onClickLogin(View view);

    public void onCluePassword(View view);

    public void showDialogChangePassword(View view);

    public void showMessage(String msg);

    public void onClickChangePasswordOptions(AlertDialog alertDialog);

    public void goToMainActivity();

    public void onDisabledButtonLogin(boolean state);

    public void onDisabledChangePasswordOK();
}
