import java.util.ArrayList;

public class Item {
    public static final String DEFAULT_AUTHOR="unknown";
    public static final String DEFAULT_CATEGORY = "Roman";
    private String title;
    private String author;
    private ArrayList<String> keywords;

    public Item (String title) {
        this.title = title;
        this.author=DEFAULT_AUTHOR;
        this.keywords=new ArrayList<>();
    }

    public void addKeyword(String keyword){
        keywords.add(keyword);
    }
    public String getDetails(){
        String details = title+ " # "+author + " # ";
        for(String keyword:keywords){
            details+=keyword+",";
        }
        return details.substring(0,details.length()-1);
    }
    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author=author;}

    public String getTitle(){return title;}
}