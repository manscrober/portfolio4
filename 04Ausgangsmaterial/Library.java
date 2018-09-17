import java.util.ArrayList;
import java.util.Arrays;

public class Library {

    public ArrayList<Book> books = new ArrayList();

    public ArrayList<Client> clients = new ArrayList();

    public void addBook (Book book) {
        books.add (book);
    }

    public void printListOfBooks () {
        for (Book book : books) {
            if (!book.isCompactDisc()) {
                System.out.println (book.caption+ " # "+ book.getAuthor() + " # "+book.category);
            } else {
                System.out.println (book.caption+" # "+ book.getAuthor() +" # CD");
            }
        }
    }
    public ArrayList<String> bookBorrowedBy(String bookTitle){
        ArrayList<String> borrowers=new ArrayList();
        clients.stream().filter(c->c.borrowedBooks.stream().anyMatch(b->b.caption.equals(bookTitle)))
                        .forEach(c->borrowers.add(c.name));
        return borrowers;
    }

}