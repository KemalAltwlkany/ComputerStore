public class Tablet extends PC{

    public Tablet(){
        super();
    }

    //constructor hardcoded to type Tablet
    public Tablet(String model, String manufacturer, int ram, double storage, double cpu_speed, double gpu_speed, String cpu_name,
                  String gpu_name, String colour, double baseRentPrice, double basePurchasePrice){
        super(model, manufacturer, ram, storage, cpu_speed, gpu_speed, cpu_name, gpu_name, colour, baseRentPrice, basePurchasePrice);
    }

    public Tablet(Tablet other) {
        super(other);
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", baseRentPrice=" + baseRentPrice +
                ", basePurchasePrice=" + basePurchasePrice +
                ", available=" + available +
                '}';
    }

    @Override
    public String verboseToString(){
        return "Tablet{" + super.verboseToString();
    }

}
