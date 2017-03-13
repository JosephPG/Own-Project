package com.example.one_x_ub.rmenber.helpers;

import android.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by one-x-ub on 11/03/17.
 */

public class CipherHelper {

    private final String alg = "AES/CBC/PKCS5Padding";
    private final String alg_cipher = "AES";
    private final String PBKDF2 = "PBKDF2WithHmacSHA1";
    private final int key_bit = 128;
    private final int num_iteration = 1000;
    private final String password = "mi8525flk3/hñh065";
    private byte[] data;
    private byte[] salt;
    private IvParameterSpec ivParameterSpec;
    private SecretKey secretKey;

    public CipherHelper(String data) throws Exception {
        this.data = data.getBytes();
        this.salt = generateSalt();
        this.ivParameterSpec = generateIvParameterSpec();
        this.secretKey = generateSecretKey();
    }

    public CipherHelper(String data, String salt, String IV) throws Exception {
        this.data = Base64.decode(data, Base64.DEFAULT);
        this.salt = Base64.decode(salt, Base64.DEFAULT);
        this.ivParameterSpec = new IvParameterSpec(Base64.decode(IV, Base64.DEFAULT));
        this.secretKey = generateSecretKey();
    }

    public byte[] generateSalt(){
        byte[] salt = new byte[16];

        /** FILL **/

        return salt;
    }

    public IvParameterSpec generateIvParameterSpec(){
        byte[] salt = generateSalt();
        return new IvParameterSpec(salt);
    }

    public SecretKey generateSecretKey(){

        /** FILL **/

        SecretKeySpec key_AES = null;
        return key_AES;
    }

    public void gEncrypt(){
        /** FILL **/
    }

    public void gDecrypt(){
        /** FILL **/
    }
}
