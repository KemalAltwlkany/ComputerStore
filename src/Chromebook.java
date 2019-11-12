public class Chromebook extends PC{

    public Chromebook(){
        super();
    }

    //constructor hardcoded to type Chromebook
    public Chromebook(String model, String manufacturer, int ram, double storage, double cpu_speed, double gpu_speed, String cpu_name,
                      String gpu_name, String colour, double baseRentPrice, double basePurchasePrice){
        super(model, manufacturer, ram, storage, cpu_speed, gpu_speed, cpu_name, gpu_name, colour, baseRentPrice, basePurchasePrice);
    }

    public Chromebook(Chromebook other) {
        super(other);
    }

    @Override
    public String toString() {
        return "Chromebook{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", baseRentPrice=" + baseRentPrice +
                ", basePurchasePrice=" + basePurchasePrice +
                ", available=" + available +
                '}';
    }

    @Override
    public String verboseToString(){
        return "Chromebook{" + super.verboseToString();
    }
}
