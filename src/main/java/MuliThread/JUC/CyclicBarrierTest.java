package MuliThread.JUC;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 为线程设置屏障
 * 使用的包包含Reentrelock和Condition(用于设置等待)
 * 需要设置当全部线程都到达时需要运行的东西Runnable
 * 在一个主控程序doAwait中实现了全部的功能
 * 当前状态完成时，需要进入新的状态
 * 这就意味着可以执行多次
 */
public class CyclicBarrierTest {

    private static CyclicBarrier cyclicBarrier;

    static class CyclicBarrierThread extends Thread {
        public void run() {
            System.out.println(Thread.currentThread().getName() + "到了");
            //等待
            try {
                cyclicBarrier.await(2, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("人到齐了，开会吧....");
            }
        });

        for (int i = 0; i < 10; i++) {
            new CyclicBarrierThread().start();
        }
    }

}