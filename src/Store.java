import java.time.LocalDate;
import java.util.ArrayList;

public class Store {
    private String name;
    private ArrayList<Item> items;
    private ArrayList<Employee> staff;
    private ArrayList<Member> members;
    private ArrayList<Loan> loans;

    public Store(){
        name = "Fake_store";
        items = new ArrayList<>();
        staff = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public Store(String name){
        this.name = name;
        items = new ArrayList<>();
        staff = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public void addItem(Item x){
        items.add(x);
    }

    public void removeItem(Item x){
        items.remove(x);
    }

    public void addEmployee(Employee x){
        staff.add(x);
    }

    public void removeEmployee(Employee x){
        staff.remove(x);
    }

    public void addMember(Member x){
        members.add(x);
    }

    public void removeMember(Member x){
        members.remove(x);
    }

    public void addLoan(Loan x){
        loans.add(x);
    }

    //Returns true/false depending whether the loan was successful or not.
    public boolean createLoan(Member memb, Item it){
        //CHECK IF ITEM IS LOANED ALREADY
        //ADD FEATURE LATER TO CREATE MAX NUMBER OF LOANS PER MEMBER
        if (it.isAvailable()){
            Loan new_loan = new Loan(memb, it, LocalDate.now());
            loans.add(new_loan);
            return true;
        }
        else return false;
    }

    public void removeLoan(Loan x){
        loans.remove(x);
    }

    public void returnLoan(Loan x){
        x.getLoanedItem().setAvailable(true);
    }

    public double getEmployeeSalary(Employee x){
        return x.getSalary();
    }

    public ArrayList<Loan> getLoanedItems(Member x){
        return x.getLoans();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Employee> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Employee> staff) {
        this.staff = staff;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", items=" + items +
                ", staff=" + staff +
                ", members=" + members +
                ", loans=" + loans +
                '}';
    }
}
