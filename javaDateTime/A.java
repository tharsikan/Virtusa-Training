
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

class A{

    static volatile SimpleDateFormat F = new SimpleDateFormat("yyyyMMdd");

    public static Date parseDate(String sDate) {
        SimpleDateFormat F = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = F.parse(sDate); //throws a NumberFormatException
        } catch (ParseException ex) {
           System.out.println(ex);
        }
        return date;
    }

    public static void main(String[] args) {
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date : " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        int nano = currentTime.getNano();

        System.out.println("Month: " + month + " day: " + day + " seconds: " + seconds + " nano: " + nano);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        //12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        //22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);
        
        //parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);

        System.out.println("");
        // Get the current date and time
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
        System.out.println("date1: " + zonedDateTime);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("CurrentZone: " + currentZone);
        System.out.println("");
        
        //Get the current date
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        //add 1 week to the current date
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Next week: " + nextWeek);

        //add 1 month to the current date
        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + nextMonth);

        //add 1 year to the current date
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Next year: " + nextYear);

        //add 10 years to the current date
        LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
        System.out.println("Date after ten year: " + nextDecade);
        System.out.println("");
//      
//      With Java 8, two specialized classes are introduced to deal with the time differences.
//
//Period - It deals with date based amount of time.
//
//Duration - It deals with time based amount of time.
        //Get the current date working with Periods
        LocalDate datePeriod = LocalDate.now();
        System.out.println("Current date: " + datePeriod);

        //add 1 month to the current date
        LocalDate datePeriod2 = datePeriod.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + datePeriod2);

        Period period = Period.between(datePeriod2, datePeriod);
        System.out.println("Period: " + period);

        //work with durations
        LocalTime time1 = LocalTime.now();
        Duration twoHours = Duration.ofHours(2);

        LocalTime time2 = time1.plus(twoHours);
        Duration duration = Duration.between(time1, time2);

        System.out.println("Duration: " + duration);

//      TemporalAdjuster is used to perform the date mathematics.
//      For example, get the "Second Saturday of the Month" or "Next Tuesday".
//      Let us see them in action.
//      
        System.out.println("");
//Get the current date
        LocalDate dateArithmatic = LocalDate.now();
        System.out.println("Current date: " + dateArithmatic);

        //get the next tuesday
        LocalDate nextTuesday = dateArithmatic.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("Next Tuesday on : " + nextTuesday);

        //get the second saturday of next month
        LocalDate firstInYear = LocalDate.of(dateArithmatic.getYear(), dateArithmatic.getMonth(), 1);
        LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
                .with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("Second Saturday on : " + secondSaturday);

        //Sql date time
        java.util.Date javaDate = new java.util.Date();
        long javaTime = javaDate.getTime();
        System.out.println("\n\nThe Java Date is: " + javaDate.toString());

        java.sql.Date sqlDate = new java.sql.Date(javaTime);
        System.out.println("The SQL DATE is: " + sqlDate.toString());

        java.sql.Time sqlTime = new java.sql.Time(javaTime);
        System.out.println("The SQL TIME is: " + sqlTime.toString());

        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(javaTime);
        System.out.println("The SQL TIMESTAMP is: " + sqlTimestamp.toString());
    }
}
