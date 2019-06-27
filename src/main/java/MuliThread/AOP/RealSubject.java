package MuliThread.AOP;

public class RealSubject implements Subject {
    @Override
    public void hello() {
        System.out.println("RealSubject : hello");
    }

    @Override
    public void request() {
        System.out.println("RealSubject : request");
    }
}
