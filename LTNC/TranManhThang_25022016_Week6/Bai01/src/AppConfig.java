public class AppConfig {

    private static volatile AppConfig single_instance = null;

    private String appName;
    private String version;
    private String logLevel;

    private AppConfig() {
        this.appName = "My Application";
        this.version = "1.0.0";
        this.logLevel = "INFO";
    }

    public static AppConfig getInstance() {
        if (single_instance == null) {
            synchronized (AppConfig.class) {
                if (single_instance == null)
                    single_instance = new AppConfig();
            }
        }

        return single_instance;
    }

    public String getAppName() { return appName; }
    public void setAppName(String appName) { this.appName = appName; }
    
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    
    public String getLogLevel() { return logLevel; }
    public void setLogLevel(String logLevel) { this.logLevel = logLevel; }

}
