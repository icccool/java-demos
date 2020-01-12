package com.base.queue.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author WANG JI BO
 * @Date 2020/1/12 6:02 下午
 * @Description
 **/
public class BlockQueueTest {

    // 同步线程数
    private static int SYNC_THREADS = 3;

    // 全量同步线程池
    private static ExecutorService syncExecutor = Executors.newFixedThreadPool(SYNC_THREADS);

    public static void main(String[] args) {
        try {
            BlockingQueue<String> queue = new LinkedBlockingDeque();
            queue.add("a");
            queue.add("b");
            queue.add("c");

            for (int i = 0; i < SYNC_THREADS; i++) {
                syncExecutor.submit(new SyncWorker(1, queue));
            }

            while (true) {
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class SyncWorker implements Runnable {

        BlockingQueue<String> queue;
        int type;
        SyncWorker() {
        }
        SyncWorker(int type, BlockingQueue<String> queue) {
            this.queue = queue;
            this.type = type;
        }

        @Override
        public void run() {
            try {
                String str = queue.peek();
                System.out.println(String.format("str = %s\n", str));
                Thread.sleep(1000L);
                if (str != null) {
                    queue.put(str);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
