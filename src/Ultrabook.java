public class Ultrabook extends PC{

    public Ultrabook(){
        super();
    }

    //constructor hardcoded to type Ultrabook
    public Ultrabook(String manufacturer, int ram, double storage, double cpu_speed, double gpu_speed, String cpu_name,
                     String gpu_name, String colour, double baseRentPrice, double basePurchasePrice){
        super(manufacturer, ram, storage, cpu_speed, gpu_speed, cpu_name, gpu_name, colour,
                "Ultrabook",  baseRentPrice, basePurchasePrice);
    }

    public Ultrabook(Ultrabook other) {
        super(other);
    }
}
