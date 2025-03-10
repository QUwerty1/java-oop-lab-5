import gui.MainWindow;
import javax.swing.*;

// TODO Добавить отображение массива в виде таблицы
// FIXME Исправить вылет ошибки

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            UIManager.getLookAndFeelDefaults()
//                    .put("defaultFont", new Font("Arial", Font.PLAIN, 14));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored) {
            System.out.println("Unable to load LookAndFeel");
        }
        MainWindow mainWindow = new MainWindow();
        mainWindow.setSize(800, 600);
        mainWindow.setVisible(true);
    }
}