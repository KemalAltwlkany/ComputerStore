import java.time.LocalDate;

public abstract class Employee extends Person{
    private double salary;
    private String position;
    private String healthCareNumber; //country specific format, lets say exactly 14 characters
    private static String[] positions = {"Manager", "Computer Specialist", "Salesman"};

    public Employee(){
        super();
        salary = 50;
        position = null;
        healthCareNumber = null;
    }

    public Employee(Employee emp){
        super(emp.getName(), emp.getSurname(),  emp.getDocument(), emp.getBirthDate(), emp.getJoiningDate());
        this.salary = emp.salary;
        this.position = emp.position;
        this.healthCareNumber = emp.healthCareNumber;
    }

    public Employee(String name, String surname,  Document doc, LocalDate birthDate, LocalDate joiningDate,
                    double salary, String position, String healthCareNumber){
        super(name, surname, doc, birthDate, joiningDate);
        this.salary = salary;
        this.position = position;
        this.healthCareNumber = healthCareNumber;
    }

    //Position can only be one of the predefined values.
    private static boolean validatePosition(String position){
        for(String x : Employee.positions){
            if (x.equals(position)){
                return true;
            }
        }
        return false;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        //only a valid position can be set
        if (Employee.validatePosition(position)){
            this.position = position;
        }
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
                "name= " + this.getName() +
                "surname= " + this.getSurname() +
                "salary=" + salary +
                ", position='" + position + '\'' +
                ", healthCareNumber='" + healthCareNumber + '\'' +
                '}';
    }

    @Override
    public String joinedFor() {
        return "EMPLOYED SINCE: " +  super.joinedFor();
    }
}


