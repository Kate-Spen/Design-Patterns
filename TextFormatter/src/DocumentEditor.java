import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DocumentEditor {
    private String content;
    private IFormat format;

    public DocumentEditor() {
        this.content = "";
        this.format = new PlainTextFormat();
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setFormat(IFormat format){
        this.format = format;
    }
    public void saveDocument(String fileName) {
        String formattedContent = format.format(content);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(formattedContent);
            System.out.println("Saved.");
        } catch (IOException e) {
            System.err.println("Couldn't save document");
        }
    }
}

