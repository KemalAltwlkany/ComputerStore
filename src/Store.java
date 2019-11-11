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

    public void removeLoan(Loan x){
        loans.remove(x);
    }

}
