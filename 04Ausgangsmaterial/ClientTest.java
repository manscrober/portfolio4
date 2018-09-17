import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
    private Client client;
    private Library library;
    @Before
    public void setUp(){
        client = new Client("peter","baumstrasse 8");
        library = new Library();
    }
    @Test
    public void addToLibrary() {
        client.addToLibrary(library);
        assertArrayEquals(new Client[]{client},library.clients)
    }

    @Test
    public void returnBook() {

    }

    @Test
    public void isFavoriteCategory() {
    }
}