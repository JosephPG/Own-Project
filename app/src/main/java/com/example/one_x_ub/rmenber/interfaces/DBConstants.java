package com.example.one_x_ub.rmenber.interfaces;

/**
 * Created by one-x-ub on 09/03/17.
 */

public interface DBConstants {

    /** Database **/

    final String Constants_DBNAME = "RRMEMBER";
    final String Constants_table = "login_data";

    final String Constants_id = "id";
    final String Constants_password = "password";
    final String Constants_status = "status";
    final String Constants_text_param = "text_param";
    final String Constants_text_salt = "text_salt";
    final String Constants_text_param2 = "text_param2";
    final String Constants_text_salt2 = "text_salt2";
    final String Constants_tema_pri = "tema_pri";
    final String Constants_codigo_tema = "codigo_tema";
    final String Constants_subtema = "subtema";
    final String Constants_codigo_subtema = "codigo_subtema";

    final String Constants_id_field =  Constants_id + " integer primary key,";
    final String Constants_password_field = Constants_password  + " text,";
    final String Constants_status_field = Constants_status + " integer,";
    final String Constants_text_param_field = Constants_text_param + " text,";
    final String Constants_text_salt_field = Constants_text_salt +" text,";
    final String Constants_text_param2_field = Constants_text_param2 + " text,";
    final String Constants_text_salt2_field = Constants_text_salt2 + " text,";
    final String Constants_tema_pri_field = Constants_tema_pri + " text,";
    final String Constants_codigo_tema_field = Constants_codigo_tema +" text,";
    final String Constants_subtema_field = Constants_subtema + " text,";
    final String Constants_codigo_subtema_field = Constants_codigo_subtema +" text";

    final String Constants_id_data = "616";
    final String Constants_password_data = "'correon2'";
    final String Constants_status_data = "0";
    final String Constants_text_data = "'-'";

    /** Query **/

    final String Constants_select_login_info = "select * from " + Constants_table + " where " +
                 Constants_id + "=" + Constants_id_data;
}
