package gui.TaskTabs;

import gui.MainWindow;
import logic.IntArray.IntArray;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ConditionTask extends JPanel {

    private final JTextField answerField = new JTextField("");
    private final JTextField numberField = new JTextField("");
    private final JComboBox<String> conditions = new JComboBox<>(new String[]{"<", ">", "=", "<>"});

    private final MainWindow mainWindow;
    private boolean hasAnything = false;

    public ConditionTask(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        answerField.setFont(MainWindow.DEFAULT_FONT);
        answerField.setEditable(false);


        JButton filterBtn = new JButton("Отфильтровать");
        filterBtn.addActionListener((e) -> onFilter());
        JButton saveBtn = new JButton("Продолжить работать с этим массивом");
        saveBtn.addActionListener((e) -> onSave());

        panel.add(conditions, gbc);
        gbc.gridx = 1;
        panel.add(numberField, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(answerField, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 2;
        panel.add(filterBtn, gbc);

        gbc.gridx = 1;
        panel.add(saveBtn, gbc);

        add(panel, BorderLayout.WEST);
    }

    public void onFilter() {
        String text = mainWindow.getArrayPanel().getArrayText();

        try {
            if (!Objects.equals(text, "")) {
                String conditionText = conditions.getSelectedItem() + numberField.getText();
                answerField.setText(
                        mainWindow
                                .getController()
                                .getIntArray()
                                .filteredArray(conditionText)
                                .toString());
                hasAnything = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "Некорректное значение условия",
                    "Ошибка фильтрации",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void onSave() {
        if (hasAnything) {
            mainWindow.getArrayPanel().setArray(new IntArray(answerField.getText()).getNumbers());
        }
    }
}
