//TO BE implemented - check whether the name and surname are less than 20 and 25 characters
//check whether the age is above 14 to join the club
//Should be done within the sets. Add the gets as well.

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

//Class could be but doesn't necessarily have to be abstract.
public class Person implements IPerson{
    private String name;
    private String surname;
    private int age;
    private Document document;
    private LocalDate birthDate;
    private LocalDate joiningDate; //Interpreted as joining the staff or club, dependent on the child class.
//    private String status;
    protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Person(){
        name = "Fake_person";
        surname = "Fake_surname";
        age = 19; //default age will be 19 years, born 01.01.2000.
        document = new Document();
        birthDate = LocalDate.of(2000, 1, 1);
        joiningDate = LocalDate.now();
    }

    public Person(Person pers){
        this.name = pers.name;
        this.surname = pers.surname;
        this.age = pers.age;
        this.document = new Document(pers.document); // deep copy
        this.birthDate = pers.birthDate;
        this.joiningDate = pers.joiningDate;
    }

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.age = 19;
        this.document = new Document();
        this.birthDate = LocalDate.of(2000, 1, 1);
        this.joiningDate = LocalDate.now();
    }

    public Person(String name, String surname, int age, Document doc, LocalDate birthDate, LocalDate joiningDate){
        this.name = name;
        this.surname = surname;
        if (IPerson.ValidateAge(age, birthDate)){
            this.age = age;
            this.birthDate = birthDate;
        }
        else{
            //FEATURE - throw exception?
            this.age = 19;
            this.birthDate = LocalDate.of(2000, 1, 1);
        }
        this.document = new Document(doc); //deep copy
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", document=" + document +
                ", birthDate=" + birthDate.format(formatter) +
                ", joiningDate=" + joiningDate.format(formatter) +
                '}';
    }

    private static Period subtractTwoDates(LocalDate firstDate, LocalDate secondDate){
        return Period.between(firstDate, secondDate);
    }

    public String joinedFor(){
        Period p = Person.subtractTwoDates(joiningDate, LocalDate.now());
        return String.format("%d years, %d months, %d days", p.getYears(), p.getMonths(), p.getDays());
        //String str = String.valueOf(per.getYears()) + String.valueOf(per.getMonths()) +  String.valueOf(per.getDays());
    }

    public String joinedSince(){
        return joiningDate.format(formatter);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    //returning deep copy instead of reference
    public Document getDocument() {
        return new Document(document);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    /*
    public String membersince(){
        LocalDate example = LocalDate.of(2007, 10, 19);
        Period temp = Period.between(example, joiningDate);
        System.out.println("Member for: " + temp.getYears() + " years, " +
                temp.getMonths() + " months,  " +
                temp.getDays() + " days.");
        return temp.toString();
    }
*/

}
