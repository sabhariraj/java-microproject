/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_project;

/**
 *
 * @author Lenovo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DashboardFrame extends JFrame {
    private JList<String> itemList;
    private DefaultListModel<String> listModel;
    private JButton addToCartButton;
    private JButton checkoutButton;

    public DashboardFrame() {
        setTitle("Grocery Dashboard");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(itemList);

        addToCartButton = new JButton("Add to Cart");
        checkoutButton = new JButton("Checkout");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addToCartButton);
        buttonPanel.add(checkoutButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        loadItems();

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add selected item to cart
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckoutFrame();
            }
        });

        setVisible(true);
    }

    private void loadItems() {
        GroceryDAO groceryDAO = new GroceryDAO();
        List<GroceryItem> items = groceryDAO.getAllItems();
        for (GroceryItem item : items) {
            listModel.addElement(item.getItemName() + " - $" + item.getPrice());
        }
    }
}

