package com.mymc;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
    DatagramSocket socket = null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port,String msgFrom) throws IOException {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            this.socket = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                //准备接收包裹
                byte[] container = new byte[1024];
                DatagramPacket receivedPacket = new DatagramPacket(container,0,container.length);
                socket.receive(receivedPacket); //阻塞式接收包裹
                //断开连接 byt
                byte[] data = receivedPacket.getData();
                //此处的Length选用receivedPacket的Length，若选用data的Length，可能会变成1024，并没有进行动态生成长度
                String receiveMsg = new String(data,0,receivedPacket.getLength());
                System.out.println( msgFrom + ":" + receiveMsg);
                if(receiveMsg.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //关闭流
        socket.close();
    }
}

