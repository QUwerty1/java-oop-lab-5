import javax.swing.*;

import gui.MainWindow;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            UIManager.getLookAndFeelDefaults()
//                    .put("defaultFont", new Font("Arial", Font.PLAIN, 14));
        } catch (Exception ignored) {
            System.out.println("Unable to load LookAndFeel");
        }
        MainWindow mainWindow = new MainWindow();
        mainWindow.setSize(800, 600);
        mainWindow.setVisible(true);
    }
}