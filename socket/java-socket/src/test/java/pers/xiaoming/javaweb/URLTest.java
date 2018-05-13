package pers.xiaoming.javaweb;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;

public class URLTest {
    @Test
    public void testURLMethods() throws IOException {
        URL baidu = new URL("http://www.baidu.com");
        URL url =new URL(baidu,"/index.html?username=tom#test");

        System.out.printf("Protocol is %s\nHost is %s\nPort is %s\nDefault Port is %s\nPath is %s\n"
                + "File name is %s\nRef is %s\nQuery Param is %s\nUser Info is %s\nContent is %s\n",
                url.getProtocol(), url.getHost(), url.getPort(), url.getDefaultPort(), url.getPath(),
                url.getFile(), url.getRef(), url.getQuery(), url.getUserInfo(), url.getContent()
        );
    }
}
