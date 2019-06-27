package Bridge;

public class Main {
    public static void main(String[] args) {
        AbstractPhone phone = new HuaweiPhone();
        phone.install(new ConcreteAppA());
        phone.install(new ConcreteAppB());
        System.out.println(phone.showAll());
        ;

    }
}
