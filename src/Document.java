import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Document {
    private String type;
    private String number; //Unfortunately, a document number is usually an alphanumerical sequence, not an actual num
    private String authority;
    private LocalDate issueDate;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static String[] validDocumentTypes = {"ID card", "Passport", "Drivers licence", "Student card"};
    //for testing reasons only
    private static int fakeDocNumber = 0;
    //FEATURE - implement the image as well?

    /*
    This constructor exists for testing purposes only. It is not meant to be used in the application.
    It uses the static attribute fakeDocNumber in order to create different document numbers which is useful
    for distinction between document objects for testing purposes
    */
    public Document(){
        type = "Passport";
        number = "FakeDoc__" + String.valueOf(fakeDocNumber);
        authority = "FakeMunicipality";
        issueDate = LocalDate.now();
        Document.fakeDocNumber = Document.fakeDocNumber + 1;
    }

    public Document(Document doc){
        this.type = doc.type;
        this.number = doc.number;
        this.authority = doc.authority;
        this.issueDate = doc.issueDate;
    }

    public Document(String type, String number, String authority, LocalDate issueDate){
        this.number = number;
        this.issueDate = issueDate;
        this.authority = authority;
        if (validateType(type)){
            this.type = type;
        }
        else{
            //FEATURE - throw exception or something else?
            this.type = "Passport";
        }
    }

    public Document(String type, String number, String authority, int day, int month, int year){
        this.number = number;
        this.authority = authority;
        //FEATURE - check whether the d/m/y passed as arguments are valid and throw exception?
        issueDate = LocalDate.of(year, month, day);
        if (validateType(type)){
            this.type = type;
        }
        else{
            //throw error or something?
            this.type = "Passport";
        }
    }

    @Override
    public String toString() {
        return "Document{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", authority='" + authority + '\'' +
                ", issueDate=" + issueDate.format(formatter) +
                '}';
    }

    //method checks whether the string passed as an argument is a valid document type.
    //the valid documents accepted are contained within the validDocumentTypes array.
    private Boolean validateType(String type){
        for(String validType : Document.validDocumentTypes){
            if (validType.equals(type)) {
                return true;
            }
        }
        return false;
    }
}
