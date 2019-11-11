import java.time.LocalDate;
import java.util.ArrayList;

public class Manager extends Employee {
    ArrayList<Employee> subordinates = new ArrayList<>();

    public Manager() {
        super();
        this.setPosition("Manager");
    }

    public Manager(Manager other) {
        super(other);
        this.subordinates = other.subordinates;
    }

    public Manager(String name, String surname, Document doc, LocalDate birthDate, LocalDate joiningDate, double salary,
                   String healthCareNumber) {
        super(name, surname, doc, birthDate, joiningDate, salary, "Manager", healthCareNumber);
    }

    public void addSubordinate(Employee emp){
        this.subordinates.add(emp);
    }

    public void removeSubordinate(Employee emp){
        this.subordinates.remove(emp);
    }

}
