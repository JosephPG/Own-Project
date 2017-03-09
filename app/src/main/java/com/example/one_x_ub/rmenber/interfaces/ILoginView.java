package com.example.one_x_ub.rmenber.interfaces;

import android.support.v7.app.AlertDialog;
import android.view.View;

import com.example.one_x_ub.rmenber.resources.Permission;
import com.example.one_x_ub.rmenber.resources.ViewDialog;

/**
 * Created by one-x-ub on 01/03/17.
 */

public interface ILoginView {

    public Permission onCreatePermits();

    public void onClickLogin(View view);

    public void showCluePassword(View view);

    public void showDialogChangePassword(View view);

    public ViewDialog onCreateAlertDialog();

    public void onClickChangePasswordOptions(AlertDialog alertDialog);
}
