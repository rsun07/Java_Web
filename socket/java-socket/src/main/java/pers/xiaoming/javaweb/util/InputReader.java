package pers.xiaoming.javaweb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputReader {
    public static String inputStreamToString(InputStream in) throws IOException {
        return inputStreamToString(new InputStreamReader(in));
    }

    public static String inputStreamToString(InputStream in, String charsetName) throws IOException {
        return inputStreamToString(new InputStreamReader(in, charsetName));
    }

    private static String inputStreamToString(InputStreamReader inReader) throws IOException {
        BufferedReader bf = new BufferedReader(inReader);

        StringBuilder sb = new StringBuilder();

        String line;
        while( (line = bf.readLine()) != null) {
            sb.append(line);
        }
        bf.close();
        inReader.close();
        return sb.toString();
    }
}
