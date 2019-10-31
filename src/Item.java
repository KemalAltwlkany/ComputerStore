public abstract class Item implements  IItem{
    protected String name;
    protected String description;
    protected double baseRentPrice; //per day by definition
    protected double basePurchasePrice;
    //FEATURE - add field: Boolean available, to identify whether the item is rented or not
    //FEATURE - static counter which identifies each item, uniquely
    //FEATURE - add static list of valid names. Those should be PC, Book and Equipment.

    public Item(){
        name = "Fake_item";
        description = null;
        baseRentPrice = 0;
        basePurchasePrice = 0;
    }

    public Item(String name){
        this.name = name;
        description = null;
        baseRentPrice = 0;
        basePurchasePrice = 0;
    }

    public Item(String name, double baseRentPrice, double basePurchasePrice){
        this.name = name;
        this.baseRentPrice = baseRentPrice;
        this.basePurchasePrice = basePurchasePrice;
        this.description = null;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", baseRentPrice=" + baseRentPrice +
                ", basePurchasePrice=" + basePurchasePrice +
                '}';
    }
}
