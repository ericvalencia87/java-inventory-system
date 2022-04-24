package com.tesda.views;

import com.tesda.daos.ProductsDao;
import com.tesda.models.Product;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductsPanel extends JPanel implements ActionListener {
    ProductsDao productsDao;
    List<Product> products;
    int index = 0;

    Border redline = BorderFactory.createLineBorder(Color.red);
    int ipad_x = 220;

    JLabel spaceLabel = new JLabel(" ");
    JLabel productIdLabel = new JLabel("Product Id: ");
    JTextField productIdTextField = new JTextField();

    JLabel productNameLabel = new JLabel("Product Name: ");
    JTextField productNameTextField = new JTextField();

    JLabel uomLabel = new JLabel("UoM: ");
    JTextField uomTextField = new JTextField();

    JLabel maxLevelLabel = new JLabel("Max Level: ");
    JTextField maxLevelTextField = new JTextField();

    JLabel minLevelLabel = new JLabel("Min Level: ");
    JTextField minLevelTextField = new JTextField();

    JLabel reorderLevelLabel = new JLabel("Reorder Level: ");
    JTextField reorderLevelTextField = new JTextField();

    JLabel locationLabel = new JLabel("Location: ");
    JTextField locationTextField = new JTextField();

    JButton firstButton = new JButton("First");
    JButton nextButton = new JButton("Next");
    JButton previousButton = new JButton("Previous");
    JButton lastButton = new JButton("Last");

    ProductsPanel(){
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
        //Product Id
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(productIdLabel, gbc);

        gbc.ipadx = ipad_x;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(productIdTextField, gbc);

        //Product Name
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(productNameLabel, gbc);

        gbc.ipadx = ipad_x;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(productNameTextField, gbc);

        //UoM
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(uomLabel, gbc);

        gbc.ipadx = ipad_x;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(uomTextField, gbc);

        //Max Level
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(maxLevelLabel, gbc);

        gbc.ipadx = ipad_x;
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(maxLevelTextField, gbc);

        //MinLevel
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(minLevelLabel, gbc);

        gbc.ipadx = ipad_x;
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(minLevelTextField, gbc);

        //Reorder Level
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(reorderLevelLabel, gbc);

        gbc.ipadx = ipad_x;
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(reorderLevelTextField, gbc);

        //Location
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(locationLabel, gbc);

        gbc.ipadx = ipad_x;
        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(locationTextField, gbc);

        //Spacer
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(new JLabel(" "), gbc);


        //firstButton
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(firstButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        panel.add(previousButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 9;
        panel.add(nextButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 9;
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
            productsDao = new ProductsDao();
            products = productsDao.getAllProducts();
            displayProduct(index);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void displayProduct(int index){
        productIdTextField.setText(String.valueOf(products.get(index).getProduct_id()));
        productNameTextField.setText(products.get(index).getProduct_name());
        uomTextField.setText(String.valueOf(products.get(index).getUom()));
        maxLevelTextField.setText(String.valueOf(products.get(index).getMax_level()));
        minLevelTextField.setText(String.valueOf(products.get(index).getMin_level()));
        reorderLevelTextField.setText(String.valueOf(products.get(index).getReorder_level()));
        locationTextField.setText(String.valueOf(products.get(index).getLocation()));
    }

    private void disableTextfields(){
        productIdTextField.disable();
        productNameTextField.disable();
        uomTextField.disable();
        maxLevelTextField.disable();
        minLevelTextField.disable();
        reorderLevelTextField.disable();
        locationTextField.disable();

    }

    private void setFont(int fontSize){

        Font font = new Font("Arial", Font.PLAIN, fontSize);

        productIdLabel.setFont(font);

        spaceLabel.setFont(font);
        productIdTextField.setFont(font);

        productNameLabel.setFont(font);
        productNameTextField.setFont(font);

        uomLabel.setFont(font);
        uomTextField.setFont(font);

        maxLevelLabel.setFont(font);
        maxLevelTextField.setFont(font);

        minLevelLabel.setFont(font);
        minLevelTextField.setFont(font);

        reorderLevelLabel.setFont(font);
        reorderLevelTextField.setFont(font);

        locationTextField.setFont(font);
        locationLabel.setFont(font);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        Object source = ae.getSource();

        if(source == firstButton){
            index = 0;
            displayProduct(index);
        }

        if(source == previousButton){

            if(index>0){
                index--;
            }
            displayProduct(index);
        }

        if(source == nextButton){
            if(index < products.size()-1){
                index++;
            }
            displayProduct(index);
        }

        if(source == lastButton){
            index = products.size() - 1;
            displayProduct(index);
        }
    }
}
