package com.example.one_x_ub.rmenber.interfaces;

import com.example.one_x_ub.rmenber.ui.views.AlertDialogView;

/**
 * Created by one-x-ub on 01/03/17.
 */

public interface ILoginPresenter {

    public void onCreate(ILoginView view);

    public void checkPermits();

    public void checkSession();

    public void onLogin(String password);

    public Object[] getViewDialog(AlertDialogView viewDialog);

}
