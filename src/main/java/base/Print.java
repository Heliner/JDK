package base;

public class Print {
    public static void main(String[] args) {
        String str = null;
        int i = 0;
        /*符合递归下降(LL)分析的方式*/
        System.out.println("this is string" + str == null);
//        System.out.println(++i+i++);
//        System.out.println(i++ + ++i);
        /*这里能解决二义性是 因为有空格存在*/
//        System.out.println(i++ + ++i);
        /*注意到这里的i++ 解析后 解析+ 后发生二义性++||+*/
        System.out.println(i++ + + +i);
    }
}
