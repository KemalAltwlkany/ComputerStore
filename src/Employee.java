import java.time.LocalDate;

public class Employee extends Person{
    private double salary;
    private String position;

    public Employee(){
        super();
        salary = 0;
        position = null;
    }

    public Employee(Employee emp){
        super(emp.getName(), emp.getSurname(), emp.getAge(), emp.getDocument(), emp.getBirthDate(), emp.getJoiningDate());
        this.salary = emp.salary;
        this.position = emp.position;
    }

    public Employee(double salary, String position, String name, String surname, int age, Document doc,
                    LocalDate birthDate, LocalDate joiningDate){
        super(name, surname, age, doc, birthDate, joiningDate);
        this.salary = salary;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", position='" + position + '\'' +
                ", name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", age=" + super.getAge() +
                ", document=" + super.getDocument() +
                ", birthDate=" + super.getBirthDate().format(Person.formatter) +
                ", joiningDate=" + super.getJoiningDate().format(Person.formatter) +
                '}';
    }


}
