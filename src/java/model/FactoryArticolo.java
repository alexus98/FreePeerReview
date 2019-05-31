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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        try {
            DbConnection connectFactory = DbConnection.getInstance();
            Connection conn = connectFactory.getConnection();
            String sql = "select * from articoli";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);

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

                articoli.add(a);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(FactoryArticolo.class.getName()).log(Level.SEVERE, null, e);
        }
        return articoli;
    }

    public List<Articolo> getArticoliOrdinati() {
        List<Articolo> articoli = new ArrayList<>();

        try {
            DbConnection connectFactory = DbConnection.getInstance();
            Connection conn = connectFactory.getConnection();
            String sql = "select * from articoli order by dataPubblicazione";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);

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
                a.setValutazioni(FactoryValutazione.getInstance().getValutazioniPerArticolo(a.getIdArticolo()));

                articoli.add(a);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(FactoryArticolo.class.getName()).log(Level.SEVERE, null, e);
        }
        return articoli;
    }

    public Articolo getArticoloById(int id) {
        Boolean loggedIn;
        try {
            Connection conn = DbConnection.getInstance().getConnection();
            String sql = "select * from articoli where idArticolo = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Integer.toString(id));
            ResultSet set = stmt.executeQuery();

            loggedIn = set.next(); // Controllo se c'è almeno una riga
            if (loggedIn) {
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
                stmt.close();
                conn.close();
                return a;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactoryArticolo.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return null;
    }

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
            Logger.getLogger(FactoryArticolo.class.getName()).log(Level.SEVERE, null, e);
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

    public List<Articolo> getArticoliDaValutare(Utente u) {
        List<Articolo> articoliDaValutare = new ArrayList<>();
        try {
            DbConnection connectFactory = DbConnection.getInstance();
            Connection conn = connectFactory.getConnection();
            String sql = "select articoli.* from articoli natural join valutazioniArticoli";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Integer.toString(u.getIdUtente()));
            ResultSet set = stmt.executeQuery();

            while (set.next()) {
                Articolo a = new Articolo();
                a.setTitolo(set.getString("titolo"));
                a.setAutore(FactoryUtente.getInstance().getAutoriPerArticolo(a.getIdArticolo()));
                a.setCategoria(FactoryCategoria.getInstance().getCategoriePerArticolo(a.getIdArticolo()));
                a.setData(set.getString("dataPubblicazione"));
                a.setIdArticolo(set.getInt("idArticolo"));
                a.setTesto(set.getString("testo"));
                a.setImmagine(set.getString("foto"));
                a.setStato(FactoryStato.getInstance().getStatoPerArticolo(a.getIdArticolo()));
                //a.setValutazioni();

                articoliDaValutare.add(a);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(FactoryArticolo.class.getName()).log(Level.SEVERE, null, e);
        }
        return articoliDaValutare;
    }

    public void modificaArticoloDb(Articolo a) {
        Connection conn = null;
        try {
            conn = DbConnection.getInstance().getConnection();
            conn.setAutoCommit(false);

            String articoli = "update articoli set titolo = ?, testo = ?, dataPubblicazione = ?, foto = ?, idStato = ? where idArticolo = ?";
            PreparedStatement stmt = conn.prepareStatement(articoli);
            stmt.setString(1, a.getTitolo());
            stmt.setString(2, a.getTesto());
            stmt.setString(3, a.getData());
            stmt.setString(4, a.getImmagine());
            stmt.setString(5, Integer.toString(a.getStato().getIdStato()));
            stmt.setString(6, Integer.toString(a.getIdArticolo()));
            stmt.executeUpdate();

            String eliminaCategorie = "delete from categorieArticoli where idArticolo = ?";
            stmt = conn.prepareStatement(eliminaCategorie);
            stmt.setString(1, Integer.toString(a.getIdArticolo()));
            stmt.executeUpdate();
            
            for (int i = 0; i < a.getCategoria().size(); i++) {
                String inserisciCategorie = "insert into categorieArticoli (idArticolo,idCategoria) values (?,?)";
                stmt = conn.prepareStatement(inserisciCategorie);
                stmt.setString(1, Integer.toString(a.getIdArticolo()));
                stmt.setString(2, Integer.toString(a.getCategoria().get(i).getIdCategoria()));
                stmt.executeUpdate();
            }

            conn.commit();
            conn.setAutoCommit(false);
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
        }
    }
}
