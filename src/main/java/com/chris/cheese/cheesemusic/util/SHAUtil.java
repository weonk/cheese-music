package com.chris.cheese.cheesemusic.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtil {

    public static String sha1(String message) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] sha1Encode = messageDigest.digest(message.getBytes());
        return convertByteToHexString(sha1Encode);
    }

    public static String convertByteToHexString(byte[] bytes) {
        String result = "";
        for (int i = 0; i < bytes.length; i++) {
            int temp = bytes[i] & 0xff;
            String tempHex = Integer.toHexString(temp);
            if (tempHex.length() < 2) {
                result += "0" + tempHex;
            } else {
                result += tempHex;
            }
        }
        return result;
    }
}
