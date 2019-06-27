package MuliThread;

public class SolutionA {
    String str = "abc";

    public static void main(String[] args) {
        SolutionA a = new SolutionA();
        SolutionA b = new SolutionA();
        System.out.println(a.str == b.str);
    }
}
