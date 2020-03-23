import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Date1{
    public static void main(String[] args) {
        // LocalDate today = LocalDate.now();
        // LocalDate anotherDay = today.plusDays(56);
        // System.out.println(anotherDay);
        // LocalDateTime birthdDate = LocalDateTime.of(1993,9,02,3,34);
        // System.out.println(birthdDate.getDayOfWeek());
        // Period p = Period.between(today, birthdDate);
        // System.out.println(p);
        
        
        // Year y = Year.of(Integer.parseInt(args[0]));
        // if(y.isLeap()) System.out.println("leep");
        // else System.out.println("nop!!");
        
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZoneId aZoneId = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zdt = ZonedDateTime.now(aZoneId);
        
        // ZonedDateTime atAmericaDateTime = birthdDate.atZone(aZoneId);
        
        String zonString = zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        System.out.println(zonString);


    }
}