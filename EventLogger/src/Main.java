public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.addDestination(new FileDestination("application"));
        logger.log(LogLevel.INFO, "Application has started");
        logger.log(LogLevel.DEBUG, "Debugging mode has started");
        logger.log(LogLevel.ERROR, "Error");

        System.out.println("\nLog History:");
        for (String log : logger.getLogHistory()){
            System.out.println(log);
        }
        logger.flushLogs();
    }
}