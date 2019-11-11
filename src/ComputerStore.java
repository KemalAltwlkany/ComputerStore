import java.time.LocalDate;

public class ComputerStore {

    public static void main(String[] args) {
//        DocumentTest1();
//        DocumentTest2();
        PersonTest1();
        PersonTest2();
        PersonTest3();
//        BookTest1();
            //
     //   PCTest1();
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
        System.out.println("---------FINISHED PersonTest 3--------");
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





}

