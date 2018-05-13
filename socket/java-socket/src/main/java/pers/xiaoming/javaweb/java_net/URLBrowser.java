package pers.xiaoming.javaweb.java_net;

import pers.xiaoming.javaweb.util.InputReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLBrowser {
    private static final String ENCODING =  "UTF-8";

    public static String browse(String host) throws IOException {
        URL url = new URL(host);
        InputStream in = url.openStream();
        String response = InputReader.inputStreamToString(in, ENCODING);
        in.close();
        return response;
    }
}
