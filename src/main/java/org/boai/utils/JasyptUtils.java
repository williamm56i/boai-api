package org.boai.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.PropertyValueEncryptionUtils;

public class JasyptUtils {

    public static String encrypt(String content, String password) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(password);
        return PropertyValueEncryptionUtils.encrypt(content, encryptor);
    }

    public static String decrypt(String encContent, String password) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(password);
        return PropertyValueEncryptionUtils.decrypt(encContent, encryptor);
    }
}
