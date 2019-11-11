public class Notebook extends PC{

    public Notebook(){
        super();
    }

    //constructor hardcoded to type Notebook
    public Notebook(String manufacturer, int ram, double storage, double cpu_speed, double gpu_speed, String cpu_name,
                    String gpu_name, String colour, double baseRentPrice, double basePurchasePrice){
        super(manufacturer, ram, storage, cpu_speed, gpu_speed, cpu_name, gpu_name, colour,
                "Notebook", baseRentPrice, basePurchasePrice);
    }

    public Notebook(Notebook other) {
        super(other);
    }
}
