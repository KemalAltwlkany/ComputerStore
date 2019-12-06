import java.util.ArrayList;
import java.util.Comparator;

public abstract class PC extends  Item{
    protected String model; //max 15 characters
    protected String manufacturer; //max 30 characters
    protected int ram; //in GB
    protected double storage; //in TB
    protected double cpu_speed; //clock speed, in GHz
    protected double gpu_speed; //in GB
    protected String cpu_name; //max 30 characters
    protected String gpu_name; //max 30 characters
    protected String colour;  //max 30 characters

    public PC(){
        super();
        model = "Aspire E-15";
        manufacturer = "Acer";
        ram = 8;
        storage = 1.128;
        cpu_speed = 2.5;
        gpu_speed = 1.1;
        cpu_name = "Intel Core i5-7200U";
        gpu_name = "NVIDIA GeForce 940MX";
        colour = "Aluminum black";
    }

    public PC(String model, String manufacturer, int ram, double storage, double cpu_speed, double gpu_speed,
              String cpu_name, String gpu_name, String colour,
              double baseRentPrice, double basePurchasePrice){
        super(baseRentPrice, basePurchasePrice);
        this.setModel(model);
        this.setManufacturer(manufacturer);
        this.setRam(ram);
        this.setStorage(storage);
        this.setCpu_speed(cpu_speed);
        this.setGpu_speed(gpu_speed);
        this.setCpu_name(cpu_name);
        this.setGpu_name(gpu_name);
        this.setColour(colour);
    }

    //copy constructor
    public PC(PC other) {
        super(other);
        this.model = other.model;
        this.manufacturer = other.manufacturer;
        this.ram = other.ram;
        this.storage = other.storage;
        this.cpu_speed = other.cpu_speed;
        this.gpu_speed = other.gpu_speed;
        this.cpu_name = other.cpu_name;
        this.gpu_name = other.gpu_name;
        this.colour = other.colour;
    }

    public String getModel(){
        return this.model;
    }

    public void setModel(String model){
        if (model.length() > 15){
            return;
        }
        this.model = model;
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

    @Override
    public abstract String toString();

    public String verboseToString(){
            return  "model='" + model + '\'' +
                    ", manufacturer='" + manufacturer + '\'' +
                    ", ram=" + ram +
                    ", storage=" + storage +
                    ", cpu_speed=" + cpu_speed +
                    ", gpu_speed=" + gpu_speed +
                    ", cpu_name='" + cpu_name + '\'' +
                    ", gpu_name='" + gpu_name + '\'' +
                    ", colour='" + colour + '\'' +
                    ", description='" + description + '\'' +
                    ", baseRentPrice=" + baseRentPrice +
                    ", basePurchasePrice=" + basePurchasePrice +
                    ", available=" + available +
                    '}';
    }

    @Override
    public abstract boolean equals(Object obj);

    //Update 05.12.2019.
    public abstract double computeBenchmark();

    public static Comparator<PC> PCComparator = new Comparator<PC>() {
        @Override
        public int compare(PC pc1, PC pc2) {
            if (pc1.computeBenchmark() - pc2.computeBenchmark() < 0 ) return -1;
            if (pc1.computeBenchmark() - pc2.computeBenchmark() > 0 ) return 1;
            return 0;
        }
    };


}


