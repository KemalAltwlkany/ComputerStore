import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Loan implements Comparable<Loan>{
    private Member loanedTo;
    private Item loanedItem;
    private LocalDate loanedDate;
    //Attributes overdue and cost aren't kept as variables as they constantly change.
    //Therefore they are computed every time their "get" is called.
    //However, if they were implemented, they'd look like:
    //private double cost;
    //private boolean overdue;


    //Maximum loan is for 15 day, afterwards the item has to be renewed and the price paid.
    //Every additional day carries an extra 0.3 euro fee + baseRentPrice

    public Loan(Member loanedTo, Item loanedItem, LocalDate loanedDate) {
        this.loanedTo = loanedTo;
        this.loanedItem = loanedItem;
        this.loanedDate = loanedDate;
    }

    public Member getLoanedTo() {
        return loanedTo;
    }

    public void setLoanedTo(Member loanedTo) {
        this.loanedTo = loanedTo;
    }

    public Item getLoanedItem() {
        return loanedItem;
    }

    public void setLoanedItem(Item loanedItem) {
        this.loanedItem = loanedItem;
    }

    public LocalDate getLoanedDate() {
        return loanedDate;
    }

    public void setLoanedDate(LocalDate loanedDate) {
        this.loanedDate = loanedDate;
    }

    //Loan can last up to 15 days.
    public boolean isOverDue(){
        long p = ChronoUnit.DAYS.between(loanedDate, LocalDate.now());
        if (p > 15){
            return true;
        }
        return false;
    }

    //returns total number of days the item has been loaned
    public long loanDays(){
        return ChronoUnit.DAYS.between(loanedDate, LocalDate.now());
    }

    //returns total number of days the item has been overdue
    public long overDueDays(){
        if (this.isOverDue()){
            return ChronoUnit.DAYS.between(loanedDate, LocalDate.now())-15;
        }
        else return 0;
    }

    //isn't kept as variable, but always computed
    public double getCost(){
        if (this.isOverDue()){
            //15 days for regular price + 0.3 euros EXTRA per due day.
            double cost = 15*loanedItem.getBaseRentPrice() + overDueDays()*(loanedItem.getBaseRentPrice() + 0.3);
            return cost;
        }
        else{
            return loanedItem.getBaseRentPrice()*loanDays();
        }
    }

    public void renewLoan(){
        this.setLoanedDate(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanedTo=" + loanedTo.getName() +
                ", " + loanedTo.getSurname() +
                ", loanedItem=" + loanedItem.getClass().getSimpleName() +
                ", loanedDate=" + loanedDate +
                '}';
    }

    public String verboseToString(){
        return "Loan{" +
                "loanedTo=" + loanedTo.getName() +
                ", " + loanedTo.getSurname() +
                ", loanedItem=" + loanedItem +
                ", loanedDate=" + loanedDate +
                '}';
    }

    //Update 27.11.2019.
    //We define a loan to be less than an other loan if it's been created after.
    //Required to sort the loans by following logic: FIFO
    //(first to loan, first in order)
    // e.g. 10.10.2018. < 11.11.2019.
    @Override
    public int compareTo(Loan loan) {
        LocalDate date1 = this.getLoanedDate();
        LocalDate date2 = loan.getLoanedDate();
        if (date1.isBefore(date2)){
            return -1;
        }
        if (date1.isAfter(date2)){
            return 1;
        }
        return 0;
    }

    //Two loans are equal if they are created on the same day, and involve the same people and items
    @Override
    public boolean equals(Object obj) {
        //If the object is compared with itself it is obviously equal to itself
        if ( obj == this){
            return true;
        }

        //Check whether obj is an instance of class Loan
        if (!(obj instanceof  Loan)){
            return false;
        }

        //Since now it obviously is an instance of class Loan, we typecast it to Loan
        Loan l2 = (Loan) obj;

        if ( l2.getLoanedTo().equals(this.getLoanedTo()) && l2.getLoanedItem().equals(this.getLoanedItem()) && l2.getLoanedDate().equals(this.getLoanedDate()) ){
            return true;
        }
        return  false;

    }
}
