import java.time.LocalDate;

public class ComputerSpecialist extends Employee{
    private Manager supervisor;

    public ComputerSpecialist() {
        super();
        supervisor = null;
    }

    public ComputerSpecialist(ComputerSpecialist other) {
        super(other);
        this.supervisor = other.supervisor;
    }

    public ComputerSpecialist(String name, String surname){
        super(name, surname);
    }

    public ComputerSpecialist(String name, String surname, Document doc, LocalDate birthDate, LocalDate joiningDate,
                              double salary, String healthCareNumber) {
        super(name, surname, doc, birthDate, joiningDate, salary, healthCareNumber);
        supervisor = null;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Manager supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        if (supervisor == null){
            return "ComputerSpecialist{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", salary=" + salary +
                    ", supervisor=null" +
                    "} ";
        }
        return "ComputerSpecialist{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", supervisor={" + supervisor.getName() + ", " + supervisor.getSurname() + "}" +
                "} ";
    }

    @Override
    public String verboseToString() {
        if (supervisor == null){
            return "ComputerSpecialist{" +
                    "supervisor=null, " +
                    super.verboseToString();
        }
        return "ComputerSpecialist{" +
                "supervisor={" + supervisor.getName() + ", " + supervisor.getSurname() + "}" +
                super.verboseToString();
    }
}
