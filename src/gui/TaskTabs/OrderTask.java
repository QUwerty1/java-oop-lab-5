package gui.TaskTabs;

import gui.MainWindowController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class OrderTask extends JPanel {

    private final MainWindowController controller;
    private final JLabel order = new JLabel("");

    public OrderTask(MainWindowController controller) {
        this.controller = controller;
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        JButton guessOrderBtn = new JButton("Определить упорядоченность");
        guessOrderBtn.addActionListener(e -> onGuess());
        order.setFont(new Font("Arial", Font.BOLD, 18));
        order.setAlignmentX(JLabel.CENTER);

        add(guessOrderBtn, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(10, 40, 0,40);
        gbc.anchor = GridBagConstraints.CENTER;
        add(order, gbc);

    }

    public void onGuess() {
        order.setText(controller.getIntArray().getOrder().toString());
    }
}
