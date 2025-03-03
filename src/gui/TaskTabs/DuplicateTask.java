package gui.TaskTabs;

import gui.MainWindow;
import logic.IntArray.IntArray;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DuplicateTask extends JPanel {
    private final JTextField answerField = new JTextField("");
    private final MainWindow mainWindow;
    private boolean hasAnything = false;

    public DuplicateTask(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        answerField.setFont(MainWindow.DEFAULT_FONT);
        answerField.setEditable(false);
        JButton filterBtn = new JButton("Отфильтровать");
        filterBtn.addActionListener((e) -> onFilter());
        JButton saveBtn = new JButton("Продолжить работать с этим массивом");
        saveBtn.addActionListener((e) -> onSave());

        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 20, 10);
        panel.add(answerField, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panel.add(filterBtn, gbc);

        gbc.gridx = 1;
        panel.add(saveBtn, gbc);

        add(panel, BorderLayout.WEST);
    }

    public void onFilter() {
        String text = mainWindow.getArrayPanel().getArrayText();

        if (!Objects.equals(text, "")) {
            answerField.setText(
                    mainWindow.getController().getIntArray().filteredDuplicates().toString());
            hasAnything = true;
        }
    }

    public void onSave() {
        if (hasAnything) {
            mainWindow.getArrayPanel().setArray(new IntArray(answerField.getText()).getNumbers());
        }
    }
}
