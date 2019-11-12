import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class ComputerStore {

    public static void main(String[] args) {
//        DocumentTest1();
//        DocumentTest2();
//        PersonTest1();
//        PersonTest2();
//        PersonTest3();
//        BookTest1();
//        PCTest1();
            StoreTest1();
            MemberTest1();
            LoanTest1();
    }

    //Tests the constructors and toString of class Document.
    public static void DocumentTest1(){
        System.out.println("---------***************************--------");
        System.out.println("---------RUNNING DocumentTest 1--------");

        Document doc1 = new Document();
        System.out.println(doc1);

        Document doc2 = new Document(doc1);
        System.out.println(doc2);

        Document doc3 = new Document("Passport", "PASS_0001", "Auth", LocalDate.now());
        System.out.println(doc3);

        Document doc4 = new Document("ID card", "ID_7999", "Auth", 03, 11, 1996);
        System.out.println(doc4);

        System.out.println("---------FINISHED DocumentTest 1--------");
        System.out.println("---------***************************--------");
    }

    //Should fail because of invalid date argument (30th of February)
    public static void DocumentTest2(){
        System.out.println("---------***************************--------");
        System.out.println("---------RUNNING DocumentTest 1--------");
        Document doc1 = new Document("ID card", "N0_001", "Auth",30, 2, 1996);
        System.out.println();
        System.out.println("---------FINISHED DocumentTest 1--------");
        System.out.println("---------***************************--------");
    }

    //Tests constructors and toString of class Person
    public static void PersonTest1(){
        System.out.println("---------***************************--------");
        System.out.println("---------RUNNING PersonTest 1--------");

        Person pers1 = new Person();
        System.out.println(pers1);

        Person pers2 = new Person(pers1);
        System.out.println(pers2);

        Person pers3 = new Person("Kemal", "Altwlkany");
        System.out.println(pers3);

        Document doc4 = new Document();
        LocalDate birthDate = LocalDate.of(1996, 11, 3);
        Person pers4 = new Person("Kemal", "Alt", doc4, birthDate, LocalDate.now());
        System.out.println(pers4);

        System.out.println("---------FINISHED PersonTest 1--------");
        System.out.println("---------***************************--------");
    }

    //Tests the joinedFor and joinedSince methods
    public static void PersonTest2(){

        System.out.println("---------***************************--------");
        System.out.println("---------RUNNING PersonTest 2--------");

        Person pers1 = new Person();
        System.out.println("pers1 is a member for " + pers1.joinedFor());
        System.out.println("pers1 is a member since " + pers1.getJoiningDate() );

        Document doc4 = new Document();
        LocalDate birthDate = LocalDate.of(1996, 11, 3);
        Person pers4 = new Person("Kemal", "Alt", doc4, birthDate, LocalDate.of(2012, 11, 1));
        System.out.println("pers4 is a member for " + pers4.joinedFor());
        System.out.println("pers4 is a member since " + pers4.getJoiningDate() );

        System.out.println("---------FINISHED PersonTest 2--------");
        System.out.println("---------***************************--------");

    }

    //Tests the legitimacy of input data to the constructor
    public static void PersonTest3(){
        System.out.println("---------RUNNING PersonTest 3--------");
        System.out.println("---------***************************--------");

        Document doc1 = new Document();
        Person pers1 = new Person("AA", "BB",  doc1, LocalDate.of(2006, 12, 30), LocalDate.now());
        System.out.println(pers1);

        System.out.println("---------FINISHED PersonTest 3--------");
        System.out.println("---------***************************--------");

    }

    //Tests the constructors of class Book
    public static void BookTest1(){
        System.out.println("---------***************************--------");
        System.out.println("---------RUNNING BookTest 1--------");

        Book b1 = new Book();
        System.out.println(b1);

        Book b2 = new Book("Conpts of Prog Langs", "Robert Sebesta", LocalDate.of(2012, 1, 1), 0.1, 14.99);
        System.out.println(b2);


        System.out.println("---------FINISHED BookTest 1--------");
        System.out.println("---------***************************--------");

    }

    //Tests the constructors of class PC (Laptop, Notebook etc..)
    public static void PCTest1(){
        Laptop pc1 = new Laptop("HP", 8, 1.5, 2.7, 1.2, "Intel Core i7 - 7200K", "AMD Radeon 1", "gray", 12, 800);
        Laptop pc2 = new Laptop("Dell", 8, 1.5, 2.7, 1.2, "Intel Core i7 - 7200K", "AMD Radeon 1", "gray", 12, 800);
        Laptop pc3 = new Laptop("Lenovo", 8, 1.5, 2.7, 1.2, "Intel Core i7 - 7200K", "AMD Radeon 1", "gray", 12, 800);
        Laptop pc4 = new Laptop();
        Laptop pc5 = new Laptop(pc1);
        pc1.setCpu_speed(5.6);
        System.out.println(pc1);
        System.out.println(pc5);

        DesktopPC pc6 = new DesktopPC("HP DESKTOP", 8, 1.5, 2.7, 1.2, "Intel Core i7 - 7200K", "AMD Radeon 1", "gray", 12, 800);
        DesktopPC pc7 = new DesktopPC(pc6);
        System.out.println(pc6);
        System.out.println(pc7);

        Notebook pc8 = new Notebook("HP NOTEBOOK", 8, 1.5, 2.7, 1.2, "Intel Core i7 - 7200K", "AMD Radeon 1", "gray", 12, 800);
        Notebook pc81 = new Notebook(pc8);
        pc81.setColour("YELLOW");
        System.out.println(pc8);
        System.out.println(pc81);

        Ultrabook pc9 = new Ultrabook("HP ULTRABOOK", 8, 1.5, 2.7, 1.2, "Intel Core i7 - 7200K", "AMD Radeon 1", "gray", 12, 800);
        Ultrabook pc91 = new Ultrabook(pc9);
        pc91.setAvailable(false);
        System.out.println(pc9);
        System.out.println(pc91);


        Tablet pc10 = new Tablet("HP TABLET", 8, 1.5, 2.7, 1.2, "Intel Core i7 - 7200K", "AMD Radeon 1", "gray", 12, 800);
        Tablet pc101 = new Tablet(pc10);
        pc101.setDescription("This is a tablet.");
        System.out.println(pc10);
        System.out.println(pc101);


        Chromebook pc11 = new Chromebook("HP CHROMEBOOK", 8, 1.5, 2.7, 1.2, "Intel Core i7 - 7200K", "AMD Radeon 1", "gray", 12, 800);
        Chromebook pc111 = new Chromebook(pc11);
        pc111.setDescription("This is a chromebook.");
        System.out.println(pc11);
        System.out.println(pc111);

    }

    //Test the constructors of class Store
    public static void StoreTest1(){
        System.out.println("---------RUNNING  StoreTest 1--------");
        System.out.println("---------***************************--------");

        Store st1 = new Store();
        st1.setName("Bosnian-Irish Company");
        System.out.println(st1);

        Store st2 = new Store("Dutch-German Store");
        System.out.println(st2);


        System.out.println("---------FINISHED StoreTest 1--------");
        System.out.println("---------***************************--------");
    }

    //Tests the constructors and basic methods of class Member
    public static void MemberTest1(){
        System.out.println("---------RUNNING  MemberTest 1--------");
        System.out.println("---------***************************--------");

        Member m1 = new Member();
        System.out.println(m1);

        m1.setName("Kemal");
        m1.setSurname("Altwlkany");
        m1.setBirthDate(LocalDate.of(1996, 11, 11));
        m1.setJoiningDate(LocalDate.of(2015, 11, 12));
        System.out.println("Expected output: Kemal Altwlkany, born 11.11.1996, member since 12.11.2015.");
        System.out.println(m1);

        System.out.println();
        System.out.println();

        Member m2 = new Member(m1);
        m2.setName("Doctor");
        m2.setSurname("Strange");
        System.out.println("Expected output: Doctor Strange, born 11.11.1996, member since 12.11.2015.");
        System.out.println("Expected output: Kemal Altwlkany, born 11.11.1996, member since 12.11.2015.");
        System.out.println(m2);
        System.out.println(m1);

        System.out.println();
        System.out.println();

        Member m3 = new Member("Bernard", "Shaw");
        m3.setBirthDate(LocalDate.of(1999, 1, 1));
        System.out.println("Expected output: Bernard Shaw, born 01.01.1999, member since TODAY.");
        System.out.println(m3);

        System.out.println();
        System.out.println();

        System.out.println(m1.getName() + " " +  m1.joinedFor());
        System.out.println(m2.getName() + " " +  m2.joinedFor());
        System.out.println(m3.getName() + " " +  m3.joinedFor());

        System.out.println("---------FINISHED MemberTest 1--------");
        System.out.println("---------***************************--------");
    }

    //Tests the creation of Loans
    public static void LoanTest1(){
        System.out.println("---------RUNNING  LoanTest 1--------");
        System.out.println("---------***************************--------");
        Member m1 = new Member("Tony", "Hawk");
        Member m2 = new Member("Al", "Pacino");
        Member m3 = new Member("Robert", "De Niro");
        Member m4 = new Member("Heath", "Ledger");
        Member m5 = new Member("James", "Bond");
        Member m6 = new Member("Jamie", "Vardy");
        Member m7 = new Member("Marcus", "Rashford");
        Member m8 = new Member("Marco", "Parigi");

        Book b1 = new Book();
        b1.setTitle("Book ONE");
        Book b2 = new Book();
        b2.setTitle("Book TWO");

        Laptop pclap1 = new Laptop();
        //pclap1.setName("Acer Aspire E5");

        Tablet pctab1 = new Tablet();
        //pctab1.setName("iPad 4");

        DesktopPC pcdesk1 = new DesktopPC();
        pcdesk1.setName("IMTEC");

        Notebook pcnote1 = new Notebook();
        pcnote1.setName("ASUS Light");

        Ultrabook pcultra1 = new Ultrabook();
        pcultra1.setName("Zenbook ULTRA");

        Chromebook pcchrome1 = new Chromebook();
        pcchrome1.setName("Chrome by Google");

        Loan l1 = new Loan(m1, b1, LocalDate.of(2011, 1, 10));
        Loan l2 = new Loan(m2, b2, LocalDate.of(2012, 2, 11));
        Loan l3 = new Loan(m3, pclap1, LocalDate.of(2013, 3, 13));
        Loan l4 = new Loan(m4, pctab1, LocalDate.of(2014, 4, 14));
        Loan l5 = new Loan(m5, pcdesk1, LocalDate.of(2015, 5, 15));
        Loan l6 = new Loan(m6, pcnote1, LocalDate.of(2016, 6, 16));
        Loan l7 = new Loan(m7, pcultra1, LocalDate.of(2017, 7, 17));
        Loan l8 = new Loan(m8, pcchrome1, LocalDate.of(2018, 8, 18));

        System.out.println(l1);
        System.out.println(l2);
        System.out.println();
        System.out.println();

        System.out.println(l3);
        System.out.println(l4);
        System.out.println();
        System.out.println();

        System.out.println(l5);
        System.out.println(l6);
        System.out.println();
        System.out.println();

        System.out.println(l7);
        System.out.println(l8);

        System.out.println("Now modifying in order parameters to be the same");
        l1.getLoanedTo().setName("PERSON 1");
        m2.setName("PERSON 2");

        l1.getLoanedItem().setName("FAKE ITEM 1");
        b2.setName("NEW FAKE BOOK 2");
        System.out.println(l1);
        System.out.println(l2);
        System.out.println();
        System.out.println();


        System.out.println("---------FINISHED LoanTest 1--------");
        System.out.println("---------***************************--------");
    }




}

