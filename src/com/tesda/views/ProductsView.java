package com.tesda.views;

import com.tesda.daos.UserDao;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ProductsView extends JPanel {

    // Components of the Form
    private JLabel title;
    private JButton testButton;

    private UserDao userDao;

    Border redline = BorderFactory.createLineBorder(Color.red);
    Font font = new Font("Arial", Font.PLAIN, 30);

    JLabel labelSpace = new JLabel(" ");
    JLabel labelUserId = new JLabel("User Id: ");
    JTextField userIdTextField = new JTextField();

    public ProductsView() {

        JPanel panel = new JPanel();
        setLayout(new BorderLayout() );
        add(panel, BorderLayout.NORTH);

        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout grid = new GridBagLayout();
        panel.setLayout(grid);

        //setLayout(grid);
        setBorder(redline);

        labelUserId.setFont(font);
        labelSpace.setFont(font);
        userIdTextField.setFont(font);
        userIdTextField.setSize(500,100);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(labelSpace, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelUserId, gbc);

        gbc.ipadx = 300;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(userIdTextField, gbc);

//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.ipady = 20;
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        panel.add(new Button("Button Three"), gbc);
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        panel.add(new Button("Button Four"), gbc);
//        gbc.gridx = 0;
//        gbc.gridy = 2;

//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridwidth = 2;
//        panel.add(new Button("Button Five"), gbc);
//
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridwidth = 2;
//        panel.add(new JLabel("D"), gbc);


        setVisible(true);
    }
}
