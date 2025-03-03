package gui;

import logic.IntArray.IntArray;

public class MainWindowController {

    private final IntArray intArray;

    public IntArray getIntArray() {
        return intArray;
    }

    public MainWindowController() {
        intArray = new IntArray(new int[] {0});
    }
}
