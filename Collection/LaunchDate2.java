import java.time.LocalDate;

public class LaunchDate2 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate birthday = LocalDate.of(2002,7,16);
        System.out.println("Your birthday is : "+birthday);
        System.out.println("Day of the week you were born: "+birthday.getDayOfWeek());
        System.out.println("Month you were born: "+birthday.getMonth());
        System.out.println("Year you were born: "+birthday.getYear());
    }
    
}
