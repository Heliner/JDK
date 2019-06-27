package MuliThread;

/**
 * 测试对象锁
 */
public class SynchronizedObject {
    public synchronized void fakeStop2() {
        /*进行一些处理*/
        System.out.println("我开始处理方法二了");
        try {
            Thread.sleep(3000 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("我被中断了");
        }
    }

    public synchronized void fakeStop1() {
        /*进行一些处理*/
        System.out.println("我开始处理方法一了");
        try {
            Thread.sleep(3000 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("我被中断了");
        }

    }


}
