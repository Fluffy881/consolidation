package fr.dawan.apitime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class App {
    public static void main(String[] args) {

        System.out.println("-----------java.util.date---------");

        Date date = new Date();
        System.out.println("ajd : " + date);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy/ hh/mm/ss");
        System.out.println("ajd formaté: " + sdf.format(date));

        sdf = new SimpleDateFormat("dd/MM/yyy");
        try {
            Date date1 = sdf.parse("17/07/2015"); // parse creer un objet de type date a partir d une chaine de caractere
            Date date2 = sdf.parse("15/10/2001");

            if (date1.after(date2)){
                System.out.println("date1 after date2");
            } else if (date1.before(date2)) {
                System.out.println("date1 before date2");
            } else if (date1.equals(date2)) {
                System.out.println("date1 equals date2");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-----------java.time depuis java 8 ---------");

        System.out.println("localDate.now : " + LocalDate.now());
        System.out.println("localDate.getmonth : " + LocalDate.now().getMonth());
        System.out.println("localDate.getmonthvalue : " + LocalDate.now().getMonthValue());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(LocalDate.now().format(dtf));
        System.out.println(LocalDate.of(2004,11,05));
        System.out.println(LocalDateTime.now());

        LocalDateTime in4Days = LocalDateTime.now().plusDays(4);
        System.out.println(in4Days.format(dtf));
        System.out.println(in4Days.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        //fuseau horaire par defaut du systeme
        ZoneId fuseau = ZoneId.systemDefault();
        System.out.println("fuseau : " + fuseau);

        ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(fuseau);
        System.out.println("now here : "+ zonedDateTime);
        System.out.println("now here formated : "+ zonedDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        fuseau = ZoneId.of("UTC");
        ZonedDateTime zonedDateTimeUTC = ZonedDateTime.now().withZoneSameInstant(fuseau);
        System.out.println("now UTC : " + zonedDateTimeUTC.format(DateTimeFormatter.ofPattern("HH:mm:ss")));


        System.out.println("-----------INSTANT ---------");

        System.out.println("Instant.EPOCH : " + Instant.EPOCH);
        System.out.println("Instant.EPOCH : " + Instant.now());

        Instant parsedInstant = Instant.parse("2023-01-15T12:30:45g");
        System.out.println("parsedInstant : " + parsedInstant);
    }
}
