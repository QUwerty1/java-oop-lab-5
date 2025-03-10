package gui;

import logic.Reader.BinaryReader;
import logic.Reader.Reader;
import logic.Reader.TextReader;
import logic.Writer.BinaryWriter;
import logic.Writer.TextWriter;
import logic.Writer.Writer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ArrayFileDialog extends JFileChooser {

    private final ArrayPanel arrayPanel;

    public ArrayFileDialog(ArrayPanel arrayPanel) {
        this.arrayPanel = arrayPanel;

        addChoosableFileFilter(new FileNameExtensionFilter(
                "Текстовый файл (*.txt)", "txt"
        ));

        setFileFilter(new FileNameExtensionFilter(
                "Массив целых чисел (*.array)", "array"
        ));
    }

    public void SaveFile() {
        int chooseStatus = showSaveDialog(SwingUtilities.getWindowAncestor(arrayPanel));
        FileNameExtensionFilter filter = (FileNameExtensionFilter) getFileFilter();

        if (chooseStatus == JFileChooser.APPROVE_OPTION) {

            File file = getSelectedFile();
            String extension = filter.getExtensions()[0];
            String newFileName = file.getAbsolutePath() + '.' + extension;

            try (Writer writer = switch (extension) {
                case "array" -> new BinaryWriter(new FileOutputStream(
                        newFileName
                ));
                default -> new TextWriter(new FileOutputStream(
                        newFileName
                ));
            }) {
                writer.write(arrayPanel.getController().getIntArray().getNumbers());

            } catch (Exception ignored) {
                JOptionPane.showMessageDialog(
                        SwingUtilities.getWindowAncestor(this),
                        "Не удалось открыть файл",
                        "Ошибка записи файла",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public void ReadFile() {
        int chooseStatus = showOpenDialog(SwingUtilities.getWindowAncestor(arrayPanel));

        if (chooseStatus == JFileChooser.APPROVE_OPTION) {

            File file = getSelectedFile();
            try (Reader reader = switch (((FileNameExtensionFilter)
                    getFileFilter()).getExtensions()[0]) {
                case "array" -> new BinaryReader(new FileInputStream(file));
                default -> new TextReader(new FileInputStream(file));
            }) {
                arrayPanel.setArray(reader.read());

            } catch (IOException ignored) {
                JOptionPane.showMessageDialog(
                        SwingUtilities.getWindowAncestor(this),
                        "Не удалось открыть файл",
                        "Ошибка открытия файла",
                        JOptionPane.ERROR_MESSAGE
                );
            } catch (NumberFormatException ignored) {
                JOptionPane.showMessageDialog(
                        SwingUtilities.getWindowAncestor(this),
                        "Файл не содержит массива",
                        "Ошибка открытия файла",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
