package com.mymc;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {

    public static void main(String[] args)  {


        try {
            InetAddress inetAddress2 = InetAddress.getByName("localhost");
            System.out.println(inetAddress2);
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);



            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress3);
            InetAddress inetAddress4 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress4);

            String canonicalHostName = inetAddress4.getCanonicalHostName();
            System.out.println(canonicalHostName);
            String hostAddress = inetAddress4.getHostAddress();
            System.out.println(hostAddress);
            String hostName = inetAddress4.getHostName();
            System.out.println(hostName);
            byte[] address = inetAddress4.getAddress();
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }




    }
}
