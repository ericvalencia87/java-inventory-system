package com.tesda.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    Border blackline = BorderFactory.createLineBorder(Color.black);

    JLabel title = new JLabel();

    JPanel mainPanel = new JPanel();
    JPanel toolsPanel = new JPanel();
    JPanel container = new JPanel();
    CardLayout card = new CardLayout();
    JPanel usersPanel = new UsersPanel();
    JPanel productsPanel = new ProductsPanel();

    public MainView(){
        //Create a border
        Font font = new Font("Arial", Font.PLAIN, 20);


        //Left Panel
        add(toolsPanel, BorderLayout.WEST);
        toolsPanel.setBorder(blackline);
        toolsPanel.setLayout(new GridLayout(20,1));
        JButton userButton = new JButton("Users");
        userButton.setFont(font);
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loadUsersPanel();
            }
        });
        JButton productButton = new JButton("Products");
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loadProductsPanel();
            }
        });
        productButton.setFont(font);
        toolsPanel.add(userButton);
        toolsPanel.add(productButton);


        //Main Panel

        add(mainPanel, BorderLayout.CENTER);
        mainPanel.setBorder(blackline);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(title, BorderLayout.NORTH);
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setBorder(blackline);
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        //Container Panel
        mainPanel.add(container, BorderLayout.CENTER);
        container.setLayout(new CardLayout());
        container.setBorder(blackline);
        container.setSize(500,500);

        container.setLayout(card);

        //Users Panel
        container.add(usersPanel, "users");


        //Products Panel
        JLabel productsLabel = new JLabel("Producst");
        productsLabel.setFont(new Font("Arial", Font.PLAIN, 100));
        //container.add(productsLabel,"products");
        container.add(productsPanel,"products");
        loadUsersPanel();


        setTitle("Product Inventory System");

        //Set the size before maximize
        int Width = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int Height = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setSize(Width-500,Height-100);

        // Exit the application and free memory
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private void loadUsersPanel(){

        title.setText("Users");
        card.show(container, "users");

    }

    private void loadProductsPanel(){

        title.setText("Products");
        card.show(container, "products");
    }

}
