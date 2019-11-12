public abstract class PC extends  Item{
    private String manufacturer; //max 30 characters
    private int ram; //in GB
    private double storage; //in TB
    private double cpu_speed; //clock speed, in GHz
    private double gpu_speed; //in GB
    private String cpu_name; //max 30 characters
    private String gpu_name; //max 30 characters
    private String colour;  //max 30 characters
    private String type;    //restricted to predefined types
    //Can be extended into separated classes in order to demonstrate polymorphism and inheritance better
    protected static String[] types = {"DesktopPC", "Laptop", "Chromebook", "Notebook", "Ultrabook", "Tablet"};

    //FIELD TYPE WILL PROBABLY BE REMOVED AND ITS FUNCTIONALITY REPLACED BY FIELD NAME FROM DERIVED CLASSES
    //SINCE THIS IS ABSTRACT

    public PC(){
        super("PC");
        manufacturer = "Acer";
        ram = 8;
        storage = 1024;
        cpu_speed = 2.5;
        cpu_name = "Intel Core i5-7200U";
        colour = "Aluminum black";
        type = "Laptop";
    }

    //hardcoded Item.name to "PC"
    public PC(String manufacturer, int ram, double storage, double cpu_speed, double gpu_speed,
              String cpu_name, String gpu_name, String colour, String type,
              double baseRentPrice, double basePurchasePrice){
        super("PC", baseRentPrice, basePurchasePrice);
        this.setManufacturer(manufacturer);
        this.setRam(ram);
        this.setStorage(storage);
        this.setCpu_speed(cpu_speed);
        this.setGpu_speed(gpu_speed);
        this.setCpu_name(cpu_name);
        this.setGpu_name(gpu_name);
        this.setColour(colour);
        this.setType(type);
    }

    //copy constructor
    public PC(PC other) {
        super(other);
        this.manufacturer = other.manufacturer;
        this.ram = other.ram;
        this.storage = other.storage;
        this.cpu_speed = other.cpu_speed;
        this.gpu_speed = other.gpu_speed;
        this.cpu_name = other.cpu_name;
        this.gpu_name = other.gpu_name;
        this.colour = other.colour;
        this.type = other.type;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        //max 30 characters length for manufacturer
        if (manufacturer.length() > 30){
            return;
        }
        this.manufacturer = manufacturer;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        //ram cannot be negative nor above 128gb
        if ( (ram < 0) || (ram > 128) ){
            return;
        }
        this.ram = ram;
    }

    public double getStorage() {
        return storage;
    }

    public void setStorage(double storage) {
        //storage cannot be negative
        if ( storage < 0 ){
            return;
        }
        this.storage = storage;
    }

    public double getCpu_speed() {
        return cpu_speed;
    }

    public void setCpu_speed(double cpu_speed) {
        //cpu_speed cannot be negative nor above 10GHz
        if ( (cpu_speed < 0) || (cpu_speed > 10.0) ){
            return;
        }
        this.cpu_speed = cpu_speed;
    }

    public double getGpu_speed() {
        return gpu_speed;
    }

    public void setGpu_speed(double gpu_speed) {
        //gpu speed cannot be negative nor above 10GHz
        if ((gpu_speed < 0) || (gpu_speed > 10)){
            return;
        }
        this.gpu_speed = gpu_speed;
    }

    public String getCpu_name() {
        return cpu_name;
    }

    public void setCpu_name(String cpu_name) {
        //max length for cpu name is 30 characters
        if (cpu_name.length() > 30){
            return;
        }
        this.cpu_name = cpu_name;
    }

    public String getGpu_name() {
        return gpu_name;
    }

    public void setGpu_name(String gpu_name) {
        //gpu name cannot be longer than 30 characters
        if (gpu_name.length() > 30){
            return;
        }
        this.gpu_name = gpu_name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        //colour length cannot be longer than 30 chars
        if (colour.length() > 30){
            return;
        }
        this.colour = colour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        //PC type restricted to predefined values contain in class array
        if ( PC.validateType(type)){
            this.type = type;
        }
        return;
    }

    public static String[] getTypes() {
        return types;
    }

    @Override
    public String toString() {
        return "PC{" +
                "manufacturer='" + manufacturer + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", cpu_speed=" + cpu_speed +
                ", gpu_speed=" + gpu_speed +
                ", cpu_name='" + cpu_name + '\'' +
                ", gpu_name='" + gpu_name + '\'' +
                ", colour='" + colour + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", baseRentPrice=" + baseRentPrice +
                ", basePurchasePrice=" + basePurchasePrice +
                ", available=" + available +
                '}';
    }

    @Override
    public abstract void setName(String name);
    //We require the method to be overriden by every of its child classes.
}
