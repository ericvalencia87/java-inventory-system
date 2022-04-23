package com.tesda;

import com.tesda.models.User;
import com.tesda.views.LoginView;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class Main {

    public static void main(String[] args)  throws NoSuchAlgorithmException, InvalidKeySpecException {

        LoginView loginView = new LoginView();
        try{

            User user = new User();
            System.out.println(user.generateStrongPasswordHash("password"));

        }catch (Exception ex){

        }

    }

}
