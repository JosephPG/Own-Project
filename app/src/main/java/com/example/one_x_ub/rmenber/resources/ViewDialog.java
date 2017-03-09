package com.example.one_x_ub.rmenber.resources;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.example.one_x_ub.rmenber.R;

/**
 * Created by one-x-ub on 01/03/17.
 */

public class ViewDialog {

    private Activity activity;
    private AlertDialog alertDialog;
    private View view;
    private int resources_xml;

    public ViewDialog(Activity activity, int resources_xml){
        this.activity = activity;
        this.resources_xml = resources_xml;
    }

    public void createAlertDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        view = layoutInflater.inflate(resources_xml, null);
        alertDialogBuilder.setView(view);
        alertDialog = alertDialogBuilder.create();
    }

    public AlertDialog getAlertDialog() {
        return alertDialog;
    }

    public View getView() {
        return view;
    }

}
