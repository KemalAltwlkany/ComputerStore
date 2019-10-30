public abstract class Item implements  IItem{
    private String name;
    private String description;
    private double baseRentPrice; //per day by definition
    private double basePurchasePrice;
    //FEATURE - add field: Boolean available, to identify whether the item is rented or not
    //FEATURE - static counter which identifies each item, uniquely

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


}
