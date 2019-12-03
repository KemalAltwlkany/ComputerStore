import java.time.LocalDate;
import java.util.Comparator;

public abstract class Employee extends Person implements Comparable<Employee> {
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

    //02.12.2019. Update


    @Override
    public int compareTo(Employee employee) {
        if ( ((Double) employee.getSalary()).equals(this.getSalary())  ){
            return 0;
        }
        else if ( employee.getSalary() - this.getSalary() < 0){
            return 1;
        }
        else return -1;
    }

    //Two Employees are equal if they have the same name, surname and salary.
    @Override
    public boolean equals(Object obj) {
        //If the object is compared with itself it is obviously equal to itself
        if ( obj == this){
            return true;
        }

        //Check whether obj is an instance of class Employee
        //NOTE - interestingly enough, this will return true even for objects of type Salesman, ComputerSpecialist and Manager
        if (!(obj instanceof  Employee)){
            return false;
        }

        //Since now it obviously is an instance of class Employee, we typecast it to Employee
        Employee e2 = (Employee) obj;
        if ( e2.getName().equals(this.getName()) && e2.getSurname().equals(this.getSurname()) && ( ( (Double) e2.getSalary()).equals(this.getSalary())) ){
            return true;
        }
        return false;
    }

    public static Comparator<Employee> EmployeeComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee employee, Employee t1) {
            return employee.compareTo(t1);
        }
    };


}


