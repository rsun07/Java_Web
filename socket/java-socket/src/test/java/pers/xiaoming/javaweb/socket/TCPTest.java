package pers.xiaoming.javaweb.socket;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TCPTest {
    private static final int SERVER_PORT = 10086;
    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(2);

    @Test
    public void test() throws InterruptedException {
        new Thread(this::startServer).start();
        new Thread(this::runClient).start();
        COUNT_DOWN_LATCH.await(1000, TimeUnit.SECONDS);
    }

    private void startServer() {
        try {
            TCPServer server = new TCPServer(SERVER_PORT);
            server.start();
            Thread.sleep(3000);
            COUNT_DOWN_LATCH.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void runClient() {
        String serverName = "localhost";
        try {
            Thread.sleep(2000);
            TCPClient client = new TCPClient(serverName, SERVER_PORT);

            System.out.println("First request : " + client.connect("HelloServer"));
            System.out.println("Second request : " +  client.connect("SecondMSG"));

            COUNT_DOWN_LATCH.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
