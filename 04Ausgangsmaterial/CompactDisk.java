public class CompactDisk extends Item {
    public CompactDisk (String title){
        super(title);
    }
    public String getDetails(){
        return super.getDetails() + " # CD";
    }
}
