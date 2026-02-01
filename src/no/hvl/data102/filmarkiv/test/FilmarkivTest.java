package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilmarkivTest {

    @Test
    void leggTilFilm() {
        Filmarkiv arkiv = new Filmarkiv(2);
        Film f1 = new Film(101, "Prod1", "Tittel1", 2020, Sjanger.ACTION, "Selskap1");
        arkiv.leggTilFilm(f1);

        assertEquals(1, arkiv.antall());
        assertEquals(f1, arkiv.finnFilm(101));
    }

    @Test
    void finnFilm() {
        Filmarkiv arkiv = new Filmarkiv(2);

        Film f1 = new Film(100, "Prod1", "Tittel1", 2020, Sjanger.ACTION, "Selskap1");
        arkiv.leggTilFilm(f1);

        Film funnet = arkiv.finnFilm(100);

        assertNotNull(funnet);
        assertEquals(100, funnet.getFilmnr());
        assertEquals("Tittel1", funnet.getTittel());

    }

    @Test
    void slettFilm() {
        Filmarkiv arkiv = new Filmarkiv(2);

        Film f1 = new Film(101, "Prod2", "Tittel2", 2023, Sjanger.ANIMASJON, "Selskap1");
        Film f2 = new Film(102, "Prod3", "Tittel3", 2019, Sjanger.KOMEDIE, "Selskap1");

        arkiv.leggTilFilm(f1);
        arkiv.leggTilFilm(f2);

        boolean slettet = arkiv.slettFilm(101);

        assertTrue(slettet);
        assertEquals(1, arkiv.antall());
        assertNull(arkiv.finnFilm(101));
        assertNotNull(arkiv.finnFilm(102));
    }

    @Test
    void soekTittel() {
        Filmarkiv arkiv = new Filmarkiv(2);

        Film f1 = new Film(104, "Prod5", "Star Wars", 1977, Sjanger.DRAMA, "Selskap1");
        Film f2 = new Film(102, "Prod3", "Star Trek", 1979, Sjanger.KOMEDIE, "Selskap1");
        Film f3 = new Film(101, "Prod1", "Barbie", 2020, Sjanger.ACTION, "Selskap1");

        arkiv.leggTilFilm(f1);
        arkiv.leggTilFilm(f2);
        arkiv.leggTilFilm(f3);

        Film[] resultat = arkiv.soekTittel("Star");

        assertEquals(2, resultat.length);
        assertEquals("Star Wars", resultat[0].getTittel());
        assertEquals("Star Trek", resultat[1].getTittel());

    }

    @Test
    void soekProdusent(){
        Filmarkiv arkiv = new Filmarkiv(2);

        Film f1 = new Film(104, "LucasFilm", "Star Wars", 1977, Sjanger.DRAMA, "LucasFilm");
        Film f2 = new Film(102, "Prod3", "Star Trek", 1979, Sjanger.KOMEDIE, "Paramount");
        Film f3 = new Film(101, "Prod1", "Barbie", 2020, Sjanger.ACTION, "WB");

        arkiv.leggTilFilm(f1);
        arkiv.leggTilFilm(f2);
        arkiv.leggTilFilm(f3);

        Film[] resultat = arkiv.soekProdusent("Lucas");

        assertEquals(1, resultat.length);
        assertEquals("LucasFilm", resultat[0].getProdusent());
    }
    @Test
    void antall(){
        Filmarkiv arkiv = new Filmarkiv(5);

        Film f1 = new Film(101, "Prod1", "Film1", 2020, Sjanger.ACTION, "Selskap1");
        Film f2 = new Film(102, "Prod2", "Film2", 2021, Sjanger.DRAMA, "Selskap2");
        Film f3 = new Film(103, "Prod3", "Film3", 2019, Sjanger.ACTION, "Selskap3");

        arkiv.leggTilFilm(f1);
        arkiv.leggTilFilm(f2);
        arkiv.leggTilFilm(f3);

        assertEquals(2, arkiv.antall(Sjanger.ACTION));
        assertEquals(1, arkiv.antall(Sjanger.DRAMA));
        assertEquals(0, arkiv.antall(Sjanger.ANIMASJON));
    }
}