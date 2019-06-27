package MuliThread;

import java.util.LinkedList;

public class FakeStopRunner1 extends Thread {
    private SynchronizedObject synchronizedObject = null;

    public FakeStopRunner1(SynchronizedObject synchronizedObject) {
        this.synchronizedObject = synchronizedObject;
    }

    @Override
    public void run() {
//        LinkedList
        this.synchronizedObject.fakeStop1();
    }

}
