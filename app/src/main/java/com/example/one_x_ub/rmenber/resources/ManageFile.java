package com.example.one_x_ub.rmenber.resources;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by one-x-ub on 09/03/17.
 */

public class ManageFile {

    private final String msg = "********************************************";

    public final String base = "sdcard";
    public final String dir = "Rmenber";
    public final String roottxt = ".OptionConfig.txt";

    public String getLocateBase(String locate, String dir){
        return locate + "/" + dir + "/";
    }

    public int checkFiles(String locate, String dir, String filename){
        // 0 = Ok
        // 1 = Dir and Txt not exist
        // 2 = Dir exist, Txt not exist
        int result = 0;
        if(!checkDir(locate, dir)){
            checkTxt(getLocateBase(locate, dir), filename);
            result = 1;

        }else{
            if(!checkTxt(getLocateBase(locate, dir), filename)){
                result = 1;
            }
        }
        return result;
    }

    public boolean checkDir(String locate, String dir){
        boolean resp = true;
        File file = new File(locate, dir);
        try {
            if(!file.exists()){
                file.mkdir();
                resp = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public boolean checkTxt(String locate, String filename){
        boolean resp = true;
        File file = new File(locate, filename);
        try {
            if(!file.exists()){
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(msg);
                fileWriter.close();
                resp = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

}
