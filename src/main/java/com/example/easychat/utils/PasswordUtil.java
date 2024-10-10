package com.example.easychat.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;

public class PasswordUtil {

    public static String encrypt(String slat, String password) {
        byte[] encoded = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue(), slat.getBytes()).getEncoded();
        AES aes = SecureUtil.aes(encoded);
        return aes.encryptBase64(password);
    }

    public static String decrypt(String slat, String password) {
        byte[] encoded = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue(), slat.getBytes()).getEncoded();
        AES aes = SecureUtil.aes(encoded);
        return aes.decryptStr(password);
    }
}
