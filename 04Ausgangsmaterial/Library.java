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
        if(!clients.contains(client)){
            clients.add(client);
        }
        for(Item item:items){
            if(item.getTitle().equals(title)&&itemBorrowedBy(item).isEmpty()){
                return item;
            }
        }
        return null;
    }
    public boolean hasItem(Item item){
        return items.contains(item);
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
    public ArrayList<String> itemBorrowedBy(Item item){
        ArrayList<String> borrowers=new ArrayList<>();
        clients.stream().filter(c->c.hasBorrowedItem(item))
                        .forEach(c->borrowers.add(c.getName()));
        return borrowers;
    }

}