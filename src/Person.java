import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public class Person {
    private String name;
    private int age;
    private String documentInfo;
    private String documentNumber;
    private LocalDate joiningDate;
//    private String status;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Person(){
        name = "Fake_person";
        age = 18;
        documentInfo = null;
        documentNumber = null;
        joiningDate = LocalDate.now();
    }

    public Person(Person pers){
        this.name = pers.name;
        this.age = pers.age;
        this.documentInfo = pers.documentInfo;
        this.documentNumber = pers.documentNumber;
        this.joiningDate = pers.joiningDate;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.documentInfo = null;
        this.documentNumber = null;
        this.joiningDate = LocalDate.now();
    }

    public Person(String name, int age, String documentInfo, String documentNumber, LocalDate joiningDate){
        this.name = name;
        this.age = age;
        this.documentInfo = documentInfo;
        this.documentNumber = documentNumber;
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", documentInfo='" + documentInfo + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", joiningDate=" + joiningDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDocumentInfo() {
        return documentInfo;
    }

    public void setDocumentInfo(String documentInfo) {
        this.documentInfo = documentInfo;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setJoiningDate(int year, int month, int day){
        joiningDate = LocalDate.of(year, month, day);
    }

    private Period subtractTwoDates(LocalDate firstDate, LocalDate secondDate){
        return Period.between(firstDate, secondDate);
    }

    public String memberFor(){
        return subtractTwoDates(joiningDate, LocalDate.now()).toString();
    }

//    public String membersince(){
//        LocalDate example = LocalDate.of(2007, 10, 19);
//        Period temp = Period.between(example, joiningDate);
//        System.out.println("Member for: " + temp.getYears() + " years, " +
//                temp.getMonths() + " months,  " +
//                temp.getDays() + " days.");
//        return temp.toString();
//    }


}
