public interface LogDestination {
    void write(String message);
    void flush();
}
