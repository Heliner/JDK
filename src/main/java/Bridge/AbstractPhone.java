package Bridge;

public abstract class AbstractPhone {
    AppPool appPool;

    public abstract void install(App app);

    public abstract String[] showAll();
}
