package Bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppPool {
    List<App> apps;

    public AppPool() {
        this.apps = new ArrayList<>();
    }

    public void installApp(App app) {
        apps.add(app);
    }

    public String[] getApps() {
        return (apps.stream().map(App::getName).collect(Collectors.toList()).toArray(new String[apps.size()]));
    }
}
