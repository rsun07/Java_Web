package pers.xiaoming.javaweb.java_net;

import org.junit.Ignore;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Ignore("demo test")
public class InetAddressTest {
    @Test
    public void getLocalHost() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();

        printAddress(address);
    }

    @Test
    public void getRemoteHost() throws UnknownHostException {
        InetAddress address = InetAddress.getByName("www.baidu.com");

        printAddress(address);
    }

    private void printAddress(InetAddress address) {
        byte[] ipAddress = address.getAddress();

        System.out.printf("Host Name is %s\n" + "Host Address is %s\n" + "Address int byte[] format :",
                address.getHostName(), address.getHostAddress());
        for (byte b : ipAddress) {
            System.out.print(Integer.toBinaryString(b));
        }
        System.out.println("\n\n");
    }
}
