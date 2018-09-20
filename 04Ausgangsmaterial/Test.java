import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Test {
    public static void main(String[] args) {

    }
    public static final String EXAMPLE_CATEGORY = "fantasy";
    public static final String EXAMPLE_PAGE= "page1";
    public static final String EXAMPLE_AUTHOR = "Stephen King";
    public static final String EXAMPLE_TITLE = "testBook";
    public static final String EXAMPLE_NAME = "peter";
    public static final String EXAMPLE_KEYWORD = "testKeyword";
    public static final String EXAMPLE_ADDRESS = "baustrasse 8";
    private Client client;
    private Library library;
    private Book testBook;
    private CompactDisk testCD;
    @Before
    public void setUp(){
        client = new Client(EXAMPLE_NAME,EXAMPLE_ADDRESS);
        library = new Library();
        testBook = new Book(EXAMPLE_TITLE);
        testCD = new CompactDisk(EXAMPLE_TITLE);
        
    }

    @org.junit.Test
    public void addToLibrary() {
        
        ArrayList<Client> correct = new ArrayList<>();
        library.addClient(client);
        correct.add(client);
        assertEquals(correct,library.getClients());
        assertEquals(client.getName(),library.getClients().get(0).getName());

        library.addClient(client);
        assertEquals(correct,library.getClients());

    }

    @org.junit.Test
    public void returnBook() {
        library.addItem(testBook);
        client.borrowItemFromLibrary(testBook.getTitle(),library);
        assertTrue(client.hasBorrowedItem(testBook));
        client.returnItem(testBook);
        assertFalse(client.hasBorrowedItem(testBook));

        client.returnItem(testBook);

        assertFalse(client.hasBorrowedItem(testBook));
        assertTrue(library.itemBorrowedBy(testBook).isEmpty());

        client.borrowItemFromLibrary(testBook.getTitle(),library);
        client.returnItem(null);
        assertTrue(client.hasBorrowedItem(testBook));
    }

    @org.junit.Test
    public void isFavoriteCategory() {
        assertFalse(client.isFavoriteCategory(EXAMPLE_CATEGORY));
        client.addFavouriteCategory(EXAMPLE_CATEGORY);
        assertTrue(client.isFavoriteCategory(EXAMPLE_CATEGORY));
        assertFalse(client.isFavoriteCategory(EXAMPLE_CATEGORY+"anyNonEmptyString"));
        assertFalse(client.isFavoriteCategory(null));
        

        client.addFavouriteCategory(null);
        assertTrue(client.isFavoriteCategory(null));
    }

//book

    @org.junit.Test
    public void deleteBook(){
        
        library.addItem(testBook);
        library.removeItem(testBook);
        assertFalse(library.hasItem(testBook));

        library.removeItem(testBook);
        library.addItem(testBook);
        client.borrowItemFromLibrary(testBook.getTitle(),library);
        library.removeItem(testBook);

        assertFalse(client.hasBorrowedItem(testBook));
    }
    @org.junit.Test
    public void addAndBorrowBook(){
        library.addItem(testBook);
        client.borrowItemFromLibrary(testBook.getTitle(),library);
        assertTrue(library.hasItem(testBook));
        assertTrue(client.hasBorrowedItem(testBook));
    }

    @org.junit.Test
    public void addAndBorrowCD(){
        library.addItem(testCD);
        client.borrowItemFromLibrary(testCD.getTitle(),library);
        assertTrue(library.hasItem(testCD));
        assertTrue(client.hasBorrowedItem(testCD));
    }
    @org.junit.Test
    public void testCategory(){
        assertNotEquals(testBook.getCategory(), EXAMPLE_CATEGORY);
        assertEquals(testBook.getCategory(), Item.DEFAULT_CATEGORY);
        testBook.setCategory(EXAMPLE_CATEGORY);
        assertEquals(testBook.getCategory(), EXAMPLE_CATEGORY);
    }

    @org.junit.Test
    public void addPage(){
        assertFalse(testBook.contains(EXAMPLE_PAGE));
        testBook.addPage(EXAMPLE_PAGE);
        assertTrue(testBook.contains(EXAMPLE_PAGE));
        assertTrue(testBook.contains(EXAMPLE_PAGE));
    }

    //library
    @org.junit.Test
    public void printListOfItems(){
        

        library.addItem(testBook);
        library.printListOfItems();
        testBook.addKeyword(EXAMPLE_KEYWORD);
        library.printListOfItems();
        testCD.setAuthor(EXAMPLE_AUTHOR);
        testCD.addKeyword(EXAMPLE_KEYWORD);
        testCD.addKeyword(EXAMPLE_KEYWORD + "2");
        library.addItem(testCD);
        library.printListOfItems();
    }
    @org.junit.Test
    public void testAuthor(){
        testBook.setAuthor(EXAMPLE_AUTHOR);
        assertEquals(EXAMPLE_AUTHOR,testBook.getAuthor());
    }
    @org.junit.Test
    public void bookBorrowedBy(){
        assertFalse(library.itemBorrowedBy(testBook).contains(client.getName()));
        library.addItem(testBook);
        client.borrowItemFromLibrary(testBook.getTitle(),library);
        assertTrue(library.itemBorrowedBy(testBook).contains(client.getName()));
    }
}