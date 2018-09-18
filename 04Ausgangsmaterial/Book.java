import java.util.ArrayList;

public class Book extends Item {

    private ArrayList<String> pageContent;

    private String category;


    public Book(String title){
        super(title);
        this.pageContent = new ArrayList<>();
        this.category = DEFAULT_CATEGORY;
    }

    public String getCategory(){return category;}
    public void setCategory(String category){this.category=category;}

    public String getDetails(){
        return super.getDetails()+ " # " + category;
    }
    public void addPage (String text_of_page) {
        pageContent.add (text_of_page);
    }

    public boolean contains (String text) {
        boolean found = false;
        int page = 0;
        while (!found && page < pageContent.size()) {
            found = pageContent.contains (text);
            page++;
        }
        return found;
    }
}
