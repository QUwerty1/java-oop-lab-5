package gui;

import logic.IntArray.IntArray;

public class IntArrayModel {

    private final IntArray intArray;

    public IntArray getIntArray() {
        return intArray;
    }

    public IntArrayModel() {
        intArray = new IntArray(new int[] {0});
    }
}
