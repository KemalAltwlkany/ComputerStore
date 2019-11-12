//TO BE implemented - check whether the name and surname are less than 20 and 25 characters
//check whether the age is above 14 to join the club
//Should be done within the sets. Add the gets as well.

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

//Class could be but doesn't necessarily have to be abstract.
public class Person implements IPerson{
    protected String name; //max 15 characters
    protected String surname; //max 25 characters
    protected Document document;
    protected LocalDate birthDate;
    protected LocalDate joiningDate; //Interpreted as joining the staff or club, dependent on the child class.
    //Due to possible change, age should not be store as a variable, but always computed upon requests.
    //The class acts as if the age field exists: private int age;
    protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Person(){
        name = "Fake_person";
        surname = "Fake_surname";
        document = new Document();
        birthDate = LocalDate.of(2000, 1, 1);
        joiningDate = LocalDate.now();
    }

    //copy constructor
    public Person(Person pers){
        this.name = pers.name;
        this.surname = pers.surname;
        this.document = pers.document; // deep copy
        this.birthDate = pers.birthDate;
        this.joiningDate = pers.joiningDate;
    }

    public Person(String name, String surname){
        this.setName(name);
        this.setSurname(surname);
        this.document = new Document();
        this.birthDate = LocalDate.of(2000, 1, 1);
        this.joiningDate = LocalDate.now();
    }

    public Person(String name, String surname, Document doc, LocalDate birthDate, LocalDate joiningDate){
        this.setName(name);
        this.setSurname(surname);
        this.birthDate = birthDate;
        this.document = new Document(doc); //deep copy
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", document=" + document +
                ", birthDate=" + birthDate +
                ", joiningDate=" + joiningDate.format(formatter) +
                '}';
    }

    public String verboseToString(){
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", document=" + document +
                ", birthDate=" + birthDate +
                ", joiningDate=" + joiningDate +
                '}';
    }

    public static Period subtractTwoDates(LocalDate firstDate, LocalDate secondDate){
        return Period.between(firstDate, secondDate);
    }

    public String joinedFor(){
        Period p = Person.subtractTwoDates(joiningDate, LocalDate.now());
        return String.format("%d years, %d months, %d days", p.getYears(), p.getMonths(), p.getDays());
        //String str = String.valueOf(per.getYears()) + String.valueOf(per.getMonths()) +  String.valueOf(per.getDays());
    }

    //No set for the age attribute. Age can only be modified via the BirthDate attribute.
    public int getAge(){
        Period p = Person.subtractTwoDates(birthDate, LocalDate.now());
        return p.getYears();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //Name limited to 15 characters
        if (name.length() > 15){
            return;
        }
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname) {
        //surname limited to 25 characters
        if (surname.length() > 25){
            return;
        }
        this.surname = surname;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        //Class document ensures the assigned document is valid.
        this.document = document;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        //Class LocalDate takes care of ensuring joiningDate is valid.
        this.joiningDate = joiningDate;
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
