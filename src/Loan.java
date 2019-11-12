import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Loan {
    private Member loanedTo;
    private Item loanedItem;
    private LocalDate loanedDate;
    //Attributes overdue and cost aren't kept as variables as they constantly change.
    //Therefore they are computed every time their "get" is called.

    //Maximum loan is for 15 day, afterwards the item has to be renewed and the price paid.

    public Loan(Member loanedTo, Item loanedItem, LocalDate loanedDate) {
        this.loanedTo = loanedTo;
        this.loanedItem = loanedItem;
        this.loanedDate = loanedDate;
        this.loanedTo.addLoan(this);
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

    public long loanDays(){
        if (this.isOverDue()){
            return ChronoUnit.DAYS.between(loanedDate, LocalDate.now());
        }
        else return 0;
    }

    //isn't kept as variable, but always computed
    public double getCost(){
        if (this.isOverDue()){
            //15 days for regular price + 0.3 euros EXTRA per due day.
            long days_loaned = this.loanDays();
            double cost = 15*loanedItem.getBaseRentPrice() + (days_loaned - 15 ) * (loanedItem.getBaseRentPrice() + 0.3);
            return cost;
        }
        else{
            long days_loaned = this.loanDays();
            return loanedItem.getBaseRentPrice() * days_loaned;
        }
    }

    public void renewLoan(){
        this.setLoanedDate(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanedTo=" + loanedTo.getName() +
                " " + loanedTo.getSurname() +
                ", loaned=" + loanedTo.getNamesOfLoanedItems() +
                ", loanedItem=" + loanedItem.getName() +
                ", loanedDate=" + loanedDate +
                '}';
    }
}
