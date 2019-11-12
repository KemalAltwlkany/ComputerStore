public class Laptop extends PC{

    public Laptop(){
        super();
        setName("Laptop");
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

    @Override
    public void setName(String name){
        //Class should not be able to change its name attribute.
        this.name = "Laptop";
    }

}

//CHANGE ALL FIELDS "NAME" INTO CONSTANT