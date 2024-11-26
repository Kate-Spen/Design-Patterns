import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {
    private static Logger instance;
    private static final ReentrantLock lock = new ReentrantLock();
    private List<LogDestination> destinations = new ArrayList<>();
    private List<String> logHistory = new ArrayList<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private Logger() {
        destinations.add(new ConsoleLogDestination());
    }
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    public void addDestination(LogDestination destination) {
        destinations.add(destination);
    }
    public void log(LogLevel level, String message) {
        String timestamp = dateFormat.format(new Date());
        String formattedMessage = String.format("[%s] [%s]: %s", timestamp, level, message);
        lock.lock();
        try {
            logHistory.add(formattedMessage);
            for (LogDestination destination : destinations) {
                destination.write(formattedMessage);
            }
        } finally {
            lock.unlock();
        }
    }
    public List<String> getLogHistory() {
        lock.lock();
        try {
            return new ArrayList<>(logHistory);
        } finally {
            lock.unlock();
        }
    }
    public void flushLogs() {
        lock.lock();
        try {
            for (LogDestination destination : destinations) {
                destination.flush();
            }
        } finally {
            lock.unlock();
        }
    }
}

