public class ConsoleLogDestination implements LogDestination {
    @Override
    public void write(String message){
        System.out.println(message);
    }
    @Override
    public void flush() {

    }
}
