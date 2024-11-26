import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        DocumentEditor editor = new DocumentEditor();
        data.add("Blah blah blah blah help me");
        data.add("I'm so very tired right now");
        data.add("What is thirty plus seventy I think it is one hundred");
        TextFile file = new TextFile(data);
        int option = 0;
        switch (option){
            case 0:
                file.setFormat(new PlainTextFormat());
                break;
            case 1:
                file.setFormat(new HTMLFormat());
                break;
            case 2:
                file.setFormat(new MarkdownFormat());
                break;
            case 3:
                System.out.print("Enter file name to save: ");
                String fileName = scanner.nextLine();
                editor.saveDocument(fileName);
                break;
            default:
                file.setFormat(new PlainTextFormat());
        }
    }
}