package Gamez4ever;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;
import java.time.LocalDateTime;

//TODO få den til at give datoerne på en bestemt uge og ikke den første i hver måned, med 4+ dage.
//TODO få input fra databasen.


class CalendarFunctions {
    //runable while boolean
    private static boolean runable = true;
    public static String day, year, month, pyear;
    static Scanner scn = new Scanner(System.in);
    static Calendar calndr1 = (Calendar) Calendar.getInstance();

    public static void main(String[] args) {
        System.out.println("Hvilken kalender funktion vil du bruge? \n" +
                "1) ChooseDate (vælg dato og få alle dage i ugen.)\n" +
                "2) printMonth (print alle månedens dage.)\n" +
                "3) printYear (vælg en måned og print alle dage i et år.)\n");
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
                        if ((Integer.parseInt(y) >= 1 && Integer.parseInt(y) <= 12) == true) {
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
                if ((Integer.parseInt(pyear) >= 1) == true)
                    runable = false;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input!");
            }
        }
        calndr1.set(Calendar.YEAR, Integer.parseInt(pyear));

        int intMonth = Integer.parseInt(y) - 1;
        List<List<String>> yearlist = new ArrayList<List<String>>();

        for (int x = 1; x <= 12; x++) {
            List<String> monthlist = new ArrayList<>();
            yearlist.add(monthlist);

            for (int i = 1; i < calndr1.getActualMaximum(Calendar.DAY_OF_MONTH) + 1; i++) {
                calndr1.set(Calendar.DAY_OF_MONTH, i);
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
        LocalDate dt = LocalDate.of(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
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
}

