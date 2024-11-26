public class PlainTextFormat implements IFormat {

    @Override
    public String format(String data) {
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
        return data;
    }
}
