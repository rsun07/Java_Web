package pers.xiaoming.javaweb.socket;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPTest {
    @Test
    public void test() throws IOException {
        int serverPort = 10086;

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(this::runClient);
        executor.execute(new TCPServer(serverPort));
    }

    private void runClient() {
        String serverName = "localhost";
        int clientPort = 10086;

        TCPClient client = null;
        try {
            Thread.sleep(2000);
            client = new TCPClient(serverName, clientPort);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("First request : " + client.connect("Hello Server"));

        System.out.println("Second request : " +  client.connect("Second MSG"));
    }
}
