package com.tesda.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class MainView extends JFrame {
    JPanel mainPanel = new JPanel();
    JPanel toolsPanel = new JPanel();
    JPanel container = new JPanel();
    CardLayout card = new CardLayout();
    JPanel usersPanel = new JPanel();
    JPanel productsPanel = new JPanel();

    public MainView(){
        //Create a border
        Font font = new Font("Arial", Font.PLAIN, 20);
        Border blackline = BorderFactory.createLineBorder(Color.black);

        //Left Panel

        add(toolsPanel, BorderLayout.WEST);
        toolsPanel.setBorder(blackline);
        toolsPanel.setLayout(new GridLayout(20,1));
        JButton userButton = new JButton("Users");
        userButton.setFont(font);
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                userButtonClicked();
            }
        });
        JButton productButton = new JButton("Products");
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                productsButtonClicked();
            }
        });
        productButton.setFont(font);
        toolsPanel.add(userButton);
        toolsPanel.add(productButton);


        //Main Panel

        add(mainPanel, BorderLayout.CENTER);
        mainPanel.setBorder(blackline);
        mainPanel.setLayout(new BorderLayout());
        JLabel title = new JLabel("Product Inventory System", JLabel.CENTER);
        mainPanel.add(title, BorderLayout.NORTH);
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setBorder(blackline);
        title.setFont(new Font("Arial", Font.PLAIN, 30));

        //Container Panel
        mainPanel.add(container, BorderLayout.CENTER);
        container.setLayout(new CardLayout());
        container.setBorder(blackline);
        container.setSize(500,500);

        container.setLayout(card);

        //Users Panel

        JLabel usersLabel = new JLabel("Users");
        container.add(usersLabel, "users");


        //Products Panel

        JLabel productsLabel = new JLabel("Producst");
        container.add(productsLabel,"products");
        card.show(container,"products");





        setTitle("Main Window");

        // Exit the application and free memory
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private void userButtonClicked(){
        card.show(container, "users");
    }

    private void productsButtonClicked(){
        card.show(container, "products");
    }

}
