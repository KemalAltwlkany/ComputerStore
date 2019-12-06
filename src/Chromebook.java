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


    //Update 02.12.2019.
    //Two PC's are the same if they have the same model name, for simplicity reasons
    @Override
    public boolean equals(Object obj) {
        //Are the references pointing to the same address in memory?
        if (obj == this) {
            return true;
        }

        //If obj isn't an instance of class Chromebook then it is obviously not a book
        if (!(obj instanceof Chromebook)) {
            return false;
        }

        //obj is certainly an instance of class Chromebook and can be casted to Book
        Chromebook b2 = (Chromebook) obj;
        if ( this.getModel().equals(b2.getModel()) ){
            return true;
        }
        return false;
    }

    //Update 05.12.2019.
    @Override
    public double computeBenchmark() {
        return gpu_speed*2 + cpu_speed*2 + ram/8 + storage/128;
    }

}


