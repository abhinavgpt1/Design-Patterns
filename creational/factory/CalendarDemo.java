// Also, checkout - https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
import java.util.Calendar;
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar); // as user we don't know that its of type java.util.GregorianCalendar
    }
}
/*
 * java.util.GregorianCalendar[time=1700944753620,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Calcutta",offset=19800000,dstSavings=0,useDaylight=false,transitions=7,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2023,MONTH=10,WEEK_OF_YEAR=48,WEEK_OF_MONTH=5,DAY_OF_MONTH=26,DAY_OF_YEAR=330,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=4,AM_PM=0,HOUR=2,HOUR_OF_DAY=2,MINUTE=9,SECOND=13,MILLISECOND=620,ZONE_OFFSET=19800000,DST_OFFSET=0]
 */
