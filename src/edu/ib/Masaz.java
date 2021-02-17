package edu.ib;

import java.time.LocalDateTime;

public class Masaz extends Usluga{
    private double wyskoscZnizki;
    private double cenaBazowa;

    public Masaz(LocalDateTime dataGodzina, String nazwa, double wyskoscZnizki, double cenaBazowa) {
        super(dataGodzina, nazwa);
        this.wyskoscZnizki = wyskoscZnizki;
        this.cenaBazowa = cenaBazowa;
    }

    public void setWyskoscZnizki(double wyskoscZnizki) {
        this.wyskoscZnizki = wyskoscZnizki;
    }

    @Override
    public double cena(Uzytkownik uzytkownik) {
        return cenaBazowa-wyskoscZnizki;
    }


}
