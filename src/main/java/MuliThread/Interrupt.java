package MuliThread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class InterruptedClass implements Runnable {
    @Override
    public void run() {
        double d = 0.0f;
        try {
            while(!Thread.interrupted()) {
                System.out.println("Running in InterrupedClass");
                // before sleep, point 1
                Thread.sleep(2000);
                // before calculating, point 2
                System.out.println("Calculating...");
                for (int i = 0; i < 900000; i++) {
                    d = d + (Math.PI + Math.E) / d;
                }
                System.out.println("After calculating");
            }
        }catch(InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        }finally {
            System.out.println("In finally!");
        }
    }
}

public class Interrupt {

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new InterruptedClass());

//        Thread.sleep(1000);  // 如果睡眠1000ms，则在point1处之前就调用了shutdownNow，即调用了interrupt
        // 因此再调用sleep方法时会抛出异常并从catch处退出

        Thread.sleep(2005);  // 如果睡眠2001ms，则在point2处调用interrupt，即在正常运行处调用interrupt
        // 因此会执行完循环中的大数计算，再词运行到while(!Thread.interrupted())处
        // 时才回中断，退出while，不抛出异常

        // finally或catch中可以添加释放占用资源的代码
        exec.shutdownNow();
    }

}