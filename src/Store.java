import com.sun.source.tree.LiteralTree;

import javax.swing.text.html.HTMLDocument;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

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

    //Update 27.11.2019.
    ///--------------

    //Sorts the loans by FIFO rule
    public void sortLoans(){
        Collections.sort(loans);
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void printEmployeeSalaries(){
        Iterator it = staff.iterator();
        System.out.println("----------------------------------------------------------");
        while(it.hasNext()){
            Employee emp = (Employee) it.next();
            System.out.println("Employee: " + emp.getName() + ", " + emp.getSurname() + ", " + emp.getSalary() + "e.");
        }
        System.out.println("----------------------------------------------------------");
    }

    //Update 27.11.2019.
    ///--------------

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


    //BIG CHANGE - this function now expects three parameters!
    //Added the last parameter, LocalDate, which enables to set the date of the loan
    //Returns true/false depending whether the loan was successful or not.
    public boolean createLoan(Member m, Item it, LocalDate date){
        //CHECK IF ITEM IS LOANED ALREADY
        //ADD FEATURE LATER TO CREATE MAX NUMBER OF LOANS PER MEMBER
        if (it.isAvailable()){
            Loan new_loan = new Loan(m, it, date);
            loans.add(new_loan);

            //Very important, the member and item class need to be updated as well!
            m.addLoan(new_loan);
            it.setAvailable(false);
            return true;
        }
        else return false;
    }

    public void returnItem(Item x){
        if ( x.isAvailable() ){
            return;
        }
        for(Loan loaned_item : loans){
            if (loaned_item.getLoanedItem() == x){
                removeLoan(loaned_item);
                return;
            }
        }
    }

    public void removeLoan(Loan x){
        //First we remove the loan from the person's item list as well as change the state of the item to available
        x.getLoanedTo().removeLoan(x);
        x.getLoanedItem().setAvailable(true);

        //Ensure the loan has no data in itself
        x.setLoanedTo(null);
        x.setLoanedItem(null);

        //Finally, remove the loan from the list of loans
        loans.remove(x);
    }

    public double getEmployeeSalary(Employee x){
        return x.getSalary();
    }

    //Returns list of currently loaned items
    public ArrayList<Item> getLoanedItems(Member x){
        ArrayList<Item> items = new ArrayList<>();
        for(Loan i : loans){
            items.add(i.getLoanedItem());
        }
        return items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* It doesn't make much sense to have sets and gets for the Store arrays. They are supposed to be operated
    element-wise. I have implemented them and commented, in case they are required. */

    /*

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

     */
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
