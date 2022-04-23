package com.tesda.views;

import com.tesda.models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    public LoginView(){
        super("Login Autentification");

        JButton blogin = new JButton("Login");
        JPanel loginpanel = new JPanel();
        JTextField txuser = new JTextField(15);
        JPasswordField pass = new JPasswordField(15);
        JButton newUSer = new JButton("New User?");
        JLabel username = new JLabel("User - ");
        JLabel password = new JLabel("Pass - ");

        setSize(300,200);
        setLocation(500,280);
        loginpanel.setLayout (null);


        txuser.setBounds(70,30,150,20);
        pass.setBounds(70,65,150,20);
        blogin.setBounds(110,100,80,20);
        newUSer.setBounds(110,135,80,20);
        username.setBounds(20,28,80,20);
        password.setBounds(20,63,80,20);

        loginpanel.add(blogin);
        loginpanel.add(txuser);
        loginpanel.add(pass);
        loginpanel.add(newUSer);
        loginpanel.add(username);
        loginpanel.add(password);

        getContentPane().add(loginpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                /* Pinag iisipan ko pa ano better way. Pero temporarily, kunyare authenticated yung user, Ioopen ko yung main screen from here.
                 * Another option na kinoconsider ko is magbato ng signal sa Main Class, then si Main class ang mag open ng screen.
                 *
                 */
                MainView mainView = new MainView();
                mainView.setExtendedState(JFrame.MAXIMIZED_BOTH);
                mainView.setVisible(true);
                dispose();

            }
        });

    }


    //TODO get the credentials given by the user and use it to authenticate
    public void authenticate(){

    }
}
