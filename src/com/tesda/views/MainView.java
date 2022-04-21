package com.tesda.views;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public MainView(){

        JLabel welcome = new JLabel("Welcome to Product Inventory System", JLabel.CENTER);
        welcome.setVerticalTextPosition(JLabel.CENTER);
        welcome.setHorizontalTextPosition(JLabel.CENTER);
        add(welcome);
        setTitle("Main Window");
    }

}
