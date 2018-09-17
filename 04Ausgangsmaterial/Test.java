import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Test {
    public static void main(String[] args) {

    }
    public static final String EXAMPLE_CATEGORY = "fantasy";
    public static final String DEFAULT_CATEGORY = "Roman";
    public static final String EXAMPLE_PAGE= "page1";
    public static final String EXAMPLE_AUTHOR = "Stephen King";
    public static final String EXAMPLE_TITLE = "testBook";
    public static final String EXAMPLE_NAME = "peter";
    public static final String EXAMPLE_ADDRESS = "baustrasse 8";
    private Client client;
    private Library library;
    private Book testBook;
    @Before
    public void setUp(){
        client = new Client(EXAMPLE_NAME,EXAMPLE_ADDRESS);
        library = new Library();
        testBook = new Book(EXAMPLE_TITLE);
        library.clients.add(client);
    }

    //client
    @org.junit.Test
    public void addToLibrary() {
        setUp();
        library.clients.clear();
        client.addToLibrary(library);
        ArrayList<Client> correct = new ArrayList();
        correct.add(client);
        assertEquals(correct,library.clients);
        assertEquals(client.name,library.clients.get(0).name);

        client.addToLibrary(library);
        assertNotEquals(correct,library.clients);

    }

    @org.junit.Test
    public void returnBook() {
        setUp();
        client.borrowedBooks.clear();

        client.borrowedBooks.add(testBook);
        client.returnBook(EXAMPLE_TITLE);
        assertTrue(client.borrowedBooks.isEmpty());

        client.returnBook("nonExistingBook");

        client.borrowedBooks.add(testBook);
        client.returnBook("nonExistingBook");
        assertEquals(testBook,client.borrowedBooks.get(0));
    }

    @org.junit.Test
    public void isFavoriteCategory() {
        setUp();
        client.favoriteCategories.clear();
        client.favoriteCategories.add(EXAMPLE_CATEGORY);
        assertTrue(client.isFavoriteCategory(EXAMPLE_CATEGORY));
        assertFalse(client.isFavoriteCategory(EXAMPLE_CATEGORY+"invalidating category name extension"));
        assertFalse(client.isFavoriteCategory(null));
        client.favoriteCategories.clear();
        assertFalse(client.isFavoriteCategory(EXAMPLE_CATEGORY));
        client.favoriteCategories.add(null);
        assertTrue(client.isFavoriteCategory(null));
    }


    //book
    @org.junit.Test
    public void setCompactDisc(){
        setUp();
        testBook.setCompactDisc(true);
        assertTrue(testBook.isCompactDisc());
        testBook.setCompactDisc(false);
        assertFalse(testBook.isCompactDisc());
    }

    @org.junit.Test
    public void deleteBook(){
        setUp();
        library.books.clear();
        library.books.add(testBook);
        testBook.deleteBook(library);
        assertFalse(library.books.contains(testBook));

        testBook.deleteBook(library);
        library.books.add(testBook);
        client.borrowedBooks.add(testBook);
        testBook.deleteBook(library);

        assertFalse(client.borrowedBooks.contains(testBook));
    }
    @org.junit.Test
    public void addAndBorrowBook(){
        setUp();
        library.books.clear();
        client.borrowedBooks.clear();
        testBook.addAndBorrowBook(library,client);
        assertTrue(library.books.contains(testBook));
        assertTrue(client.borrowedBooks.contains(testBook));

        library.books.clear();
        client.borrowedBooks.clear();
        testBook.setCompactDisc(true);
        testBook.addAndBorrowCD(library,client);
        assertTrue(library.books.contains(testBook));
        assertTrue(client.borrowedBooks.contains(testBook));

        library.books.clear();
        client.borrowedBooks.clear();
        testBook.setCompactDisc(false);
        testBook.addAndBorrowCD(library,client);
        assertFalse(library.books.contains(testBook));
        assertFalse(client.borrowedBooks.contains(testBook));
    }

    @org.junit.Test
    public void hasCategory(){
        setUp();
        assertFalse(testBook.hasCategory(EXAMPLE_CATEGORY));
        assertTrue(testBook.hasCategory(DEFAULT_CATEGORY));
        testBook.category=EXAMPLE_CATEGORY;
        assertTrue(testBook.hasCategory(EXAMPLE_CATEGORY));

    }

    @org.junit.Test
    public void addPage(){
        setUp();
        testBook.addPage(EXAMPLE_PAGE);
        assertTrue(testBook.pageContent.contains(EXAMPLE_PAGE));
        assertTrue(testBook.contains(EXAMPLE_PAGE));
        testBook.pageContent.clear();
        assertFalse(testBook.contains(EXAMPLE_PAGE));
    }

    //library
    @org.junit.Test
    public void addBook(){
        setUp();
        library.books.clear();
        library.addBook(testBook);
        assertTrue(library.books.contains(testBook));
    }
    @org.junit.Test
    public void printListOfBooks(){
        setUp();
        library.printListOfBooks();
        library.addBook(testBook);
        library.printListOfBooks();
        testBook.setCompactDisc(true);
        library.printListOfBooks();
    }
    @org.junit.Test
    public void testAuthor(){
        testBook.setAuthor(EXAMPLE_AUTHOR);
        assertEquals(EXAMPLE_AUTHOR,testBook.getAuthor());
        library.addBook(testBook);
        library.printListOfBooks();
    }
    @org.junit.Test
    public void bookBorrowedBy(){
        setUp();
        assertFalse(library.bookBorrowedBy(testBook.caption).contains(client.name));
        testBook.addAndBorrowBook(library,client);
        assertTrue(library.bookBorrowedBy(testBook.caption).contains(client.name));

    }
}