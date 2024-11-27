import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DocumentEditor {
    private ArrayList<String> data;
    private IFormat format;

    public DocumentEditor() {
        this.data = new ArrayList<>();
        this.format = new PlainTextFormat();
    }
    public void setData(ArrayList<String> data){
        this.data = data;
    }
    public void setFormat(IFormat format){
        this.format = format;
    }
    public void saveDocument(String fileName) {
        try{
            format.format(data);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        }
        } catch (IOException e) {
            System.err.println("Couldn't save document");
        }
    }
}

