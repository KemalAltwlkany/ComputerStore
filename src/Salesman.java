import java.time.LocalDate;

public class Salesman extends Employee{
    private Manager supervisor;

    public Salesman() {
        super();
        supervisor = null;
    }

    public Salesman(Salesman other) {
        super(other);
        this.supervisor = other.supervisor;
    }

    public Salesman(String name, String surname){
        super(name, surname);
    }

    public Salesman(String name, String surname, Document doc, LocalDate birthDate, LocalDate joiningDate,
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
            return "Salesman{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", salary=" + salary +
                    ", supervisor=" + null +
                    "} ";
        }
        return "Salesman{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                "supervisor={" + supervisor.getName() + ", " + supervisor.getSurname() + "}" +
                "} ";
    }

    @Override
    public String verboseToString() {
        if (supervisor == null) {
            return "Salesman{" +
                    "supervisor=null, " + super.verboseToString();
        }
        return "Salesman{" +
                "supervisor={" + supervisor.getName() + ", " + supervisor.getSurname() + "}" +
                super.verboseToString();
    }
}
