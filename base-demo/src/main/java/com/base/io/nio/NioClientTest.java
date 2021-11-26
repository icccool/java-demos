package com.base.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NioClientTest {

    public static void main(String[] args) {
        try {
            SocketChannel sc = SocketChannel.open();
            sc.connect(new InetSocketAddress(8080));
            sc.write(Charset.defaultCharset().encode("hi!"));
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
