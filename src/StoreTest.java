import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class StoreTest {



    //Tests whether the Loans are sorted correctly
    @org.junit.jupiter.api.Test
    void sortLoans() {
        System.out.println("---------***************************--------");
        System.out.println("--------- STARTED testing the sortLoans method--------");
        Store st1 = new Store();
        Member m1 = new Member("Peter", "Parker");
        Member m2 = new Member("Clark", "Kent");
        Member m3 = new Member("Tony", "Stark");
        Member m4 = new Member("Bruce", "Wayne");

        Book b1 = new Book();
        b1.setTitle("Java");
        Book b2 = new Book();
        b2.setTitle("C++");
        Book b3 = new Book();
        b3.setTitle("Python");
        Book b4 = new Book();
        b4.setTitle("JavaScript");

        st1.addMember(m1);
        st1.addMember(m2);
        st1.addMember(m3);
        st1.addMember(m4);
        st1.addItem(b1);
        st1.addItem(b2);
        st1.addItem(b3);
        st1.addItem(b4);

        System.out.println("Current store status:");
        System.out.println(st1);
        System.out.println("Creating loans 1-1, 2-2, 3-3, 4-4");
        System.out.println();
        st1.createLoan(m1, b1, LocalDate.of(2012, 12, 12)); //2nd
        st1.createLoan(m2, b2, LocalDate.of(2002, 11, 3)); //1st
        st1.createLoan(m3, b3, LocalDate.now()); //4th
        st1.createLoan(m4, b4, LocalDate.of(2019, 4, 16)); //3rd

        System.out.println();
        System.out.println(st1);
        System.out.println();
        st1.sortLoans();
        System.out.println("Now sorting the loans of the store: ");
        System.out.println("Expecting output :2nd, 1st, 4th, 3rd loan");
        System.out.println();
        System.out.println(st1);


        //Create loans and check whether they are equal to the sorted array

        Loan l1 = new Loan(m2, b2, LocalDate.of(2002, 11, 3));
        Loan l2 = new Loan(m1, b1, LocalDate.of(2012, 12, 12));
        Loan l3 = new Loan(m4, b4, LocalDate.of(2019, 4, 16));
        Loan l4 = new Loan(m3, b3, LocalDate.now());

        ArrayList<Loan> sortedLoans = st1.getLoans();

        assertEquals(l1, sortedLoans.get(0));
        assertEquals(l2, sortedLoans.get(1));
        assertEquals(l3, sortedLoans.get(2));
        assertEquals(l4, sortedLoans.get(3));


        System.out.println();
        System.out.println("---------FINISHED testing sortLoans method--------");
        System.out.println("---------***************************--------");
    }

    @org.junit.jupiter.api.Test
    void sortEmployees(){
        Store st1 = new Store();
        Salesman s1 = new Salesman();
        s1.setSalary(277);
        Salesman s2 = new Salesman();
        s2.setSalary(200);
        Salesman s3 = new Salesman();
        s3.setSalary(500);
        Salesman s4 = new Salesman();
        s4.setSalary(190);
        ComputerSpecialist cs1 = new ComputerSpecialist();
        cs1.setSalary(3500);
        ComputerSpecialist cs2 = new ComputerSpecialist();
        cs2.setSalary(4700);
        Manager m1 = new Manager();
        m1.setSalary(100000);
        Manager m2 = new Manager();
        m2.setSalary(200000);

        st1.addEmployee(s1); st1.addEmployee(s2); st1.addEmployee(s3); st1.addEmployee(s4);
        st1.addEmployee(cs1); st1.addEmployee(cs2); st1.addEmployee(m1); st1.addEmployee(m2);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(s4);
        employees.add(s2);
        employees.add(s1);
        employees.add(s3);
        employees.add(cs1);
        employees.add(cs2);
        employees.add(m1);
        employees.add(m2);


        //System.out.println(s1.getClass());
        //System.out.println(s1 instanceof  Salesman);
        System.out.println("--------------------------------------------------------------------");
        System.out.println(st1.getStaff());
        System.out.println("--------------------------------------------------------------------");
        System.out.println("After sorting the staff: ");
        st1.sortEmployees();
        System.out.println(st1.getStaff());
        System.out.println("--------------------------------------------------------------------");

        assertEquals(employees, st1.getStaff());
    }

    @Test
    void sortMembers() {
        Store st1 = new Store();

        Member m1 = new Member();
        m1.setJoiningDate(LocalDate.of(2009, 10, 10));
        Member m2 = new Member();
        m2.setJoiningDate(LocalDate.of(2015, 10, 10));
        Member m3 = new Member();
        m3.setJoiningDate(LocalDate.of(2011, 3, 5));
        Member m4 = new Member();
        m4.setJoiningDate(LocalDate.now());

        st1.addMember(m1);
        st1.addMember(m2);
        st1.addMember(m3);
        st1.addMember(m4);

        ArrayList<Member> members = new ArrayList<>();
        members.add(m1);
        members.add(m3);
        members.add(m2);
        members.add(m4);

        System.out.println("--------------------------------------------------------------------");
        System.out.println(st1.getMembers());
        System.out.println("--------------------------------------------------------------------");
        System.out.println("After sorting the members: ");
        st1.sortMembers();
        System.out.println(st1.getMembers());
        System.out.println("--------------------------------------------------------------------");


        assertEquals(members, st1.getMembers());
    }
}