package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmer;
    private int antall;



    public Filmarkiv(int startKapasitet){
        filmer = new Film[startKapasitet];
        antall = 0;
    }
    @Override
    public void leggTilFilm(Film nyFilm){

        if(antall == filmer.length){
            utvid();
        }
        filmer[antall] = nyFilm;
        antall++;
    }

    private void utvid(){
        Film[] nyTabell = new Film[filmer.length * 2];

        for(int i = 0; i < antall; i++){
            nyTabell[i] = filmer[i];
        }
        filmer = nyTabell;
    }

    @Override
    public Film finnFilm(int filmnr){
        for(int i = 0; i < antall; i++){
            if(filmer[i].getFilmnr() == filmnr){
                return filmer[i];
            }
        }
        return null;
    }

    @Override
    public boolean slettFilm(int filmnr){

        int slettIndeks = -1;

        if(antall == 0){
            return false;
        }
        for(int i = 0; i < antall; i++){
            if(filmer[i].getFilmnr() == filmnr){
                slettIndeks = i;
                break;
            }
        }
        if(slettIndeks == -1){
            return false;
        }

        for(int i = slettIndeks; i < antall - 1; i++){
            filmer[i] = filmer[i + 1];
        }

        filmer[antall - 1] = null;
        antall--;

        return true;

    }

    @Override
    public int antall(){
        return antall;
    }

    @Override
    public Film[] soekTittel(String delstreng){
        Film[] treff = new Film[antall];
        int teller = 0;

        for(int i = 0; i < antall; i++){
            if(filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                treff[teller] = filmer[i];
                teller++;
            }
        }
        Film[] resultat = new Film[teller];
        for(int i = 0; i < teller; i++){
            resultat[i] = treff[i];
        }

        return resultat;
    }

    @Override
    public Film[] soekProdusent(String delstreng){
        Film[] treff = new Film[antall];
        int teller = 0;

        for(int i = 0; i < antall; i++) {
            if(filmer[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())){
                treff[teller] = filmer[i];
                teller++;
            }
        }
        Film[] resultat = new Film[teller];
        for(int i = 0; i < teller; i++){
            resultat[i] = treff[i];
        }
        return resultat;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getSjanger() == sjanger) {
                teller++;
            }
        }
        return teller;
    }


}
