package com.base.io.blocked;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/***
 * 阻塞的nio服务，在accept和read的时候都是阻塞的
 */
public class NioBlockedServerTest {
    public static void main(String[] args) {
        try {
            //0.创建buffer
            ByteBuffer buff = ByteBuffer.allocate(16);
            //1.创建服务器
            ServerSocketChannel server = ServerSocketChannel.open();

            //2.绑定监听端口
            server.bind(new InetSocketAddress(8080));

            //3.连接集合
            List<SocketChannel> channelList = new ArrayList();
            while (true){
                System.out.println("connecting ..");
                SocketChannel ch = server.accept();//阻塞
                System.out.println("connected ..");
                channelList.add(ch);
                for (SocketChannel channel : channelList) {
                    System.out.println("before read.");
                    channel.read(buff);//阻塞
                    buff.flip();
                    System.out.println(Charset.defaultCharset().decode(buff));
                    buff.clear();
                    System.out.println("after read.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
