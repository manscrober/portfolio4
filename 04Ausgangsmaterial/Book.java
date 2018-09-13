import java.util.ArrayList;

public class Book {
    public String caption;
    public String category;
    public ArrayList<String> pageContent;
    private boolean compactDisc;

    public Book (String title) {
        this.caption = title;
        this.category = "Roman";
        this.pageContent = new ArrayList<>();
    }

    public void setCompactDisc (boolean compactDisc) {
        this.compactDisc = compactDisc;
    }

    public boolean isCompactDisc () {
        return compactDisc;
    }

    public void deleteBook (Library libRary) {
        libRary.books.remove (this);
        for (Client client : libRary.clients) {
            client.borrowedBooks.remove (this);
        }
    }

    public void addAndBorrowBook (Library l, Client CLIENT) {
        if (!l.books.contains(this)) {
            l.addBook (this);
        }
        if (!this.isCompactDisc()) {
            CLIENT.borrowedBooks.add (this);
        }
    }
    
    public void addAndBorrowCD (Library l, Client CLIENT) {
        if (!l.books.contains(this) && this.isCompactDisc()) {
            l.addBook (this);
        }
        if (this.isCompactDisc()) {
            CLIENT.borrowedBooks.add (this);
        }
    }
    
    public boolean hasCategory (String category) {
        return this.category.equals (category);
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