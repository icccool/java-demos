package com.base.io.nonblocked;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/***
 * 阻塞的nio服务，在accept和read的时候都是阻塞的
 */
public class NioNonBlockedServerTest {
    public static void main(String[] args) {
        try {
            ServerSocketChannel server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(8080));

            Selector selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT, null);

            while (true){
                //没有事件时一直阻塞
                selector.select();

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> crunchifyIterator = selectedKeys.iterator();
                while (crunchifyIterator.hasNext()) {
                    SelectionKey myKey = crunchifyIterator.next();
                    if (myKey.isAcceptable()) {
                        //请求连接事件
                        SocketChannel crunchifyClient = server.accept();
                        crunchifyClient.configureBlocking(false);
                        ByteBuffer att = ByteBuffer.allocate(16);
                        crunchifyClient.register(selector, SelectionKey.OP_READ,att);
                        System.out.println("Connection Accepted: " + crunchifyClient.getLocalAddress() + "\n");
                    } else if (myKey.isReadable()) {
                        //读事件
                        ByteBuffer att = (ByteBuffer) myKey.attachment();
                        SocketChannel crunchifyClient = (SocketChannel) myKey.channel();
                        int r = crunchifyClient.read(att);//如果客户端已经建立连接，客户端强制关闭：远程主机强制关闭一个现有的连接。
                        if(r == -1){
                            //连接断开
                            myKey.cancel();
                        }else {
                            //拆分包
                            //接收buff是否不足
                            //重新分配足够的buff
                            //重新放入key的附件： myKey.attach(obj);
                        }
                        String result = new String(att.array()).trim();
                        System.out.println("Message received: " + result);
                    }
                    crunchifyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
