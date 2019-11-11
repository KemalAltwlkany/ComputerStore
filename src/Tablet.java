public class Tablet extends PC{

    public Tablet(){
        super();
    }

    //constructor hardcoded to type Tablet
    public Tablet(String manufacturer, int ram, double storage, double cpu_speed, double gpu_speed, String cpu_name,
                  String gpu_name, String colour, double baseRentPrice, double basePurchasePrice){
        super(manufacturer, ram, storage, cpu_speed, gpu_speed, cpu_name, gpu_name, colour,
                "Tablet", baseRentPrice, basePurchasePrice);
    }

    public Tablet(Tablet other) {
        super(other);
    }
}
