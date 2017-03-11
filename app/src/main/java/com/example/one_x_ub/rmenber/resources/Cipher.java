package com.example.one_x_ub.rmenber.resources;

import java.util.ArrayList;

/**
 * Created by one-x-ub on 11/03/17.
 */

public class Cipher {

    private ManageFile manageFile;

    public Cipher(ManageFile manageFile){
        this.manageFile = manageFile;
    }

    public void getDnyInfo(){
        ArrayList<String> buffer = manageFile.getLines(manageFile.dirbase, manageFile.roottxt);

    }

}
