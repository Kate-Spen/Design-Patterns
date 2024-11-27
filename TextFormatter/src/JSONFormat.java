import java.util.ArrayList;

public class JSONFormat implements IFormat{
    @Override
    public void format(ArrayList<String> data){
        System.out.println("{");
        System.out.println("  \"lines\": [");
        for (int i = 0; i < data.size(); i++) {
            System.out.print("    \"" + data.get(i) + "\"");
            if (i < data.size() - 1) {
                System.out.print(",");
            }
            System.out.println();
        }
        System.out.println("  ]");
        System.out.println("}");
    }
}
