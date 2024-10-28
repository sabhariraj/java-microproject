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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutFrame extends JFrame {
    private JTextArea cartTextArea;
    private JButton confirmButton;

    public CheckoutFrame() {
        setTitle("Checkout");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cartTextArea = new JTextArea();
        confirmButton = new JButton("Confirm Order");

        add(new JScrollPane(cartTextArea), "Center");
        add(confirmButton, "South");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Place order logic
                JOptionPane.showMessageDialog(null, "Order confirmed!");
                dispose();
            }
        });

        setVisible(true);
    }
}

