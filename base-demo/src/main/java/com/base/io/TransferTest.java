package com.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class TransferTest {

    public static void main(String[] args) {

        try (
                FileChannel from = new FileInputStream("in.txt").getChannel();
                FileChannel to = new FileInputStream("out.txt").getChannel();
                ){
            //效率高 底层利用操作系统的0拷贝，但是有传输限制 2g，可分多次传输
            from.transferTo(0, from.size(), to);

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
