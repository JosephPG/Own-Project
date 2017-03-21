package com.example.one_x_ub.rmenber.helpers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.one_x_ub.rmenber.models.Login;

import java.util.ArrayList;

/**
 * Created by one-x-ub on 11/03/17.
 */

public class ControlAccessHelper {

    private ManageFileHelper manageFile;
    private Login login;

    public ControlAccessHelper(ManageFileHelper manageFile, Login login){
        this.manageFile = manageFile;
        this.login = login;
    }

    public boolean checkDenyTime(){
        ArrayList<String> buffer = manageFile.getLines(manageFile.dirbase, manageFile.roottxt);
        long time;
        boolean deny = false;

        if(buffer.size() > 1 && !checkData(buffer.get(1))) {
            time = Long.parseLong(getDecrypt(buffer.get(1), login.getTextparam_1(),
                    login.getTextsalt_1()));

            if (time == 676 || (System.currentTimeMillis()/1000 - time) < 300) {
                deny = true;
            }
        } else {
            deny = true;
        }
        return deny;
    }

    public int getDenyCont(){
        ArrayList<String> buffer = manageFile.getLines(manageFile.dirbase, manageFile.roottxt);
        int cont;

        if(buffer.size() > 2 && !checkData(buffer.get(2))){
            cont = Integer.parseInt(getDecrypt(buffer.get(2), login.getTextparam_2(),
                                               login.getTextsalt_2()));

        }else if(buffer.size() > 2 && checkData(buffer.get(2))){
            cont = 0;
        }else {
            cont = 4;
        }
        return cont;
    }

    public void setDenyCount(int cont){
        ArrayList<String> buffer = manageFile.getLines(manageFile.dirbase, manageFile.roottxt);
        if(buffer.size() == 3) {
            String contcipher = getEncrypt(String.valueOf(cont), 2);
            buffer.set(0, manageFile.msg + "\n");
            buffer.set(1, buffer.get(1) + "\n");
            buffer.set(2, contcipher);
            manageFile.setLines(buffer, manageFile.dirbase, manageFile.roottxt, 0);
        } else {
            setDenyAll(0);
        }
    }

    public void setDenyAll(int cont){
        ArrayList<String> buffer = manageFile.getLines(manageFile.dirbase, manageFile.roottxt);
        if(buffer.size() == 3) {
            long time = System.currentTimeMillis() / 1000;
            String timecipher = getEncrypt(String.valueOf(time), 1);
            String contcipher = getEncrypt(String.valueOf(cont), 2);
            buffer.set(0, manageFile.msg + "\n");
            buffer.set(1, timecipher);
            buffer.set(2, contcipher);
            manageFile.setLines(buffer, manageFile.dirbase, manageFile.roottxt, 0);
        } else {
            setDenyAll(0);
        }
    }

    public String getDecrypt(String data, String iv, String salt){
        String decrypt = "676";
        try {
            CipherHelper cipherHelper = new CipherHelper(data, salt, iv);
            decrypt = cipherHelper.getDecrypt();
            cipherHelper = null;
        } catch (Exception e) {
            setDenyAll(0);
            e.printStackTrace();
        }
        return decrypt;
    }

    public String getEncrypt(String data, int type){
        String encrypt = "";
        try {
            CipherHelper cipherHelper = new CipherHelper(data);
            encrypt = cipherHelper.getEncrypt();
            if(type == 1){
                login.setTextparam_1(cipherHelper.getIvParameter());
                login.setTextsalt_1(cipherHelper.getSalt());
            }else{
                login.setTextparam_2(cipherHelper.getIvParameter());
                login.setTextsalt_2(cipherHelper.getSalt());
            }
            cipherHelper = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypt;
    }

    private boolean checkData(String data){
        return (data.equals("ñññqwe12ññññqweqwe//dfs"))? true: false;
    }

}
