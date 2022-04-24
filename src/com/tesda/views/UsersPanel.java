package com.tesda.views;

import com.tesda.daos.UserDao;
import com.tesda.models.User;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket;
import java.util.List;

public class UsersPanel extends JPanel implements ActionListener {

    UserDao userDao;
    List<User> users;
    int index = 0;

    Border redline = BorderFactory.createLineBorder(Color.red);
    int ipad_x = 150;

    JLabel spaceLabel = new JLabel(" ");
    JLabel userIdLabel = new JLabel("User Id: ");
    JTextField userIdTextField = new JTextField();

    JLabel userNameLabel = new JLabel("Username: ");
    JTextField userNameTextField = new JTextField();

    JLabel userTypeLabel = new JLabel("User Type: ");
    JTextField userTypeTextField = new JTextField();

    JLabel firstNameLabel = new JLabel("First Name: ");
    JTextField firstNameTextField = new JTextField();

    JLabel lastNameLabel = new JLabel("Last Name: ");
    JTextField lastNameTextField = new JTextField();

    JButton firstButton = new JButton("First");
    JButton nextButton = new JButton("Next");
    JButton previousButton = new JButton("Previous");
    JButton lastButton = new JButton("Last");

    UsersPanel(){
        JPanel panel = new JPanel();
        setLayout(new BorderLayout() );
        add(panel, BorderLayout.NORTH);

        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout grid = new GridBagLayout();
        panel.setLayout(grid);


        //Set Fonts
        setFont(40);
        //Start Filling

        //Spacer
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        panel.add(spaceLabel, gbc);

        gbc.gridwidth = 2;
        //User Id
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(userIdLabel, gbc);

        gbc.ipadx = ipad_x;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(userIdTextField, gbc);

        //Username
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(userNameLabel, gbc);

        gbc.ipadx = ipad_x;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(userNameTextField, gbc);

        //UserType
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(userTypeLabel, gbc);

        gbc.ipadx = ipad_x;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(userTypeTextField, gbc);

        //First Name
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(firstNameLabel, gbc);

        gbc.ipadx = ipad_x;
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(firstNameTextField, gbc);

        //Last Name
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(lastNameLabel, gbc);

        gbc.ipadx = ipad_x;
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(lastNameTextField, gbc);

        //Spacer
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(new JLabel(" "), gbc);


        //firstButton
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(firstButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(previousButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        panel.add(nextButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 7;
        panel.add(lastButton, gbc);

        disableTextfields();
        firstButton.addActionListener(this);
        nextButton.addActionListener(this);
        previousButton.addActionListener(this);
        lastButton.addActionListener(this);

        initializeUserDao();

    }

    private void initializeUserDao(){
        try{
            userDao = new UserDao();
            users = userDao.getAllUser();
            displayUser(index);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void displayUser(int index){
        userIdTextField.setText(String.valueOf(users.get(index).getUser_id()));
        userNameTextField.setText(users.get(index).getUsername());
        userTypeTextField.setText(
                (users.get(index).isUser_type())? "Admin" : "Standard");
        firstNameTextField.setText(users.get(index).getFirst_name());
        lastNameTextField.setText(users.get(index).getLast_name());
    }

    private void disableTextfields(){
        userIdTextField.disable();
        userNameTextField.disable();
        userTypeTextField.disable();
        firstNameTextField.disable();
        lastNameTextField.disable();
    }

    private void setFont(int fontSize){

        Font font = new Font("Arial", Font.PLAIN, fontSize);

        userIdLabel.setFont(font);

        spaceLabel.setFont(font);
        userIdTextField.setFont(font);

        userNameLabel.setFont(font);
        userNameTextField.setFont(font);

        userTypeLabel.setFont(font);
        userTypeTextField.setFont(font);

        firstNameLabel.setFont(font);
        firstNameTextField.setFont(font);

        lastNameLabel.setFont(font);
        lastNameTextField.setFont(font);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        Object source = ae.getSource();

        if(source == firstButton){
            index = 0;
            displayUser(index);
        }

        if(source == previousButton){

            if(index>0){
                index--;
            }
            displayUser(index);
        }

        if(source == nextButton){
            if(index < users.size()-1){
                index++;
            }
            displayUser(index);
        }

        if(source == lastButton){
            index = users.size() - 1;
            displayUser(index);
        }
    }

    //
    private void print(String string){
        System.out.println(string);
    }
}
