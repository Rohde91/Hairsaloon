package Gamez4ever;

import java.sql.Time;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TODO få den til at give datoerne på en bestemt uge og ikke den første i hver måned, med 4+ dage.
//TODO få input fra databasen.


public class CalenderFunctions {
    //runable while boolean
    private static boolean runable = true;
    public static String day, year, month, pyear;
    static Scanner scn = new Scanner(System.in);
    static Calendar calndr1 = Calendar.getInstance();

    public static void main(String[] args) {
        System.out.println("""
                Hvilken kalender funktion vil du bruge?\s
                1) ChooseDate (vælg dato og få alle dage i ugen.)
                2) printMonth (print alle månedens dage.)
                3) printYear (vælg en måned og print alle dage i et år.)
                """);
        String choice = scn.next();

        switch (choice) {
            case "1":
                System.out.println("\n--ChooseDate--\nTjek ugedagen. \nIndtast Dag, Måned og År. \nEksempel 05 04 2022");
                chooseDate();
                break;
            case "2":
                System.out.println("\n--PrintMonth--\nIndtast Måned og År.\nEksempel 04 2022");
                printMonth();
            case "3":
                while (runable) {
                    System.out.println("Hvilken måned vil du have alle datoer i?");
                    String y = scn.next();
                    try {
                        if ((Integer.parseInt(y) >= 1 && Integer.parseInt(y) <= 12)) {
                            printYear(y);
                            runable = false;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input");
                    }
                }
        }
    }

    public static void printYear(String y) {

        runable = true;

        calndr1.clear();
        while (runable) {
            System.out.println("\n--PrintYear--\nIndtast År.\nEksempel 2022");
            pyear = scn.next();
            try {
                if ((Integer.parseInt(pyear) >= 1))
                    runable = false;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input!");
            }
        }
        calndr1.set(Calendar.YEAR, Integer.parseInt(pyear));

        int intMonth = Integer.parseInt(y) - 1;
        List<List<String>> yearlist = new ArrayList<>();

        for (int x = 1; x <= 12; x++) {
            List<String> monthlist = new ArrayList<>();
            yearlist.add(monthlist);

            for (int i = 1; i < calndr1.getActualMaximum(Calendar.DAY_OF_MONTH) + 1; i++) {
                calndr1.set(Calendar.DAY_OF_MONTH, i);
                switch (calndr1.get(Calendar.DAY_OF_WEEK)) {
                    case 1 -> { //Sunday
                        calndr1.set(Calendar.HOUR, 0);
                        calndr1.set(Calendar.MINUTE, 0);
                    } //Monday
                    //Saturday
                    //Thursday
                    case 2, 7, 5, 4 -> { //Wednesday
                        calndr1.set(Calendar.HOUR, 9);
                        calndr1.set(Calendar.MINUTE, 0);
                    } //Tuesday
                    case 3, 6 -> { //Friday
                        calndr1.set(Calendar.HOUR, 8);
                        calndr1.set(Calendar.MINUTE, 30);
                    }
                }
                System.out.println(calndr1.getTime());
                monthlist.add(String.valueOf(calndr1.getTime()));
            }
            System.out.println("\n\n");

            //Printer indholdet i den daværende monthlist
            //System.out.println(monthlist);
            calndr1.set(Calendar.MONTH, x);
            System.out.println("\n\n");
        }

        System.out.println(yearlist.get(intMonth));

    }

    public static void printMonth() {

        calndr1.clear();
        String pmonth = scn.next();
        String pyear = scn.next();
        calndr1.set(Calendar.MONTH, Integer.parseInt(pmonth));
        calndr1.set(Calendar.YEAR, Integer.parseInt(pyear));


        for (int i = 1; i < calndr1.getActualMaximum(Calendar.DAY_OF_MONTH) + 1; i++) {
            calndr1.set(Calendar.DAY_OF_MONTH, i);
            System.out.println(calndr1.getTime());
        }
    }


    public static void chooseDate() {

        String day = scn.next();
        String month = scn.next();
        String year = scn.next();

        //Omdanner inputs til LocalDate og bruger denne til at finde uge nummeret.
        LocalDate dt = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int weekNumber = dt.get(woy);
        System.out.println(dt.getDayOfWeek() + " uge: " + weekNumber);

        //Sætter Calendars dato til de valgte datoer, samt ugen.
        calndr1.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        calndr1.set(Calendar.YEAR, Integer.parseInt(year));
        calndr1.set(Calendar.WEEK_OF_YEAR, weekNumber);

        //Printer alle datoer i ugen.
        for (int i = Calendar.MONDAY; i <= Calendar.SATURDAY + 1; i++) {
            calndr1.set(Calendar.DAY_OF_WEEK, i);
            System.out.println(calndr1.getTime());//Returns Date
        }
    }

    // DGH
    public static LocalDate getFirstDayOfWeek(int weekNumber, Locale locale) {
        return LocalDate
                .of(Year.now().getValue(), 2, 1)
                .with(WeekFields.of(locale).getFirstDayOfWeek())
                .with(WeekFields.of(locale).weekOfWeekBasedYear(), weekNumber);
    }

    public static List<LocalDate> getAllDaysOfTheWeek(int weekNumber, Locale locale) {
        LocalDate firstDayOfWeek = getFirstDayOfWeek(weekNumber, locale);
        return IntStream
                .rangeClosed(1, 5)
                .mapToObj(i -> firstDayOfWeek.plusDays(i))
                .collect(Collectors.toList());
    }

    public static int getDayOfWeekIndex(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek-1;
    }

    public static String getDayOfWeek(int indexNumber){
        String weekday = "";
        switch(indexNumber){
            case 1:
                weekday = "MON";
                break;
            case 2:
                weekday = "TUE";
                break;
            case 3:
                weekday = "WED";
            break;
            case 4:
                weekday = "THU";
            break;
            case 5:
                weekday = "FRI";
            break;
        }
        return weekday;
    }

    public static int getTimeIndexDurations(String time){
        int index = 0;
        switch(time){
            case "00:30:00":
                index = 0;
                break;
            case "01:00:00":
                index = 1;
                break;
            case "01:30:00":
                index = 2;
                break;
            case "02:00:00":
                index = 3;
                break;
            case "02:30:00":
                index = 4;
                break;
        }
        return index;
    }

    public static int getTimeIndex(String time){
        HashMap<String, Integer> index = new HashMap<>();
        Time t = new Time(8);
        int minPerHalfHour = 30;
        for (int numberOfHalfHours = 0; numberOfHalfHours <= 16; numberOfHalfHours++) {
            int x;
            x = minPerHalfHour * numberOfHalfHours;
            t.setTime(1000*60*60*7 + 1000*60 * x);
            index.put(t.toString(),numberOfHalfHours+1);
        }
        return index.get(time);
    }
    public static String getTime(int indexNumber){
        HashMap<Integer, String> index = new HashMap<>();
        Time t = new Time(8);
        int minPerHalfHour = 30;
        for (int numberOfHalfHours = 0; numberOfHalfHours <= 16; numberOfHalfHours++) {
            int x;
            x = minPerHalfHour * numberOfHalfHours;
            t.setTime(1000*60*60*7 + 1000*60 * x);
            index.put(numberOfHalfHours+1,t.toString());
        }
        return index.get(indexNumber);
    }

}

