package com.base.io;


import groovy.util.logging.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class BufferTest {
    public static void main(String[] args) {
        FileChannel channel  = null;
        try {
            //获得文件流和channel
            FileInputStream fileInputStream = new FileInputStream("/Users/wangjibo/Documents/worker/hydee/dev/idea/myproject/java-demos/base-demo/src/main/java/com/base/io/data.txt");
             channel  = fileInputStream.getChannel();
            //申请缓存
            ByteBuffer buf = ByteBuffer.allocate(10);
            while (true){
                //读入缓存
                int r = channel.read(buf);
                if(r == -1){
                    break;
                }
                //开始读
                buf.flip();
                while (buf.hasRemaining()){
                    System.out.println((char) buf.get());
                }
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
            //
            if(channel !=null){
                try {
                    channel.close();
                } catch (IOException ioException) {
                }
            }
        }

    }
}
