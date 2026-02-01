package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

    private LinearNode<Film> start;
    private int antall;

    public Filmarkiv2() {
        start = null;
        antall = 0;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> node = new LinearNode<>(nyFilm);
        node.setNeste(start);
        start = node;
        antall++;
    }

    @Override
    public Film finnFilm(int filmnr) {
        LinearNode<Film> node = start;

        while (node != null) {
            if (node.getData().getFilmnr() == filmnr) {
                return node.getData();
            }
            node = node.getNeste();
        }
        return null;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> node = start;
        LinearNode<Film> forrige = null;

        while (node != null) {
            if (node.getData().getFilmnr() == filmnr) {

                if (forrige == null) {
                    start = node.getNeste();
                } else {
                    forrige.setNeste(node.getNeste());
                }

                antall--;
                return true;
            }

            forrige = node;
            node = node.getNeste();
        }

        return false;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        return filtrer(f -> f.getTittel().toLowerCase().contains(delstreng.toLowerCase()));
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        return filtrer(f -> f.getProdusent().toLowerCase().contains(delstreng.toLowerCase()));
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        LinearNode<Film> node = start;

        while (node != null) {
            if (node.getData().getSjanger() == sjanger) {
                teller++;
            }
            node = node.getNeste();
        }

        return teller;
    }


    private Film[] filtrer(java.util.function.Predicate<Film> pred) {
        Film[] temp = new Film[antall];
        int teller = 0;

        LinearNode<Film> node = start;
        while (node != null) {
            if (pred.test(node.getData())) {
                temp[teller++] = node.getData();
            }
            node = node.getNeste();
        }

        Film[] resultat = new Film[teller];
        for (int i = 0; i < teller; i++) {
            resultat[i] = temp[i];
        }

        return resultat;
    }
}
