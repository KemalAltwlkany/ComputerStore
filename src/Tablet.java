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

    //Update 02.12.2019.
    //Two PC's are the same if they have the same model name, for simplicity reasons
    @Override
    public boolean equals(Object obj) {
        //Are the references pointing to the same address in memory?
        if (obj == this) {
            return true;
        }

        //If obj isn't an instance of class Tablet then it is obviously not a book
        if (!(obj instanceof Tablet)) {
            return false;
        }

        //obj is certainly an instance of class Book and can be casted to Book
        Tablet b2 = (Tablet) obj;
        if ( this.getModel().equals(b2.getModel()) ){
            return true;
        }
        return false;
    }

    //Update 05.12.2019.
    @Override
    public double computeBenchmark() {
        return gpu_speed*0.5 + cpu_speed + ram/24 + storage/1024;
    }

}
