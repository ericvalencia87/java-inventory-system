package com.tesda;

import com.tesda.daos.UserDao;
import com.tesda.models.User;
import com.tesda.views.LoginView;
import com.tesda.views.MainView;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.sql.* ;  // for standard JDBC programs
import java.util.Base64;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserDao userDao;

        try{
            userDao = new UserDao();
            List<User> users = userDao.getAllUser();

            if(users !=null){
                for(User user: users){
                    System.out.println("UserID " + String.valueOf(user.getUser_id())+
                            " UserName " + user.getUsername());
                }
            }else{
                System.out.println("USer does not exists!");
            }



        }catch (Exception e){
            e.printStackTrace();
        }

        /* The login view is the first window to appear in our application
        *  before the user can use the system, the user must be authenticated first */
//        LoginView loginView = new LoginView();
//
//        //Show the login screen
//        loginView.setVisible(true);


    }


    private void print(String string){
        System.out.println(string);
    }
}
