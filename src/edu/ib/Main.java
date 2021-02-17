package edu.ib;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        //Uzytkownicy
        LocalDate d1;
        LocalDate d2;
        String dod1 = "02.04.1995";
        String dod2 = "02.05.1960";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        d1 = LocalDate.parse(dod1, format);
        d2 = LocalDate.parse(dod2, format);

        ArrayList<Usluga> uslugi = new ArrayList<>();
        Uzytkownik uzytkownik = new Uzytkownik("jakikolwiek@com.pl", "Wielki", d1, uslugi);
        Uzytkownik uzytkownik1 = new Uzytkownik("bart@com.pl", "Gross", d2, uslugi);

        //Uslugi
        String dat = "08.05.2020 08:52";
        String dat1 = "08.05.2020 09:43";
        String dat2 = "08.05.2020 10:25";
        String dat3= "08.05.2021 10:30";

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        LocalDateTime date1;
        LocalDateTime date2;
        LocalDateTime date3;
        LocalDateTime date4;

        date1 = LocalDateTime.parse(dat, format1);
        date2 = LocalDateTime.parse(dat1, format1);
        date3 = LocalDateTime.parse(dat2, format1);
        date4 = LocalDateTime.parse(dat3, format1);



        Usluga masaz = new Masaz(date1, "masaz", 0, 500);
        Usluga masaz1 = new Masaz(date2, "masaz ubozszy", 0, 400);
        Usluga degustacja = new DegustacjaAlkoholi(date2, "degustacja", 18, 2, 100);
        Usluga degustacja1 = new DegustacjaAlkoholi(date4, "degustacja specjalna", 40, 48, 100);

        //Uztykownik pierwszy
        System.out.println(uzytkownik.getLogin());
        try{
            uzytkownik.dodaj(masaz);
            uzytkownik.dodaj(degustacja);
            uzytkownik.dodaj(degustacja1);
            uzytkownik.dodaj(masaz1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        uzytkownik.wyswietl();
        System.out.println("Oto koszty: "+uzytkownik.koszty(uzytkownik));
        uzytkownik.historia();

        //Uztykownik drugi
        System.out.println(uzytkownik1.getLogin());
        try{
            uzytkownik1.dodaj(masaz);
            uzytkownik1.dodaj(degustacja);
            uzytkownik1.dodaj(degustacja1);
            uzytkownik1.dodaj(masaz1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }
        uzytkownik1.wyswietl();
        System.out.println("Oto koszty: "+uzytkownik1.koszty(uzytkownik1));
        uzytkownik1.historia();
    }
}
