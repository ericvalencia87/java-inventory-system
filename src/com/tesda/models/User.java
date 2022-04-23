package com.tesda.models;


import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Timestamp;
import java.util.Base64;

public class User {

    private  static int iterations = 1000;

    //Fields
    private int user_id;
    private String username;
    private String password;
    private boolean user_type; //admin (true) or regular (false) - admin can add more user
    private String first_name;
    private String last_name;
    private boolean status;
    private java.sql.Timestamp date_created;
    private java.sql.Timestamp date_updated;

    public User(){

    }

    //Constructor for retrieving data from database all fields are present
    public User(int user_id, String username, String password,  boolean user_type, String first_name,
                String last_name, boolean status, java.sql.Timestamp date_created, java.sql.Timestamp date_updated) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
        this.first_name = first_name;
        this.last_name = last_name;
        this.status = status;
        this.date_created = date_created;
        this.date_updated = date_updated;
    }

    //Constructor for data provided by the user though the gui
    public User(String username, String password,  boolean user_type, String first_name,
                String last_name, boolean status) {
        this.username = username;
        this.password = password;
        this.user_type = user_type;
        this.first_name = first_name;
        this.last_name = last_name;
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isUser_type() {
        return user_type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public boolean isStatus() {
        return status;
    }

    public Timestamp getDate_created() {
        return date_created;
    }

    public Timestamp getDate_updated() {
        return date_updated;
    }

    public String generateStrongPasswordHash(String password)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt().getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf =
                SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return toHex(salt) + ":" + toHex(hash);

    }

    public static boolean validatePassword(String originalPassword,
                                            String storedPassword)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        String[] parts = storedPassword.split(":");
        //int iterations = Integer.parseInt(parts[0]);
        byte[] salt = fromHex(parts[0]);
        byte[] hash = fromHex(parts[1]);

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt,
                iterations, hash.length * 8);

        SecretKeyFactory skf =
                SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;

        for (int i = 0; i < hash.length && i < testHash.length; i++) {
            diff |= hash[i] ^ testHash[i];
        }

        return diff == 0;
    }

    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

    private static String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2),
                    16);
        }
        return bytes;
    }
}
