/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ricky
 */
public class hash {
    public static String getSHA256Hash(String input) {
        String rt = null;
        try {
            // Get an instance of the SHA-256 digest
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // Perform the hash computation
            byte[] encodedhash = digest.digest(input.getBytes("UTF-8"));
            
            // Convert byte array into signum representation
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            
            rt = hexString.toString();
        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return rt;
    }
}
