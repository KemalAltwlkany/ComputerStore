public abstract class Item implements  IItem{
    protected String name;
    protected String description;
    protected double baseRentPrice; //per day by definition
    protected double basePurchasePrice;
    protected boolean available;

    //Maximum item allowed item name is 25 characters. Maximum description is 200 characters.
    //purchase and rent price are only lower bound limited, i.e. cannot be a negative value

    public Item(){
        name = "Fake_item";
        description = null;
        baseRentPrice = 0;
        basePurchasePrice = 0;
        available = true;
    }

    public Item(String name){
        this.setName(name);
        description = null;
        baseRentPrice = 0;
        basePurchasePrice = 0;
        available = true;
    }

    public Item(String name, double baseRentPrice, double basePurchasePrice){
        this.setName(name);
        this.setBaseRentPrice(baseRentPrice);
        this.setBasePurchasePrice(basePurchasePrice);
        this.description = null;
        available = true;
    }

    public Item(String name, String description, double baseRentPrice, double basePurchasePrice){
        this.setName(name);
        this.setDescription(description);
        this.setBaseRentPrice(baseRentPrice);
        this.setBasePurchasePrice(basePurchasePrice);
        available = true;
    }

    //copy constructor
    public Item(Item other) {
        this.name = other.name;
        this.description = other.description;
        this.baseRentPrice = other.baseRentPrice;
        this.basePurchasePrice = other.basePurchasePrice;
        this.available = other.available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //name field up to maximum of 25 characters
        if (name.length() > 25){
            return;
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        //description length maximum of 200 characters
        if ( description.length() > 200 ){
            return;
        }
        this.description = description;
    }

    public double getBaseRentPrice() {
        return baseRentPrice;
    }

    public void setBaseRentPrice(double baseRentPrice) {
        //rent price cannot be negative
        if (baseRentPrice < 0){
            return;
        }
        this.baseRentPrice = baseRentPrice;
    }

    public double getBasePurchasePrice() {
        return basePurchasePrice;
    }

    public void setBasePurchasePrice(double basePurchasePrice) {
        //purchase price cannot be negative
        if ( basePurchasePrice < 0){
            return;
        }
        this.basePurchasePrice = basePurchasePrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", baseRentPrice=" + baseRentPrice +
                ", basePurchasePrice=" + basePurchasePrice +
                ", available=" + available +
                '}';
    }

}
