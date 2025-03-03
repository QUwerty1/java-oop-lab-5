package gui;

import gui.TaskTabs.DuplicateTask;
import gui.TaskTabs.ConditionTask;
import gui.TaskTabs.OrderTask;

import javax.swing.*;
import java.util.ArrayList;

public class TasksTabsPane extends JPanel {

    private final ArrayList<JPanel> tabs = new ArrayList<>();
    private JPanel currentTab;

    public TasksTabsPane(MainWindow mainWindow) {

        tabs.add(new DuplicateTask(mainWindow));
        tabs.add(new OrderTask(mainWindow.getController()));
        tabs.add(new ConditionTask(mainWindow));

        for (JPanel panel : tabs) {
            add(panel);
            panel.setVisible(false);
        }
        currentTab = tabs.getFirst();
        currentTab.setVisible(true);
    }

    public void setTab(int index) {
        currentTab.setVisible(false);
        currentTab = tabs.get(index);
        currentTab.setVisible(true);
        invalidate();
        validate();
    }
    public JPanel getTab() {
        return currentTab;
    }
}
