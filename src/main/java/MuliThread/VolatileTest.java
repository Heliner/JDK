package MuliThread;

public class VolatileTest extends Thread {
    private /*volatile*/ boolean isRun = true;
    int m;

    @Override
    public void run() {
        System.out.println("进入run");
        int count = 0;
        while (isRun) {
            /*
            int CyclicBarrierTest = 2;
            int b = 3;
            int temp = CyclicBarrierTest + b;
            */
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            m = count++;
            System.out.println(m);
            /*加入非运算类的操作有助于cpu进出状态更换，使CPU进行值的更新*/
        }

        System.out.println(m);
        System.out.println("线程停止");
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }
}
