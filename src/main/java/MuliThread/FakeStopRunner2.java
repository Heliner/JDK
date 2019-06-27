package MuliThread;

public class FakeStopRunner2 extends Thread {
    private SynchronizedObject synchronizedObject = null;

    public FakeStopRunner2(SynchronizedObject synchronizedObject) {
        this.synchronizedObject = synchronizedObject;
    }

    @Override
    public void run() {
        this.synchronizedObject.fakeStop2();
    }
}
