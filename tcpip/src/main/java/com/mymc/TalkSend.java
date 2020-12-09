package com.mymc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend  implements Runnable  {

    DatagramSocket socket = null;
    //准备数据，从控制台读取System.in
    BufferedReader reader = null;

    private int fromPort;
    private String toIp;
    private int toPort;

    public TalkSend(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;
        try{
            socket = new DatagramSocket(fromPort);
            //准备数据，从控制台读取System.in
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while(true){
            try{
                String msg = reader.readLine();
                byte[] data = msg.getBytes();
                //准备封装发送包
                DatagramPacket sendPacket = new DatagramPacket(data,
                        data.length,
                        new InetSocketAddress(this.toIp,this.toPort));
                //发送
                socket.send(sendPacket);
                if(msg.equals("bye")){
                    break;
                }
            }catch (Exception e ){
                e.printStackTrace();
            }
        }
        //关闭流
        socket.close();
    }
}

