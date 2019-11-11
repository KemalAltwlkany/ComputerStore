public class DesktopPC extends PC{

    public DesktopPC(){
        super();
    }

    //constructor hardcoded to type DesktopPC
    public DesktopPC(String manufacturer, int ram, double storage, double cpu_speed, double gpu_speed, String cpu_name,
                     String gpu_name, String colour, double baseRentPrice, double basePurchasePrice){
        super(manufacturer, ram, storage, cpu_speed, gpu_speed, cpu_name, gpu_name, colour,
                "DesktopPC", baseRentPrice, basePurchasePrice);
    }

    public DesktopPC(DesktopPC other) {
        super(other);
    }

}
