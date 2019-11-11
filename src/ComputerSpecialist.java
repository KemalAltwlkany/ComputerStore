import java.time.LocalDate;

public class ComputerSpecialist extends Employee{
    private Manager supervisor;

    public ComputerSpecialist() {
        super();
        this.setPosition("Computer Specialist");
        supervisor = null;
    }

    public ComputerSpecialist(ComputerSpecialist other) {
        super(other);
        this.supervisor = other.supervisor;
    }

    public ComputerSpecialist(String name, String surname, Document doc, LocalDate birthDate, LocalDate joiningDate,
                              double salary, String healthCareNumber) {
        super(name, surname, doc, birthDate, joiningDate, salary, "Computer Specialist", healthCareNumber);
        supervisor = null;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Manager supervisor) {
        this.supervisor = supervisor;
    }
}
