public class Logger {
    private static volatile Logger single_instance = null;

    private Logger(){}

    public static Logger getInstance() {
        if (single_instance == null) {
            synchronized(Logger.class) {
                if (single_instance == null)
                    single_instance = new Logger();
            }
        }

        return single_instance;
    }

    public void log(String message) {
        System.out.println("[LOGGER] " + message);
    }
}
