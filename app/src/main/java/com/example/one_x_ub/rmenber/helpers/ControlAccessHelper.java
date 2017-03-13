package com.example.one_x_ub.rmenber.helpers;

import java.util.ArrayList;

/**
 * Created by one-x-ub on 11/03/17.
 */

public class ControlAccessHelper {

    private ManageFileHelper manageFile;

    public ControlAccessHelper(ManageFileHelper manageFile){
        this.manageFile = manageFile;
    }

    public void getDnyInfo(){
        ArrayList<String> buffer = manageFile.getLines(manageFile.dirbase, manageFile.roottxt);

    }

}
