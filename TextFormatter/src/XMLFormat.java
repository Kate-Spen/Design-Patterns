import java.util.ArrayList;

public class XMLFormat implements IFormat{
    @Override
    public void format(ArrayList<String> data) {
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println("<document>");
        for (String line : data) {
            System.out.println("  <line>" + line + "</line>");
        }
        System.out.println("</document>");
    }
}