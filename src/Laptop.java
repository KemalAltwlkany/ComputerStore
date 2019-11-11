public class Laptop extends PC{

    public Laptop(){
        super();
    }

    //constructor hardcoded to type Laptop
    public Laptop(String manufacturer, int ram, double storage, double cpu_speed, double gpu_speed, String cpu_name,
                  String gpu_name, String colour, double baseRentPrice, double basePurchasePrice){
        super(manufacturer, ram, storage, cpu_speed, gpu_speed, cpu_name, gpu_name, colour,
                "Laptop", baseRentPrice, basePurchasePrice);
    }

    //copy constructor
    public Laptop(Laptop other) {
        super(other);
    }

}
