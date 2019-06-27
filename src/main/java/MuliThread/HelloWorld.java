package MuliThread;

public class HelloWorld {
    void method1() {
        System.out.println("father method");
    }

    public static void main(String[] args) {
        child c = new child();
        c.method1();
    }

    static class child extends HelloWorld {
        public void method1() {
            super.method1();
        }
    }
}

