/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alessandro
 */
public class FactoryArticolo {

    private static FactoryArticolo singleton;

    private FactoryArticolo() {
    }

    public static FactoryArticolo getInstance() {
        if (singleton == null) {
            singleton = new FactoryArticolo();
        }
        return singleton;
    }

    public List<Articolo> getArticoli() {
        List<Articolo> articoli = new ArrayList<>();

        Articolo primo = new Articolo();
        primo.setIdArticolo(1);
        primo.setTitolo("Divina Commedia");
        primo.setTesto("Nel mezzo del cammin di nostra vita...");
        primo.setData("2019-05-06");
        primo.setStato("RIFIUTATO");
        List<Utente> ale = new ArrayList<>();
        ale.add(FactoryUtente.getInstance().getUtenteById(1));
        ale.add(FactoryUtente.getInstance().getUtenteById(2));
        primo.setAutore(ale);
        articoli.add(primo);

        Articolo terzo = new Articolo();
        terzo.setIdArticolo(3);
        terzo.setTitolo("I Promessi Sposi");
        terzo.setTesto("Quel ramo del lago di Como...");
        terzo.setData("2019-05-04");
        terzo.setStato("APERTO");
        List<Utente> rob = new ArrayList<>();
        rob.add(FactoryUtente.getInstance().getUtenteById(2));
        terzo.setAutore(rob);
        articoli.add(terzo);

        return articoli;
    }
    
    public List<Articolo> getArticoliOrdinati() {
        List<Articolo> articoli = new ArrayList<>();

        Articolo terzo = new Articolo();
        terzo.setIdArticolo(3);
        terzo.setTitolo("I Promessi Sposi");
        terzo.setTesto("Quel ramo del lago di Como...");
        terzo.setData("2019-05-04");
        terzo.setStato("APERTO");
        List<Utente> rob = new ArrayList<>();
        rob.add(FactoryUtente.getInstance().getUtenteById(2));
        terzo.setAutore(rob);
        articoli.add(terzo);

        Articolo primo = new Articolo();
        primo.setIdArticolo(1);
        primo.setTitolo("Divina Commedia");
        primo.setTesto("Nel mezzo del cammin di nostra vita...");
        primo.setData("2019-05-06");
        primo.setStato("APERTO");
        List<Utente> ale = new ArrayList<>();
        ale.add(FactoryUtente.getInstance().getUtenteById(1));
        ale.add(FactoryUtente.getInstance().getUtenteById(2));
        primo.setAutore(ale);
        articoli.add(primo);

        return articoli;
    }

    public Articolo getArticoloById(int id) {
        List<Articolo> allArticoli = this.getArticoliOrdinati();
        for (Articolo a : allArticoli) {
            if (a.getIdArticolo() == id) {
                return a;
            }
        }
        return null;
    }
    
    public List<Articolo> getArticoliByAutore(Utente a) {
        List<Articolo> articoliUtente = new ArrayList<>();
        List<Articolo> allArticoli = this.getArticoliOrdinati();

        for (Articolo ar : allArticoli) {
            for (Utente u : ar.getAutore()) {
                if (u.equals(a)) {
                    articoliUtente.add(ar);
                }
            }
        }
        return articoliUtente;
    }
    
        public List<Articolo> getArticoloByCategoria(Categoria c) {
        List<Articolo> allArticoli = this.getArticoliOrdinati();
        List<Articolo> articoliCat = new ArrayList<>();

        for (Articolo ar : allArticoli) {
            for (Categoria cat : ar.getCategoria()) {
                if (cat.equals(c)) {
                    articoliCat.add(ar);
                }
            }
        }
        return articoliCat;
    }
    
    public List<Articolo> getArticoliDaValutare(Utente a) {
        List<Articolo> articoliDaValutare = new ArrayList<>();
        List<Articolo> allArticoli = this.getArticoliOrdinati();
        boolean presente;

        for (Articolo ar : allArticoli) {
            presente = false;
            for (Utente u : ar.getAutore()) {
                if (u.equals(a)) {
                    presente = true;
                }
            }
            if (presente == false) {
                articoliDaValutare.add(ar);
            }
        }
        return articoliDaValutare;
    }
}
