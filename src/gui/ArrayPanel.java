package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ArrayPanel extends JPanel {

    private boolean isRightArray = true;
    private final IntArrayModel controller;

    private final JTextField arrayField = new JTextField("0");
    private final JLabel isRightLabel = new JLabel("");

    public String getArrayText() {
        if (isRightArray) {
            return arrayField.getText();
        } else {
            return "";
        }
    }

    public IntArrayModel getController() {
        return controller;
    }

    public void setArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i : array) {
            stringBuilder.append(i);
            stringBuilder.append(' ');
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());

        arrayField.setText(stringBuilder.toString());
        controller.getIntArray().setNumbers(array);
    }

    public ArrayPanel(IntArrayModel controller) {
        this.controller = controller;
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JButton importBtn = new JButton("Импортировать массив");
        importBtn.addActionListener(e -> importArray());

        JButton exportBtn = new JButton("Экспортировать массив");
        exportBtn.addActionListener(e -> exportArray());

        JLabel arrayLabel = new JLabel("Массив целых чисел");

        arrayLabel.setFont(MainWindow.DEFAULT_FONT);
        isRightLabel.setFont(MainWindow.DEFAULT_FONT);

        arrayField.setFont(MainWindow.DEFAULT_FONT);
        arrayField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                update();
            }
        });

        panel.add(importBtn, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(5, 5, 5, 30);
        panel.add(exportBtn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(arrayLabel, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(arrayField, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 1;
        panel.add(isRightLabel, gbc);

        add(panel, BorderLayout.WEST);
    }

    public void update() {
        try {
            controller.getIntArray().parseString(arrayField.getText().strip());
            isRightLabel.setText("");
            isRightArray = true;
        } catch (NumberFormatException ignored) {
            isRightLabel.setText("Неверное значение");
            isRightArray = false;
        }
    }

    public void importArray() {
        ArrayFileDialog fileChooser = new ArrayFileDialog(this);
        fileChooser.ReadFile();
    }

    public void exportArray() {
        ArrayFileDialog fileDialog = new ArrayFileDialog(this);
        if (isRightArray)
            fileDialog.SaveFile();
        else
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "Текстовое поле содержит недопустимое значение",
                    "Ошибка записи файла",
                    JOptionPane.ERROR_MESSAGE
            );
    }
}
