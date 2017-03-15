package com.example.one_x_ub.rmenber.helpers;

import com.example.one_x_ub.rmenber.models.Login;

import java.util.ArrayList;

/**
 * Created by one-x-ub on 11/03/17.
 */

public class ControlAccessHelper {

    private ManageFileHelper manageFile;
    private Login login;
    private long timestamp;

    public ControlAccessHelper(ManageFileHelper manageFile, Login login){
        this.manageFile = manageFile;
        this.login = login;
        this.timestamp = System.currentTimeMillis()/1000;
    }

    public boolean checkDenyTime(){
        ArrayList<String> buffer = manageFile.getLines(manageFile.dirbase, manageFile.roottxt);
        long time;
        boolean deny;

        if(buffer.size() > 1 && !checkData(buffer.get(1))) {

            time = Long.parseLong(getDecrypt(buffer.get(1), login.getTextparam_1(),
                    login.getTextsalt_1()));
            if (time == 676 || (time - timestamp) < 300) {
                deny = true;
            } else {
                deny = false;
            }

        } else if(buffer.size() > 1 && checkData(buffer.get(1))) {
            deny = false;

        } else {
            deny = true;
        }
        return deny;
    }

    public void checkDenyCont(){

    }

    public void setDenyTime(){

    }

    public void setDenyCount(){

    }

    public String getDecrypt(String data, String iv, String salt){
        String decrypt = "676";
        try {
            CipherHelper cipherHelper = new CipherHelper(data, salt, iv);
            decrypt = cipherHelper.getDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypt;
    }

    public void getEncrypt(String data){

    }

    private boolean checkData(String data){
        return (data.equals("ñññqwe12ññññqweqwe//dfs"))? true: false;
    }

}
