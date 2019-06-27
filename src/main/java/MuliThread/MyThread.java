package MuliThread;

public class MyThread extends Thread {
    public volatile static int count;

    /*多线程不安全的方法*/
    private static  synchronized void addCount() {
        for (int i = 0; i < 100; i++) {
            count = i;
        }
        System.out.println("count=" + count);
    }

    @Override
    public void run() {
        addCount();
    }
}