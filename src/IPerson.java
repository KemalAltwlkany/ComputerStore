import java.time.LocalDate;
import java.time.Period;

interface IPerson {
    //modifier public is redundant

    //Checks whether the age argument matches the birthday argument. Uses LocalDate.now() to test
    //Returns true if the age matches the years passed between birthDate and today.
    public static boolean ValidateAge(int age, LocalDate birthDate){
        Period per = Period.between(birthDate, LocalDate.now());
        if (age == per.getYears()){
            return true;
        }
        return false;
    }

    String toString();

    String joinedFor();

    String joinedSince();

}
