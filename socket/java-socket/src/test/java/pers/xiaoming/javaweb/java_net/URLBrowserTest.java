package pers.xiaoming.javaweb.java_net;

import org.junit.Ignore;
import org.junit.Test;
import pers.xiaoming.javaweb.java_net.URLBrowser;

import java.io.IOException;
import java.net.MalformedURLException;

@Ignore("demo test")
public class URLBrowserTest {

    @Test
    public void testBaidu() throws IOException {
        System.out.println(URLBrowser.browse("http://www.baidu.com"));
    }

    @Test(expected = MalformedURLException.class)
    public void testFailWithoutProtocol() throws IOException {
        try {
            URLBrowser.browse("www.baidu.com");
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
