package pers.xiaoming.javaweb.nio_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TCPClient {
    private Selector selector;

    SocketChannel socketChannel;

    private String hostIp;

    private int hostListenningPort;

    public TCPClient(String HostIp, int HostListenningPort) throws IOException {
        this.hostIp = HostIp;
        this.hostListenningPort = HostListenningPort;

        initialize();
    }


    private void initialize() throws IOException {
        socketChannel = SocketChannel.open(new InetSocketAddress(hostIp, hostListenningPort));
        socketChannel.configureBlocking(false);

        selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_READ);

        new TCPClientReadThread(selector);
    }

    public void sendMsg(String message) throws IOException {
        ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes("UTF-16"));

        int r = socketChannel.write(writeBuffer);
        System.out.println("write return:" + r);
        //socketChannel.
    }

    public static void main(String[] args) throws IOException {
        TCPClient client = new TCPClient("10.10.24.67", 1978);
        for(int i=0; i<10; i++){
            client.sendMsg("Nio" + i);
			/*try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
        }

    }
}

