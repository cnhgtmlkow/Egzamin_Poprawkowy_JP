package edu.ib;

import java.time.LocalDateTime;


public abstract class  Usluga implements Comparable<Usluga> {
    private LocalDateTime dataGodzina;
    private String nazwa;

    public Usluga(LocalDateTime dataGodzina, String nazwa) {
        this.dataGodzina = dataGodzina;
        this.nazwa = nazwa;
    }

    public LocalDateTime getDataGodzina() {
        return dataGodzina;
    }

    public String getNazwa() {
        return nazwa;
    }

    public abstract double cena(Uzytkownik uzytkownik);

    @Override
    public int compareTo(Usluga u1){
        boolean k = this.dataGodzina.isAfter( u1.getDataGodzina());
        boolean l = this.dataGodzina.isEqual( u1.getDataGodzina());
        if(k)
            return 1;
        else if(!k)
            return -1;
        else if(l)
            return 0;
        return 0;
    }




}
