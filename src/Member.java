import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Member extends Person implements Comparable<Person>{
    private ArrayList<Loan> loans= new ArrayList<>();

    public Member() {
        super();
    }

    public Member(Member other) {
        super(other);
        this.loans = other.loans;
    }

    public Member(String name, String surname) {
        super(name, surname);
    }

    public Member(String name, String surname, Document doc, LocalDate birthDate, LocalDate joiningDate) {
        super(name, surname, doc, birthDate, joiningDate);
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    public void addLoan(Loan new_loan){
        this.loans.add(new_loan);
    }

    public void removeLoan(Loan rm_loan){

        this.loans.remove(rm_loan);
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", document={" + getDocument().getType() + ", " + getDocument().getNumber() + '}' +
                ", joiningDate=" + getJoiningDate().format(formatter) +
                ", loans=" + loans +
                '}';
    }

    @Override
    public String joinedFor() {
        return "MEMBER FOR: " + super.joinedFor();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (!(obj instanceof Member)){
            return false;
        }
        Member p2 = (Member) obj;
        if ( this.getName().equals(p2.getName()) && this.getJoiningDate().equals(p2.getJoiningDate())){
            return true;
        }
        else return false;
    }

    //Update 03.12.2019.
    //Members are compared based on their date of joining the club.
    @Override
    public int compareTo(Person person) {
        if ( this.getJoiningDate().isEqual(person.getJoiningDate())){
            return 0;
        }
        else if ( this.getJoiningDate().isBefore(person.getJoiningDate())){
            return -1;
        }
        return 1;
    }
}
