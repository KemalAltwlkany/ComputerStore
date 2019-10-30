public abstract class PC extends  Item{
    private String manufacturer;
    private int ram; //in GB
    private double storage; //in GB
    private double cpu_speed; //clock speed, in GHz
    private double gpu_speed; //in GB
    private String cpu_name;
    private String gpu_name;
    private String colour;
    private String type;
    //Can be extended into separated classes in order to demonstrate polymorphism and inheritance better
    protected static String[] types = {"DesktopPC", "Laptop", "Chromebook", "Notebook", "Ultrabook", "Tablet"};

    public PC(){
        super();
        manufacturer = "Acer";
        ram = 8;
        storage = 1024;
        cpu_speed = 2.5;
        cpu_name = "Intel Core i5-7200U";
        colour = "Aluminum black";
        type = "Laptop";
    }

    //FEATURE - check whether the input data is valid.
    public PC(String manufacturer, int ram, double storage, double cpu_speed, double gpu_speed,
              String cpu_name, String gpu_name, String colour, String type, String name,
              double baseRentPrice, double basePurchasePrice){
        super(name, baseRentPrice, basePurchasePrice);
        this.manufacturer = manufacturer;
        this.ram = ram;
        this.storage = storage;
        this.cpu_speed = cpu_speed;
        this.gpu_speed = gpu_speed;
        this.cpu_name = cpu_name;
        this.gpu_name = gpu_name;
        this.colour = colour;
        this.type = type;
    }

    //Checks whether String passed as argument is a valid PC type. Returns true if it is.
    protected static boolean validateType(String type){
        for(String x : PC.types){
            if (x.equals(type)){
                return true;
            }
        }
        return false;
    }
}
