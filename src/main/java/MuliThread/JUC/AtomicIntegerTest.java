package MuliThread.JUC;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;


public class AtomicIntegerTest {

    private static AtomicInteger n2 = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                for(int i = 0; i < 200000000; i++) {
                    n2.decrementAndGet();
                }
            };
        };
        Thread t2 = new Thread() {
            public void run() {
                for(int i = 0; i< 100000000; i++) {
                    n2.incrementAndGet();
                }
            }
        };
        Thread t3 = new Thread() {
            public void run() {
                for(int i = 0; i< 100000000; i++) {
                    n2.incrementAndGet();
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1-1);
        System.out.println("最终n2的值为：" + n2.toString());
    }
    class AddOperator implements IntUnaryOperator {

        @Override
        public int applyAsInt(int operand) {
            return -1;
        }

    }
}