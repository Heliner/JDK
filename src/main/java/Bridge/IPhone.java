package Bridge;

public class IPhone extends AbstractPhone {
    public IPhone() {
        this.appPool = new AppPool();
    }

    @Override
    public void install(App app) {
        this.appPool.installApp(app);
    }

    @Override
    public String[] showAll() {
        return
                appPool.getApps();
    }
}
