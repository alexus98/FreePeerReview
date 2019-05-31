/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alessandro
 */
public class Articolo {

    private String titolo;
    private List<Utente> autore;
    private List<Categoria> categoria;
    private List<Valutazione> valutazioni;
    private String immagine;
    private String testo;
    private String data;
    private int idArticolo;
    private Stato stato;

    /**
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * @param titolo the titolo to set
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * @return the autore
     */
    public List<Utente> getAutore() {
        return autore;
    }

    /**
     * @param autore the autore to set
     */
    public void setAutore(List<Utente> autore) {
        this.autore = autore;
    }

    /**
     * @return the categoria
     */
    public List<Categoria> getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the immagine
     */
    public String getImmagine() {
        return immagine;
    }

    /**
     * @param immagine the immagine to set
     */
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    /**
     * @return the testo
     */
    public String getTesto() {
        return testo;
    }

    /**
     * @param testo the testo to set
     */
    public void setTesto(String testo) {
        this.testo = testo;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    public String getDataFormatoClassico() {
        String parti[] = data.split("-");
        String giorno = parti[0];
        String mese = parti[1];
        String anno = parti[2];
        return anno.concat("-").concat(mese).concat("-").concat(giorno);
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the idArticolo
     */
    public int getIdArticolo() {
        return idArticolo;
    }

    /**
     * @param idArticolo the idArticolo to set
     */
    public void setIdArticolo(int idArticolo) {
        this.idArticolo = idArticolo;
    }

    /**
     * @return the stato
     */
    public Stato getStato() {
        return stato;
    }

    /**
     * @param stato the stato to set
     */
    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public Boolean isCategoria(int idCategoria) {
        for (Categoria c : this.getCategoria()) {
            if (c.getIdCategoria() == idCategoria) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the valutazioni
     */
    public List<Valutazione> getValutazioni() {
        return valutazioni;
    }

    /**
     * @param valutazioni the valutazioni to set
     */
    public void setValutazioni(List<Valutazione> valutazioni) {
        this.valutazioni = valutazioni;
    }

    public boolean isPresenteAutore(int id) {
        for (Utente u : this.getAutore()) {
            if (u.getIdUtente() == id) {
                return true;
            }
        }

        return false;
        /*select * from autoriArticoli where idArticolo=? and idUtente=?*/
    }

    public void addAutore(Utente a) {
        for (int i = 0; i <= this.getAutore().size(); i++) {
            if (i == this.getAutore().size()) {
                this.getAutore().add(a);
                break;
            } else {
                if (this.getAutore().get(i).equals(a)) {
                    this.getAutore().remove(i);
                    break;
                }
            }
        }
    }

    /*Boolean loggedIn;
     Connection conn = null;
     try {
     conn = DbConnection.getInstance().getConnection();
     conn.setAutoCommit(false);
     String sql = "select * from autoriArticoli where idArticolo = ? and idUtente = ? ";
     PreparedStatement stmt = conn.prepareStatement(sql);
     stmt.setString(1, Integer.toString(a.getIdUtente()));
     stmt.setString(2, Integer.toString(a.getIdUtente()));
     ResultSet set = stmt.executeQuery();

     loggedIn = set.next();
     if (loggedIn) {
     String eliminaAutore = "delete from autoriArticoli where idArticolo = ? and idUtente = ? ";
     stmt = conn.prepareStatement(eliminaAutore);
     stmt.setString(2, Integer.toString(this.getIdArticolo()));
     stmt.setString(1, Integer.toString(a.getIdUtente()));
     stmt.executeUpdate();
     } else {
     String inserisciAutore = "insert into autoriArticoli (idUtente,idArticolo) values (?,?)";
     stmt = conn.prepareStatement(inserisciAutore);
     stmt.setString(1, Integer.toString(a.getIdUtente()));
     stmt.setString(2, Integer.toString(this.getIdArticolo()));
     stmt.executeUpdate();
     }
     conn.commit();
     stmt.close();
     conn.close();
     } catch (SQLException e) {
     Logger.getLogger(FactoryArticolo.class.getName()).log(Level.SEVERE, null, e);
     if (conn != null) {
     try {
     conn.rollback();
     } catch (SQLException ex) {
     Logger.getLogger(FactoryArticolo.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
     }*/
    public List<Articolo> getArticoliByAutore(Utente u) {
        List<Articolo> articoliUtente = new ArrayList<>();
        try {
            DbConnection connectFactory = DbConnection.getInstance();
            Connection conn = connectFactory.getConnection();
            String sql = "select articoli.* from articoli natural join autoriArticoli where idUtente= ? order by dataPubblicazione";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Integer.toString(u.getIdUtente()));
            ResultSet set = stmt.executeQuery();

            while (set.next()) {
                Articolo a = new Articolo();
                a.setIdArticolo(set.getInt("idArticolo"));
                a.setTitolo(set.getString("titolo"));
                a.setAutore(FactoryUtente.getInstance().getAutoriPerArticolo(a.getIdArticolo()));
                a.setCategoria(FactoryCategoria.getInstance().getCategoriePerArticolo(a.getIdArticolo()));
                a.setData(set.getString("dataPubblicazione"));
                a.setTesto(set.getString("testo"));
                a.setImmagine(set.getString("foto"));
                a.setStato(FactoryStato.getInstance().getStatoPerArticolo(a.getIdArticolo()));
                //a.setValutazioni();

                articoliUtente.add(a);
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(FactoryArticolo.class
                    .getName()).log(Level.SEVERE, null, e);
        }
        return articoliUtente;
    }

    public List<Articolo> getArticoloByCategoria(Categoria c) {
        List<Articolo> allArticoli = FactoryArticolo.getInstance().getArticoliOrdinati();
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

    public void addCategoria(Categoria c) {
        List<Categoria> categorie = this.getCategoria();
        categorie.add(c);
        this.setCategoria(categorie);
    }

    public String stampaAutori() {
        String s = "";

        for (Utente u : this.getAutore()) {
            s += (u.getName() + " " + u.getSurname() + "\n");
        }

        return s;
    }
}
