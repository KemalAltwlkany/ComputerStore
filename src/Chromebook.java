public class Chromebook extends PC{

    public Chromebook(){
        super();
    }

    public Chromebook(String manufacturer, int ram, double storage, double cpu_speed, double gpu_speed,
                  String cpu_name, String gpu_name, String colour, String type, String name,
                  double baseRentPrice, double basePurchasePrice){
        super(manufacturer, ram, storage, cpu_speed, gpu_speed, cpu_name, gpu_name, colour,
                type, name, baseRentPrice, basePurchasePrice);
    }

}
