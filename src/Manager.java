import java.time.LocalDate;
import java.util.ArrayList;

public class Manager extends Employee {
    private ArrayList<Employee> subordinates = new ArrayList<>();

    public Manager() {
        super();
    }

    public Manager(Manager other) {
        super(other);
        this.subordinates = other.subordinates;
    }

    public Manager(String name, String surname){
        super(name, surname);
    }

    public Manager(String name, String surname, Document doc, LocalDate birthDate, LocalDate joiningDate, double salary,
                   String healthCareNumber) {
        super(name, surname, doc, birthDate, joiningDate, salary, healthCareNumber);
    }

    public void addSubordinate(Employee emp){
        this.subordinates.add(emp);
    }

    public void removeSubordinate(Employee emp){
        this.subordinates.remove(emp);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", subordinates=" + subordinates +
                "} ";
    }

    @Override
    public String verboseToString() {
        return "Manager{" +
                "subordinates=" + subordinates + ", " +
                super.verboseToString();
    }

    //Method isn't supposed to do anything.
    @Override
    public void setSupervisor(Manager manager) {
    }
}
