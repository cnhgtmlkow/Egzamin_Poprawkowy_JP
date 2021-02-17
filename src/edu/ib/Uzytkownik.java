package edu.ib;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Uzytkownik {
    private String email;
    private String login;
    private LocalDate dataURodzenia;
    private ArrayList<Usluga> listaRezerwacji;

    public Uzytkownik(String email, String login, LocalDate dataURodzenia, ArrayList<Usluga> listaRezerwacji) {
        this.email = email;
        this.login = login;
        this.dataURodzenia = dataURodzenia;
        this.listaRezerwacji = new ArrayList<Usluga>(listaRezerwacji);
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public LocalDate getDataURodzenia() {
        return dataURodzenia;
    }

    public ArrayList<Usluga> getListaRezerwacji() {
        return listaRezerwacji;
    }

    public void dodaj( Usluga usluga) throws Exception{


        boolean l = true;
        int q =  dataURodzenia.getYear();
        int wiek = LocalDate.now().getYear()-q;
        if(usluga instanceof DegustacjaAlkoholi)
            if(((DegustacjaAlkoholi) usluga).getMinimalnyWiek()>wiek)
                l = false;


        boolean k = false;
        for(int i = 0; i<listaRezerwacji.size(); i++){
            if(listaRezerwacji.get(i).getDataGodzina().equals(usluga.getDataGodzina())) {
                k = true;
            }
        }

        if (k)
            throw new Exception("Termin zajety");
        if(!k&&l)
            listaRezerwacji.add(usluga);
        if(!l)
            throw new Exception("Zbyt niski wiek");

    }

    public void wyswietl(){

        System.out.println("*** Wyświetlanie ***");
        System.out.println("Oczekujace:");
        for(int i = 0; i<listaRezerwacji.size(); i++){

            if(listaRezerwacji.get(i).getDataGodzina().isAfter(LocalDateTime.now())){
                System.out.println(listaRezerwacji.get(i).getNazwa());

            }
        }
        System.out.println("Odbyte:");
        for(int i = 0; i<listaRezerwacji.size(); i++){

            if(listaRezerwacji.get(i).getDataGodzina().isBefore(LocalDateTime.now())){
                System.out.println(listaRezerwacji.get(i).getNazwa());

            }
        }
        System.out.println("******");
    }
    public double koszty(Uzytkownik uzytkownik){
        double a = 0;
        for(int i = 0; i<listaRezerwacji.size(); i++){
            a+= listaRezerwacji.get(i).cena(uzytkownik);
        }
        return a;
    }

    public void historia(){
        ArrayList<Usluga> hist = new ArrayList<>(listaRezerwacji);
        Collections.sort(hist);
        System.out.println("** Historia **");
        for(int i = 0; i<listaRezerwacji.size(); i++){
            System.out.println( hist.get(i).getDataGodzina()+" "+hist.get(i).getNazwa());
        }
        System.out.println("****");
    }


}
