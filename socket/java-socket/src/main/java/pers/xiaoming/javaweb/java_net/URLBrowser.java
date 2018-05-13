package pers.xiaoming.javaweb.java_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLBrowser {
    private static final String ENCODING =  "UTF-8";

    public static String browse(String host) throws IOException {
        URL url = new URL(host);
        InputStream in = url.openStream();
        InputStreamReader inReader = new InputStreamReader(in, ENCODING);
        BufferedReader bf = new BufferedReader(inReader);

        StringBuilder sb = new StringBuilder();

        String line;
        while( (line = bf.readLine()) != null) {
            sb.append(line);
        }
        bf.close();
        inReader.close();
        in.close();
        return sb.toString();
    }
}
