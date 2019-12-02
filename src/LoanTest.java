import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
}