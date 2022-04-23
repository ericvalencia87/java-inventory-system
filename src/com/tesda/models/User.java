package com.tesda.models;


import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.sql.Timestamp;
import java.util.Base64;

public class User {

    private int user_id;
    private String username;
    private String password;
    private boolean user_type; //admin (true) or regular (false) - admin can add more user
    private String first_name;
    private String last_name;
    private boolean status;
    private java.sql.Timestamp date_created;
    private java.sql.Timestamp date_updated;

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

    //    String password = "aaa";
//
//    SecureRandom random = new SecureRandom();
//    byte[] salt = new byte[16];
//
//        random.nextBytes(salt);
//
//    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
//
//        try{
//        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//        byte[] hash = factory.generateSecret(spec).getEncoded();
//
//        String base64Endcoded = Base64.getEncoder().encodeToString(hash);
//        System.out.println("Salt " + salt);
//        System.out.println("Hash " + hash);
//        System.out.println("Base64Encoded 2" +
//                "" + base64Endcoded);
//
//
//    }catch (Exception ex){
//        ex.printStackTrace();
//    }
}
