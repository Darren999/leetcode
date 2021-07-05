package com.leetcode;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TestIp {
    public static void main(String[] args){
        Socket connect = new Socket();

        try {
            connect.connect(new InetSocketAddress("211.138.118.231", 37013),100);
            boolean res = connect.isConnected();
            System.out.println("" + res);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                connect.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}