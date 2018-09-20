import java.util.ArrayList;
import java.util.Arrays;

public class Library {

    private ArrayList<Item> items;

    private ArrayList<Client> clients;

    public Library(){
        items= new ArrayList<>();
        clients = new ArrayList<>();
    }

    public void addItem (Item item) {

        if(!items.contains(item)) {
            items.add(item);
        }
    }

    public void removeItem(Item item){
        clients.forEach(c->c.returnItem(item));
        items.remove(item);
    }

    public Item lendItem(String title,Client client){
        addClient(client);
        for(Item item:items){
            if(item.getTitle().equals(title)&&!isLended(item)){
                return item;
            }
        }
        return null;
    }
    private boolean isLended(Item item){
        boolean found = false;
        for(Client client:clients){
            if(client.hasBorrowedItem(item)){
                return found=true;
            }
        }
        return found;
    }
    public boolean hasItem(String title){
        boolean found=false;
        for(Item item : items){
            if (item.getTitle().equals(title)) {
                found=true;
            }
        }
        return found;
    }
    public void addClient(Client client){
        if(!clients.contains(client)) {
            clients.add(client);
        }
    }
    public ArrayList<Client> getClients(){
        return clients;
    }

    public void printListOfItems () {
        for (Item item : items) {
            System.out.println(item.getDetails());
        }
    }
    public ArrayList<String> itemBorrowedBy(String title){
        ArrayList<Item> itemsFound = new ArrayList<>();
        items.stream().filter(i->i.getTitle().equals(title)).forEach(i->itemsFound.add(i));

        ArrayList<String> borrowers = new ArrayList<>();
        for(Item item:items) {
            clients.stream().filter(c -> c.hasBorrowedItem(item))
                    .forEach(c -> borrowers.add(c.getName()));
        }
        return borrowers;
    }

}