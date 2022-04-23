package com.tesda.views;

import com.tesda.daos.UserDao;
import com.tesda.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    UserDao userDao;

    public LoginView() {
        super("Login Autentification");

        initializeFrame();

        initializeUserDao();

    }

    private void initializeFrame() {

        //Center the Login
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        JButton blogin = new JButton("Login");
        JPanel loginpanel = new JPanel();
        JTextField txuser = new JTextField(15);
        JPasswordField pass = new JPasswordField(15);
        JLabel info = new JLabel("");
        JLabel username = new JLabel("Username: ");
        JLabel password = new JLabel("Password: ");

        setSize(300, 200);
        setLocation(500, 280);
        loginpanel.setLayout(null);


        txuser.setBounds(85, 30, 150, 20);
        pass.setBounds(85, 65, 150, 20);
        blogin.setBounds(110, 120, 80, 20);
        info.setBounds(85,90,150,20);
        username.setBounds(20, 28, 80, 20);
        password.setBounds(20, 63, 80, 20);

        loginpanel.add(blogin);
        loginpanel.add(txuser);
        loginpanel.add(pass);
        loginpanel.add(info);
        loginpanel.add(username);
        loginpanel.add(password);

        getContentPane().add(loginpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);
        setVisible(true);

        blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = txuser.getText();
                String password = pass.getText();

                try{
                    User currentUser = userDao.getUserByUsername(username);
                    if(currentUser != null){
                      if(User.validatePassword(password, currentUser.getPassword())){

                          //Open the Main Window and pass currentUser as  a parameter
                          System.out.print("Open Sesame");
                          MainView mainView = new MainView();
                          mainView.setExtendedState(JFrame.MAXIMIZED_BOTH);
                          mainView.setVisible(true);
                          dispose();

                      }else{
                          //Prompt Wrong Password
                          System.out.print("Wrong Password");
                          info.setText("Wrong Password!");

                      }
                    }else{
                        //Prompt User does not exist
                        System.out.print("User does not exist");
                        info.setText("User not found!");

                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });
    }

    private void initializeUserDao() {
        try {
            userDao = new UserDao();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
