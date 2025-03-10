package gui;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.*;

public class MainWindow extends JFrame {

    private final IntArrayModel controller = new IntArrayModel();
    private final TasksTabsPane tabsPane = new TasksTabsPane(this);
    private final ArrayPanel arrayPanel = new ArrayPanel(controller);

    public ArrayPanel getArrayPanel() {
        return arrayPanel;
    }

    public IntArrayModel getController() {
        return controller;
    }

    public TasksTabsPane getTabsPane() {
        return tabsPane;
    }

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("IntArray GUI");

        arrayPanel.setMinimumSize(new Dimension(480, 100));

        ChooseTaskPanel choosePanel = new ChooseTaskPanel(this);
        choosePanel.setMinimumSize(new Dimension(260, 0));

        JSplitPane mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, choosePanel, tabsPane);
        mainPane.setEnabled(false);

        add(arrayPanel, BorderLayout.NORTH);
        add(mainPane, BorderLayout.CENTER);
        setMinimumSize(new Dimension(720, 400));
    }

    public final static Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 15);
}
