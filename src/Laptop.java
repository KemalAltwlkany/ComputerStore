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

}

//CHANGE ALL FIELDS "NAME" INTO CONSTANT