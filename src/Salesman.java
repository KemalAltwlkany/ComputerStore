import java.time.LocalDate;

public class Salesman extends Employee{
    private Manager supervisor;

    public Salesman() {
        super();
        this.setPosition("Salesman");
        supervisor = null;
    }

    public Salesman(Salesman other) {
        super(other);
        this.supervisor = other.supervisor;
    }

    public Salesman(String name, String surname, Document doc, LocalDate birthDate, LocalDate joiningDate,
                              double salary, String healthCareNumber) {
        super(name, surname, doc, birthDate, joiningDate, salary, "Salesman", healthCareNumber);
        supervisor = null;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Manager supervisor) {
        this.supervisor = supervisor;
    }
}
