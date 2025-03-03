package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChooseTaskPanel extends JPanel {

    private final MainWindow mainWindow;
    private final ButtonGroup tasksGroup = new ButtonGroup();

    public ChooseTaskPanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(15, 0, 0, 5));

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints cbg = new GridBagConstraints();
        cbg.gridx = 0;
        cbg.gridy = 0;
        cbg.anchor = GridBagConstraints.WEST;

        JRadioButton duplicateBtn = new JRadioButton("Удалить дубликаты из массива", true);
        duplicateBtn.setFont(MainWindow.DEFAULT_FONT);
        duplicateBtn.addActionListener(e -> onChange(0));

        JRadioButton orderBtn = new JRadioButton("Упорядоченность массива");
        orderBtn.setFont(MainWindow.DEFAULT_FONT);
        orderBtn.addActionListener(e -> onChange(1));

        JRadioButton conditionBtn = new JRadioButton("Определить по условию");
        conditionBtn.setFont(MainWindow.DEFAULT_FONT);
        conditionBtn.addActionListener(e -> onChange(2));

        tasksGroup.add(duplicateBtn);
        tasksGroup.add(orderBtn);
        tasksGroup.add(conditionBtn);

        panel.add(duplicateBtn, cbg);

        cbg.gridy = 1;
        panel.add(orderBtn, cbg);

        cbg.gridy = 2;
        panel.add(conditionBtn, cbg);

        add(panel, BorderLayout.NORTH);
    }

    private void onChange(int index) {
        mainWindow.getTabsPane().setTab(index);
    }
}
