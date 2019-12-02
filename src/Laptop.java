public class Laptop extends PC{

    public Laptop(){
        super();
    }

    //constructor hardcoded to type Laptop
    public Laptop(String model, String manufacturer, int ram, double storage, double cpu_speed, double gpu_speed,
                  String cpu_name, String gpu_name, String colour, double baseRentPrice, double basePurchasePrice){
        super(model, manufacturer, ram, storage, cpu_speed, gpu_speed, cpu_name, gpu_name, colour, baseRentPrice, basePurchasePrice);
    }

    //copy constructor
    public Laptop(Laptop other) {
        super(other);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", baseRentPrice=" + baseRentPrice +
                ", basePurchasePrice=" + basePurchasePrice +
                ", available=" + available +
                '}';
    }

    @Override
    public String verboseToString(){
        return "Laptop{" + super.verboseToString();
    }

    //Update 02.12.2019.
    //Two PC's are the same if they have the same model name, for simplicity reasons
    @Override
    public boolean equals(Object obj) {
        //Are the references pointing to the same address in memory?
        if (obj == this) {
            return true;
        }

        //If obj isn't an instance of class Laptop then it is obviously not a book
        if (!(obj instanceof Laptop)) {
            return false;
        }

        //obj is certainly an instance of class Laptop and can be casted to Book
        Laptop b2 = (Laptop) obj;
        if ( this.getModel().equals(b2.getModel()) ){
            return true;
        }
        return false;
    }

}

//CHANGE ALL FIELDS "NAME" INTO CONSTANT