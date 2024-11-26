import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileDestination implements LogDestination{
    private BufferedWriter writer;

    public FileDestination(String fileName){
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e){
            throw new RuntimeException("Failed");
        }
    }
    @Override
    public synchronized void write(String message){
        try {
            writer.write(message);
            writer.newLine();
        } catch (IOException e){
            System.err.println("Failed");
        }
    }
    @Override
    public void flush(){
        try {
            writer.flush();
        } catch (IOException e){
            System.err.println("Failed");
        }
    }
}
