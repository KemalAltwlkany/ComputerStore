public abstract class Item {
    private String name;
    private String description;
    private int baseRentPrice; //per day by definition
    private int basePurchasePrice;
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

    public Item(String name, int baseRentPrice, int basePurchasePrice){
        this.name = name;
        this.baseRentPrice = baseRentPrice;
        this.basePurchasePrice = basePurchasePrice;
        this.description = null;
    }


}
