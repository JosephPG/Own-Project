package com.example.one_x_ub.rmenber.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by one-x-ub on 09/03/17.
 */

public class ManageFileHelper {

    public static final String msg = "************************";
    private static final String msgfill = "ñññqwe12ññññqweqwe//dfs";
    public static final String optionmsg = msg + "\n" + msgfill + "\n" + msgfill;

    public static final String base = "sdcard";
    public static final String dir = "Rmenber";
    public static final String roottxt = ".OptionConfig.txt";
    public static final String dirbase = base + "/" + dir + "/";


    public static String getLocateBase(String locate, String dir){
        return locate + "/" + dir + "/";
    }

    public static int checkFiles(String locate, String dir, String filename, String message){
        // 0 = ok
        // 1 = dir and/or txt not exist
        int result = 0;
        if(!checkDir(locate, dir)){
            checkTxt(getLocateBase(locate, dir), filename, message);
            result = 1;

        }else{
            if(!checkTxt(getLocateBase(locate, dir), filename, message)){
                result = 1;
            }
        }
        return result;
    }

    public static boolean checkDir(String locate, String dir){
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

    public static boolean checkTxt(String locate, String filename, String message){
        boolean resp = true;
        File file = new File(locate, filename);
        try {
            if(!file.exists()){
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(message);
                fileWriter.close();
                resp = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public static ArrayList getLines(String locate, String filename){
        File file = new File(locate, filename);
        ArrayList<String> buffer = new ArrayList<String>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp;

            while((temp = bufferedReader.readLine()) != null){
                buffer.add(temp);
            }

            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static void setLines(ArrayList<String> buffer, String locate, String filename, int type){
        File file = new File(locate, filename);
        try {
            FileWriter fileWriter = (type == 0)? new FileWriter(file): new FileWriter(file, true);
            for (int i = 0; i < buffer.size(); i++) {
                fileWriter.write(buffer.get(i));
            }
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
