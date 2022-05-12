import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dateTime{
    public static void main(String[] args){

        LocalDate date = LocalDate.now();
        System.out.println("Today: " + date);
    
        LocalDate yesterday = date.minusDays(1);    
        LocalDate tomorrow = date.plusDays(1);    
        System.out.println("Yesterday: " + yesterday);    
        System.out.println("Tomorrow: " + tomorrow);    

        LocalDate date1 = LocalDate.of(2022, 03, 10);    
        System.out.println("Is " + date1 + " is leap year: " + date1.isLeapYear());

        LocalTime time = LocalTime.now();
        System.out.println("Current Time: " + time);

        LocalTime time2 = time.minusHours(1);  
        LocalTime time3 = time.minusMinutes(30); 

        System.out.println("Minus One Hour: " + time2);
        System.out.println("Minus Thirty Minutes: " + time3);

        LocalDateTime now = LocalDateTime.now();  
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = now.format(formatter);  
        System.out.println("Formatted Date and Time: " + formatDateTime);  
        
    }
}