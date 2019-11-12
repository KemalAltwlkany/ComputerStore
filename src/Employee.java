import java.time.LocalDate;

public abstract class Employee extends Person{
    protected double salary;
    protected String healthCareNumber; //country specific format, lets say exactly 14 characters

    public Employee(){
        super();
        salary = 50;
        healthCareNumber = null;
    }

    public Employee(Employee emp) {
        super(emp); //super(emp.name, emp.surname, emp.document, emp.birthDate, emp.joiningDate);
        this.salary = emp.salary;
        this.healthCareNumber = emp.healthCareNumber;
    }

    public Employee(String name, String surname){
        super(name, surname);
        salary = 50;
        healthCareNumber = null;
    }

    public Employee(String name, String surname,  Document doc, LocalDate birthDate, LocalDate joiningDate,
                    double salary, String healthCareNumber){
        super(name, surname, doc, birthDate, joiningDate);
        this.salary = salary;
        this.healthCareNumber = healthCareNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        //must be a positive value
        if (salary < 0){
            return;
        }
        this.salary = salary;
    }

    public String getHealthCareNumber() {
        return healthCareNumber;
    }

    public void setHealthCareNumber(String healthCareNumber) {
        //for the needs of this assignment, we'll just check whether the healthCareNumber is exactly 14 characters long
        if (healthCareNumber.length() == 14){
            this.healthCareNumber = healthCareNumber;
        }
        return;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", name= " + name +
                ", surname= " + surname +
                ", salary=" + salary +
                ", position='" + this.getClass().getSimpleName() + '\'' +
                ", healthCareNumber='" + healthCareNumber + '\'' +
                '}';
    }

    @Override
    public String verboseToString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", document=" + document +
                ", birthDate=" + birthDate +
                ", joiningDate=" + joiningDate +
                ", salary=" + salary +
                ", healthCareNumber='" + healthCareNumber + '\'' +
                ", position= " + this.getClass().getSimpleName() + '\'' +
                '}';
    }

    @Override
    public String joinedFor() {
        return "EMPLOYED SINCE: " +  super.joinedFor();
    }

    public abstract void setSupervisor(Manager supervisor);

}


