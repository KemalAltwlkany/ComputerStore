import java.time.LocalDate;
import java.time.Period;

interface IPerson {
    //modifier public is redundant

    String toString();

    String joinedFor();

    String getName();

    String getSurname();

    LocalDate getBirthDate();

    LocalDate getJoiningDate();

    int getAge();
}
