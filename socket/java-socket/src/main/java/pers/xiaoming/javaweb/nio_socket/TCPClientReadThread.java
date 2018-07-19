package pers.xiaoming.javaweb.nio_socket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class TCPClientReadThread implements Runnable {
    private Selector selector;

    public TCPClientReadThread(Selector selector) {
        this.selector = selector;

        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            while (selector.select() > 0) {
                for (SelectionKey sk : selector.selectedKeys()) {

                    if (sk.isReadable()) {
                        SocketChannel sc = (SocketChannel) sk.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        sc.read(buffer);
                        buffer.flip();

                        String receivedString = Charset.forName("UTF-16").newDecoder().decode(buffer).toString();

                        System.out.println("接收到来自服务器" + sc.socket().getRemoteSocketAddress() + "的信息:" + receivedString);

                        sk.interestOps(SelectionKey.OP_READ);
                    }

                    selector.selectedKeys().remove(sk);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

