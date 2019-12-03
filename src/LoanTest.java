import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {

    @Test
    void isOverDue() {
        //Create overdue loan
        Member m1 = new Member();
        Book b1 = new Book();
        Loan l1 = new Loan(m1, b1, LocalDate.of(2019, 11, 15));
        assertEquals(true, l1.isOverDue());

        //Create non-overdue loan (needs to be updated max 15 days with respect of testing day
        Loan l2 = new Loan(m1, b1, LocalDate.of(2019, 11, 28));
        assertEquals(false, l2.isOverDue());
    }

    @Test
    void compareTo() {
        Member m1 = new Member();
        Book b1 = new Book();
        Loan l1 = new Loan(m1, b1, LocalDate.of(2018, 12, 11)); //before, should be 1st
        Loan l2 = new Loan(m1, b1, LocalDate.of(2018, 12, 12)); //after, should be 2nd
        assertEquals(-1, l1.compareTo(l2));

        Loan l3 = new Loan(m1, b1, LocalDate.of(2018, 12, 24)); //should be greater than l1, and l2
        assertEquals(1, l3.compareTo(l2));
        assertEquals(1, l3.compareTo(l1));
        Loan l4 = new Loan(m1, b1, LocalDate.of(2018, 12, 12)); //same loan date as l2
        assertEquals(0, l4.compareTo(l2));
    }

    @Test
    void testEquals() {
        Member m1 = new Member("Sadio", "Mane");
        Member m2 = new Member("Jamie", "Vardy");
        Book b1 = new Book();
        Notebook n1 = new Notebook();
        //Loans l1 and l2 only differ in date, but are different
        Loan l1 = new Loan(m1, b1, LocalDate.of(2018, 12, 11));
        Loan l2 = new Loan(m1, b1, LocalDate.of(2018, 12, 12));
        assertEquals(false, l1.equals(l2));

        //Loans l3 and l4 only differ in member, but are different
        Loan l3 = new Loan(m1, b1, LocalDate.of(2000, 10, 10));
        Loan l4 = new Loan(m2, b1, LocalDate.of(2000, 10, 10));
        assertEquals(false, l3.equals(l4));

        //Loans l5 and l6 only differ in item, but are different
        Loan l5 = new Loan(m1, b1, LocalDate.of(2000, 10, 10));
        Loan l6 = new Loan(m1, n1, LocalDate.of(2000, 10, 10));
        assertEquals(false, l5.equals(l6));

        //Loans l7 and l8 are identical
        Loan l7 = new Loan(m1, b1, LocalDate.of(2000, 10, 10));
        Loan l8 = new Loan(m1, b1, LocalDate.of(2000, 10, 10));
        assertEquals(true, l7.equals(l8));
    }

    @Test
    void getCost() {
        Member m1 = new Member();
        Notebook n1 = new Notebook();
        n1.setBaseRentPrice(1.5);

        //Create loan 10 days ago
        Loan l1 = new Loan(m1, n1, LocalDate.now().minusDays(10));
        //The rent is equal to 10*1.5 euro = 15.0 euro
        assertEquals(15.0, l1.getCost());

        //Create overdue loan, with 7 days overdue
        Loan l2 = new Loan(m1, n1, LocalDate.now().minusDays(15+7));
        assertEquals(15*1.5 + 1.8*7, l2.getCost());


    }

    @Test
    void testComparator(){
        Loan l1 = new Loan(new Member(), new Notebook(), LocalDate.of(2019, 10, 10));
        Loan l2 = new Loan(new Member(), new Notebook(), LocalDate.of(2019, 10, 9));
        Loan l3 = new Loan(new Member(), new Notebook(), LocalDate.of(2019, 10, 8));
        Loan l4 = new Loan(new Member(), new Notebook(), LocalDate.of(2019, 10, 11));
        //Earlier date comes first
        ArrayList<Loan> loans = new ArrayList<>();
        loans.add(l1); loans.add(l2); loans.add(l3); loans.add(l4);
        System.out.println(loans);
        loans.sort(Loan.loanComparator);
        System.out.println(loans);
        ArrayList<Loan> loans2 = new ArrayList<>();
        loans2.add(l3); loans2.add(l2); loans2.add(l1); loans2.add(l4);
        assertEquals(loans, loans2);
    }
}