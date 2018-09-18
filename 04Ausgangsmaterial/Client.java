import java.util.ArrayList;

public class Client {

	private ArrayList<Item> borrowedItems;

	private String name;
	private String address;
	private ArrayList<String> favoriteCategories;

	public Client (String name, String address) {
	    borrowedItems = new ArrayList<>();
	    favoriteCategories= new ArrayList<>();
		this.name = name;
		this.address = address;
	}

	public String getName(){return name;}

	public void borrowItem(Item item) {
        if (item != null) {
            borrowedItems.add(item);
        }
    }

	public void returnItem (Item item) {
		borrowedItems.remove (item);
	}

	public boolean hasBorrowedItem(Item item){
        return borrowedItems.contains(item);
    }

    public void addFavouriteCategory(String category){
	    favoriteCategories.add(category);
    }
    public boolean isFavoriteCategory (String category) {
	    return favoriteCategories.contains (category);
	}

}