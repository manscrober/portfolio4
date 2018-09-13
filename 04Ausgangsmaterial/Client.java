import java.util.ArrayList;

public class Client {

	public ArrayList<Book> borrowedBooks = new ArrayList();

	public String name;
	public String address;
	public ArrayList<String> favoriteCategories = new ArrayList();

	public Client (String name, String address) {
		this.name = name;
		this.address = address;
	}

	public void addToLibrary (Library library) {
		library.clients.add (this);
	}

	public void returnBook (String title) {
		Book bookToReturn = null;
		for (Book book : borrowedBooks) {
			if (book.caption.equals (title)) {
				bookToReturn = book;
				break;
			}
		}
		borrowedBooks.remove (bookToReturn);
	}
	
	public boolean isFavoriteCategory (String category) {
	    return favoriteCategories.contains (category);
	}

}