package MuliThread;

public class TestSynchronized {
    public static void main(String[] args) {
        SynchronizedObject synchronizedObject1 = new SynchronizedObject();
        SynchronizedObject synchronizedObject2 = new SynchronizedObject();
        synchronizedObject1.fakeStop1();
        synchronizedObject2.fakeStop2();
        FakeStopRunner1 fakeStopRunner1 = new FakeStopRunner1(synchronizedObject1);
        FakeStopRunner2 fakeStopRunner2 = new FakeStopRunner2(synchronizedObject2);
        fakeStopRunner1.start();
        fakeStopRunner2.start();
        System.out.println("尝试执行另外一个同步方法");
    }
}
