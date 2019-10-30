import java.time.LocalDate;

public class ComputerStore {

    public static void main(String[] args) {
        //DocumentTest1();
        DocumentTest2();
        PersonTest1();
        PersonTest2();
        PersonTest3();
    }

    public static void AllDocumentTests(){
        DocumentTest1();
        //DocumentTest2(); //should fail
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

    //Tests constructors of class Person
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
        Person pers4 = new Person("Kemal", "Alt", 22, doc4, birthDate, LocalDate.now());
        System.out.println(pers4);

        System.out.println("---------FINISHED PersonTest 1--------");
        System.out.println("---------***************************--------");
    }

    //Tests the memberFor and memberSince functions
    public static void PersonTest2(){

        System.out.println("---------***************************--------");
        System.out.println("---------RUNNING PersonTest 2--------");

        Person pers1 = new Person();
        System.out.println("pers1 is a member for " + pers1.memberFor());
        System.out.println("pers1 is a member since " + pers1.memberSince() );

        Document doc4 = new Document();
        LocalDate birthDate = LocalDate.of(1996, 11, 3);
        Person pers4 = new Person("Kemal", "Alt", 22, doc4, birthDate, LocalDate.of(2012, 10, 30));
        System.out.println("pers4 is a member for " + pers4.memberFor());
        System.out.println("pers4 is a member since " + pers4.memberSince() );

        System.out.println("---------FINISHED PersonTest 2--------");
        System.out.println("---------***************************--------");

    }

    //Tests the legitimacy of input data to the constructor
    public static void PersonTest3(){
        Document doc1 = new Document();
        Person pers1 = new Person("AA", "BB", 15, doc1, LocalDate.of(2006, 12, 30), LocalDate.now());
        //Even though we assigned age 15 and year 2006, the program sets age to 19 and year to 2000 by default
        //because the passed arguments were incompatible.
        System.out.println(pers1);
    }
}

