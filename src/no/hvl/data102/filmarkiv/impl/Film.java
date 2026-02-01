package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
    private int filmnr;
    private String produsent;
    private String tittel;
    private int lansering;
    private Sjanger sjanger;
    private String filmselskap;

    public Film(){
    }

    public Film(int filmnr, String produsent, String tittel, int lansering, Sjanger sjanger, String filmselskap) {
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.lansering = lansering;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public String getProdusent() {
        return produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public int getLansering() {
        return lansering;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public void setLansering(int lansering) {
        this.lansering = lansering;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmnr == film.filmnr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmnr);
    }
}
