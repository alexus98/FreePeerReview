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

        Articolo primoArticolo = new Articolo();
        primoArticolo.setIdArticolo(1);
        primoArticolo.setTitolo("Articolo di Roberto e Nicola");
        primoArticolo.setTesto("Testo articolo di Roberto e Nicola");
        primoArticolo.setData("2019-05-06-");
        primoArticolo.setStato("APERTO");
        List<Categoria> categoriePrimoArt =  new ArrayList<>();
        categoriePrimoArt.add(FactoryCategoria.getInstance().getCategoriaById(3));
        categoriePrimoArt.add(FactoryCategoria.getInstance().getCategoriaById(4));
        primoArticolo.setCategoria(categoriePrimoArt);
        List<Utente> autoriPrimoArt = new ArrayList<>();
        autoriPrimoArt.add(FactoryUtente.getInstance().getUtenteById(2));
        autoriPrimoArt.add(FactoryUtente.getInstance().getUtenteById(3));
        primoArticolo.setAutore(autoriPrimoArt);
        articoli.add(primoArticolo);

        Articolo secondoArticolo = new Articolo();
        secondoArticolo.setIdArticolo(2);
        secondoArticolo.setTitolo("Articolo di Roberto");
        secondoArticolo.setTesto("Testo articolo di Roberto");
        secondoArticolo.setData("2019-05-04");
        secondoArticolo.setStato("APERTO");
        List<Categoria> categorieSecondoArt =  new ArrayList<>();
        categorieSecondoArt.add(FactoryCategoria.getInstance().getCategoriaById(1));
        categorieSecondoArt.add(FactoryCategoria.getInstance().getCategoriaById(2));
        secondoArticolo.setCategoria(categorieSecondoArt);
        List<Utente> autoriSecondoArt = new ArrayList<>();
        autoriSecondoArt.add(FactoryUtente.getInstance().getUtenteById(2));
        secondoArticolo.setAutore(autoriSecondoArt);
        articoli.add(secondoArticolo);

        Articolo terzoArticolo = new Articolo();
        terzoArticolo.setIdArticolo(3);
        terzoArticolo.setTitolo("Articolo di Nicola");
        terzoArticolo.setTesto("Testo articolo di Nicola");
        terzoArticolo.setData("2019-05-10");
        terzoArticolo.setStato("VALUTAZIONE");
        List<Categoria> categorieTerzoArt =  new ArrayList<>();
        categorieTerzoArt.add(FactoryCategoria.getInstance().getCategoriaById(5));
        categorieTerzoArt.add(FactoryCategoria.getInstance().getCategoriaById(6));
        terzoArticolo.setCategoria(categorieTerzoArt);
        List<Utente> autoriTerzoArt = new ArrayList<>();
        autoriTerzoArt.add(FactoryUtente.getInstance().getUtenteById(3));
        terzoArticolo.setAutore(autoriTerzoArt);
        articoli.add(terzoArticolo);
        
        return articoli;
    }
    
    public List<Articolo> getArticoliOrdinati() {
        List<Articolo> articoli = new ArrayList<>();

        Articolo secondoArticolo = new Articolo();
        secondoArticolo.setIdArticolo(2);
        secondoArticolo.setTitolo("Articolo di Roberto");
        secondoArticolo.setTesto("Testo articolo di Roberto");
        secondoArticolo.setData("2019-05-04");
        secondoArticolo.setStato("APERTO");
        List<Categoria> categorieSecondoArt =  new ArrayList<>();
        categorieSecondoArt.add(FactoryCategoria.getInstance().getCategoriaById(1));
        categorieSecondoArt.add(FactoryCategoria.getInstance().getCategoriaById(2));
        secondoArticolo.setCategoria(categorieSecondoArt);
        List<Utente> autoriSecondoArt = new ArrayList<>();
        autoriSecondoArt.add(FactoryUtente.getInstance().getUtenteById(2));
        secondoArticolo.setAutore(autoriSecondoArt);
        articoli.add(secondoArticolo);
        
        Articolo primoArticolo = new Articolo();
        primoArticolo.setIdArticolo(1);
        primoArticolo.setTitolo("Articolo di Roberto e Nicola");
        primoArticolo.setTesto("Testo articolo di Roberto e Nicola");
        primoArticolo.setData("2019-05-06");
        primoArticolo.setStato("APERTO");
        List<Categoria> categoriePrimoArt =  new ArrayList<>();
        categoriePrimoArt.add(FactoryCategoria.getInstance().getCategoriaById(3));
        categoriePrimoArt.add(FactoryCategoria.getInstance().getCategoriaById(4));
        primoArticolo.setCategoria(categoriePrimoArt);
        List<Utente> autoriPrimoArt = new ArrayList<>();
        autoriPrimoArt.add(FactoryUtente.getInstance().getUtenteById(2));
        autoriPrimoArt.add(FactoryUtente.getInstance().getUtenteById(3));
        primoArticolo.setAutore(autoriPrimoArt);
        articoli.add(primoArticolo);

        
        Articolo terzoArticolo = new Articolo();
        terzoArticolo.setIdArticolo(3);
        terzoArticolo.setTitolo("Articolo di Nicola");
        terzoArticolo.setTesto("Testo articolo di Nicola");
        terzoArticolo.setData("2019-05-10");
        terzoArticolo.setStato("APERTO");
        List<Categoria> categorieTerzoArt =  new ArrayList<>();
        categorieTerzoArt.add(FactoryCategoria.getInstance().getCategoriaById(5));
        categorieTerzoArt.add(FactoryCategoria.getInstance().getCategoriaById(6));
        terzoArticolo.setCategoria(categorieTerzoArt);
        List<Utente> autoriTerzoArt = new ArrayList<>();
        autoriTerzoArt.add(FactoryUtente.getInstance().getUtenteById(3));
        terzoArticolo.setAutore(autoriTerzoArt);
        articoli.add(terzoArticolo);

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
