public class HTMLFormat implements IFormat{

    @Override
    public String format(String data){
        System.out.println("<html dir=\"ltr\" lang=\"en\">");
        System.out.println("<head>");

        for (int i = 0 ; i < data.size() ; i++){
            System.out.println("<text=" + data.get(i) + ">");
        }
        System.out.println("</head>");
        System.out.println("</html>");
        return data;
    }
}
