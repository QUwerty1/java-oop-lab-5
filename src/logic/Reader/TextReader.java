package logic.Reader;

import logic.IntArray.IntArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextReader extends Reader {
    final private BufferedReader input;


    public TextReader(InputStream inputStream) {
        super();
        input = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public int[] read() throws IOException {
        return new IntArray(input.readLine()).getNumbers();
    }

    @Override
    public void close() {
    }
}
