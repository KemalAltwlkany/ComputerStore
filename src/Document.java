import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Document {
    private String type;
    private String number; //Unfortunately, a document number is usually an alphanumerical sequence, not an actual num, max 20 chars
    private String authority; //max 30 chars
    private LocalDate issueDate;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static String[] validDocumentTypes = {"ID card", "Passport", "Drivers licence", "Student card"};
    private static int fakeDocNumber = 0;     //for testing reasons only
    //FEATURE - implement the image later as well?


    /* This constructor exists for testing purposes only. It is not meant to be used in the application.
    It uses the static attribute fakeDocNumber in order to create different document numbers which is useful
    for distinction between document objects for testing purposes */
    public Document(){
        type = "Passport";
        number = "FakeDoc__" + String.valueOf(fakeDocNumber);
        authority = "FakeMunicipality";
        issueDate = LocalDate.now();
        Document.fakeDocNumber = Document.fakeDocNumber + 1;
    }

    //Creates deep copy of object
    public Document(Document doc){
        this.type = doc.type;
        this.number = doc.number;
        this.authority = doc.authority;
        this.issueDate = doc.issueDate;
    }

    public Document(String type, String number, String authority, LocalDate issueDate){
        this.setType(type);
        this.setNumber(number);
        this.setAuthority(authority);
        this.setIssueDate(issueDate);
    }

    public Document(String type, String number, String authority, int day, int month, int year){
        this.setType(type);
        this.setNumber(number);
        this.setAuthority(authority);
        //FEATURE - check whether the d/m/y passed as arguments are valid and throw exception?
        LocalDate x = LocalDate.of(year, month, day);
        this.setIssueDate(x);
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
    private static Boolean validateType(String type){
        for(String validType : Document.validDocumentTypes){
            if (validType.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (Document.validateType(type)){
            this.type = type;
        }
        return;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number.length() > 20){
            return;
        }
        this.number = number;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        //max length 30 chars
        if (authority.length() > 30){
            return;
        }
        this.authority = authority;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        //class LocalDate itself ensures the date is valid
        this.issueDate = issueDate;
    }

    public static String[] getValidDocumentTypes() {
        return validDocumentTypes;
    }
}
