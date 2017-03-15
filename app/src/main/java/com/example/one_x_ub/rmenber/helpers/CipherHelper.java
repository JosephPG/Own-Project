package com.example.one_x_ub.rmenber.helpers;

import android.util.Base64;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
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

    private byte[] generateSalt(){
        byte[] salt = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(secureRandom.generateSeed(12));
        secureRandom.nextBytes(salt);
        return salt;
    }

    private IvParameterSpec generateIvParameterSpec(){
        byte[] salt = generateSalt();
        return new IvParameterSpec(salt);
    }

    private SecretKey generateSecretKey() throws Exception{
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(PBKDF2);
        PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt, num_iteration,
                                               key_bit);
        SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
        SecretKeySpec key_AES = new SecretKeySpec(secretKey.getEncoded(), alg_cipher);
        return key_AES;
    }

    public String getEncrypt() throws Exception{
        Cipher cipher = Cipher.getInstance(alg);
        cipher.init(cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] encrypt = cipher.doFinal(data);
        return new String(Base64.encodeToString(encrypt, Base64.DEFAULT));
    }

    public String getDecrypt() throws Exception{
        Cipher cipher = Cipher.getInstance(alg);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] decrypt = cipher.doFinal(data);
        return new String(decrypt, "UTF-8");
    }

    public String getSalt(){
        return new String(Base64.encodeToString(salt, Base64.DEFAULT));
    }

    public String getIvParameter(){
        byte[] iv = ivParameterSpec.getIV();
        return new String(Base64.encodeToString(iv, Base64.DEFAULT));
    }
}
