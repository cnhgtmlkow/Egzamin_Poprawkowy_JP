package edu.ib;

import java.time.LocalDateTime;

public class DegustacjaAlkoholi extends Usluga  {
    private int minimalnyWiek;
    private int czasTrwania;
    private double cenaZaGodzine;


    public DegustacjaAlkoholi(LocalDateTime dataGodzina, String nazwa, int minimalnyWiek, int czasTrwania, double cenaZaGodzine) {
        super(dataGodzina, nazwa);
        this.minimalnyWiek = minimalnyWiek;
        this.czasTrwania = czasTrwania;
        this.cenaZaGodzine = cenaZaGodzine;
    }



    public int getMinimalnyWiek() {
        return minimalnyWiek;
    }


    @Override
    public double cena(Uzytkownik uzytkownik) {
        return czasTrwania*cenaZaGodzine;
    }




}
