import java.util.ArrayList;

public class Library {

    public ArrayList<Book> books = new ArrayList();

    public ArrayList<Client> clients = new ArrayList();

    public void addBook (Book book) {
        books.add (book);
    }

    public void printListOfBooks () {
        for (Book book : books) {
            if (!book.isCompactDisc()) {
                System.out.println (book.caption+" # "+book.category);
            } else {
                System.out.println (book.caption+" # CD");
            }
        }
    }

}