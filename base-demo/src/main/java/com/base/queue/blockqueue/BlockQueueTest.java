package com.base.queue.blockqueue;

import java.util.Arrays;
import java.util.concurrent.*;

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
            BlockingQueue<String> queue = new LinkedBlockingDeque(Arrays.asList(new String[]{"a","b","c"}));


            for (int i = 0; i < 3; i++) {
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
                while (true) {
                    String str = queue.poll(1000L, TimeUnit.MILLISECONDS);
                    if(str == null){
                        break;
                    }
                    long sleepTime = (long) ((Math.random() + 1) * 1000);
                    Thread.sleep(sleepTime);
                    System.out.println(String.format("thread-id =%s, str = %s , cost = %s", Thread.currentThread().getId(), str, String.valueOf(sleepTime)));
                    if (str != null) {
//                    queue.put(str);
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
