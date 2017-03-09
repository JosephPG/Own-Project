package com.example.one_x_ub.rmenber;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.one_x_ub.rmenber.database.CRUD;
import com.example.one_x_ub.rmenber.resources.Permission;
import com.example.one_x_ub.rmenber.resources.ViewDialog;
import com.example.one_x_ub.rmenber.interfaces.ILoginView;
import com.example.one_x_ub.rmenber.presenters.LoginViewPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    EditText login_edtpassword;
    EditText changepassword_, changepassword_new;
    TextView changepassword_ok, changepassword_cancel;
    LoginViewPresenter loginViewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_edtpassword = (EditText) findViewById(R.id.login_edt_password);

        loginViewPresenter = new LoginViewPresenter();
        loginViewPresenter.onCreate(this);
        loginViewPresenter.checkPermits();
        loginViewPresenter.checkSession();
    }

    @Override
    public Permission onCreatePermits(){
        return new Permission(this, getApplicationContext());
    }

    @Override
    public CRUD onCreateCRUD(){
        return new CRUD(this);
    }

    @Override
    public ViewDialog onCreateAlertDialog(){
        return new ViewDialog(this, R.layout.change_password);
    }

    @Override
    public void onClickLogin(View view){
        loginViewPresenter.onLogin(login_edtpassword.getText().toString());
    }

    @Override
    public void showCluePassword(View view){

    }

    @Override
    public void showDialogChangePassword(View view){
        Object[] dialog = loginViewPresenter.getViewDialog(onCreateAlertDialog());
        View vDialog = (View) dialog[0];
        changepassword_ = (EditText) vDialog.findViewById(R.id.changepassword_edt_password);
        changepassword_new = (EditText) vDialog.findViewById(R.id.changepassword_edt_passwordnew);
        changepassword_ok = (TextView) vDialog.findViewById(R.id.changepassword_txt_aceptar);
        changepassword_cancel = (TextView) vDialog.findViewById(R.id.changepassword_txt_cancelar);
        onClickChangePasswordOptions((AlertDialog) dialog[1]);
    }

    @Override
    public void showMessage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClickChangePasswordOptions(final AlertDialog alertDialog){
       changepassword_cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               alertDialog.dismiss();
           }
       });

       changepassword_ok.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               alertDialog.dismiss();
           }
       });

       alertDialog.show();
       alertDialog.setCancelable(false);
       alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        /** Callback, llamado despues de solicitar permisos **/
        if(requestCode == 1){
                if(grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    loginViewPresenter.checkPermits();
                }
        }
    }

    @Override
    public void goToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}
