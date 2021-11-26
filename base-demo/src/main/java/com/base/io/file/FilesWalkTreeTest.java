package com.base.io.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

public class FilesWalkTreeTest {
    public static void main(String[] args) throws IOException {
        AtomicInteger dirCnt = new AtomicInteger();
        AtomicInteger fileCnt = new AtomicInteger();
        Files.walkFileTree(Paths.get("/Users/wangjibo/Documents/worker/hydee/dev/idea/myproject/java-demos/base-demo/src/main/java/com/base/io"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("==>");
                dirCnt.incrementAndGet();
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                fileCnt.incrementAndGet();
                return super.visitFile(file, attrs);
            }
        });
        System.out.println("文件夹个数：" + dirCnt.get());
        System.out.println("文件个数：" + fileCnt.get());


    }
}
