package pers.xiaoming.javaweb.socket;

import pers.xiaoming.javaweb.util.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClient implements AutoCloseable {
    private static final String ENCODING =  "UTF-8";

    private final Socket socket;

    public TCPClient(String host, int port) throws IOException {
        // 1. Start new client socket, bind to host and port
        this.socket = new Socket(host, port);
    }

    public String connect(String inputMsg) {
        String respMsg = null;
        try {
            // 2. Get OutputStream from socket to communicate with Server
            OutputStream out = socket.getOutputStream();
            PrintWriter printer = new PrintWriter(out);

            printer.printf(inputMsg);
            printer.flush();
            socket.shutdownOutput();

            // 3. Get InputStream from Server response
            InputStream in = socket.getInputStream();
            respMsg = InputReader.inputStreamToString(in, ENCODING);
            in.close();
        } catch (IOException e) {
            // log and process io exception
            // omit here for socket demo
        }
        return respMsg;
    }

    @Override
    public void close() throws Exception {
        socket.close();
    }
}
