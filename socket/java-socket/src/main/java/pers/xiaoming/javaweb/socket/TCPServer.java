package pers.xiaoming.javaweb.socket;

import pers.xiaoming.javaweb.util.InputReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer extends Thread implements AutoCloseable {
    private static final String ENCODING =  "UTF-8";

    private final ServerSocket serverSocket;
    private final Socket socket;

    public TCPServer(int port) throws IOException {
        // 1. Start server socket, bind to port
        this.serverSocket = new ServerSocket(port);

        // 2. using the accept() method to start listening,
        // waiting for client connection
        this.socket = serverSocket.accept();
    }

    @Override
    public void run() {
        try {
            // 3. Get Client input from socket InputStream
            InputStream in = socket.getInputStream();
            String respMsg = InputReader.inputStreamToString(in, ENCODING);
            in.close();

            // 4. Get Output Stream from socket and return to client
            OutputStream out = socket.getOutputStream();
            PrintWriter printer = new PrintWriter(out);

            printer.printf("Request Received by TCP Server %s,\n"
                    + "Your input is : %s\n\n",
                    this.getName() + "\n", respMsg);
            printer.flush();
        } catch (IOException e) {
            // log and process io exception
            // omit here for socket demo
        }
    }

    @Override
    public void close() throws Exception {
        socket.close();
        serverSocket.close();
    }
}
