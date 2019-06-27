package Bridge;

public class HuaweiPhone extends AbstractPhone {
    public HuaweiPhone() {
        this.appPool = new AppPool();
    }

    @Override
    public void install(App app) {
        this.appPool.installApp(app);
    }

    @Override
    public String[] showAll() {
        return appPool.getApps();
    }

}
