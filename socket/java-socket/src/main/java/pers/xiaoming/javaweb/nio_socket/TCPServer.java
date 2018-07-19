package pers.xiaoming.javaweb.nio_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TCPServer {
    private static final int BUFFER_SIZE = 1024;

    private static final int TIME_OUT = 3000;

    private static final int LISTEN_PORT = 1978;

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel listenerChannel = ServerSocketChannel.open();
        listenerChannel.socket().bind(new InetSocketAddress(LISTEN_PORT));

        // config listener channel to unblock mode
        listenerChannel.configureBlocking(false);

        // Only unblocking channel can register
        listenerChannel.register(selector, SelectionKey.OP_ACCEPT);

        TCPProtocol protocol = new TCPProtocolImpl(BUFFER_SIZE);

        while (true) {
            int keys = selector.select(TIME_OUT);
            System.out.print(keys);
            if (keys == 0) {
                System.out.println("独自等待.");
                continue;
            }

            Set<SelectionKey> set = selector.selectedKeys();
            System.out.println("selectedKeysSize:" + set.size());
            Iterator<SelectionKey> keyIter  = set.iterator();

            while (keyIter.hasNext()) {
                SelectionKey key = keyIter.next();

                try {
                    if (key.isAcceptable()) {
                        System.out.println("acceptable");
                        // inside this method, it will change interest from OP_ACCEPT to OP_READ
                        // without running the handleAccept() method, it will remain OP_ACCEPT status forever
                        protocol.handleAccept(key);
                    }

                    if (key.isReadable()) {
                        System.out.println("readable");
                        protocol.handleRead(key);
                    }

                    if (key.isValid() && key.isWritable()) {
                        protocol.handleWrite(key);
                    }
                } catch (IOException ex) {
                    keyIter.remove();
                    continue;
                }

                keyIter.remove();
            }
        }
    }
}
