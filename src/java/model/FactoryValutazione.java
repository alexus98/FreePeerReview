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
public class FactoryValutazione {

    private static FactoryValutazione singleton;

    private FactoryValutazione() {
    }

    public static FactoryValutazione getInstance() {
        if (singleton == null) {
            singleton = new FactoryValutazione();
        }
        return singleton;
    }

    public List<Valutazione> getAllValutazioni() {
        List<Valutazione> valutazioni = new ArrayList<>();
        try {
            DbConnection connectFactory = DbConnection.getInstance();
            Connection conn = connectFactory.getConnection();
            String sql = "select * from valutazioniArticoli";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                Valutazione v = new Valutazione();
                v.setIdUtente(set.getInt("idUtente"));
                v.setIdArticolo(set.getInt("idArticolo"));
                v.setCommentoAutori(set.getString("commentoAutori"));
                v.setCommentoOrganizzatori(set.getString("commentoOrganizzatori"));
                v.setVoto(set.getInt("voto"));
                valutazioni.add(v);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(FactoryUtente.class.getName()).log(Level.SEVERE, null, e);
        }
        return valutazioni;
    }

    /*List<Valutazione> valutazioni = new ArrayList<>();

     Valutazione val1=new Valutazione();
     val1.setVoto(5);
     val1.setIdValutazione(1);
     valutazioni.add(val1);
        
     Valutazione val2=new Valutazione();
     val2.setVoto(1);
     val2.setIdValutazione(2);
     valutazioni.add(val2);
        
     Valutazione val3=new Valutazione();
     val3.setVoto(3);
     val3.setIdValutazione(3);
     valutazioni.add(val3);

        
     return valutazioni;*/
    public Valutazione getValutazioneByIdArticoloAndIdUtente(int idUtente, int idArticolo) {
        Boolean loggedIn;

        try {
            Connection conn = DbConnection.getInstance().getConnection();
            String sql = "select * from valutazioniArticoli where idUtente = ? and idArticolo = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, Integer.toString(idUtente));
            stmt.setString(2, Integer.toString(idArticolo));

            ResultSet set = stmt.executeQuery();

            loggedIn = set.next(); // Controllo se c'è almeno una riga
            if (loggedIn) {
                Valutazione v = new Valutazione();
                v.setIdUtente(set.getInt("idUtente"));
                v.setIdArticolo(set.getInt("idArticolo"));
                v.setCommentoAutori(set.getString("commentoAutori"));
                v.setCommentoOrganizzatori(set.getString("commentoOrganizzatori"));
                v.setVoto(set.getInt("voto"));
                stmt.close();
                conn.close();
                return v;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactoryUtente.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Valutazione> getValutazioniPerArticolo(int idArticolo) {
        List<Valutazione> valutazioni = new ArrayList<>();
        try {
            DbConnection connectFactory = DbConnection.getInstance();
            Connection conn = connectFactory.getConnection();
            String sql = "select * from valutazioniArticoli where idArticolo=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Integer.toString(idArticolo));

            ResultSet set = stmt.executeQuery();

            while (set.next()) {
                Valutazione v = new Valutazione();
                v.setIdUtente(set.getInt("idUtente"));
                v.setIdArticolo(set.getInt("idArticolo"));
                v.setCommentoAutori(set.getString("commentoAutori"));
                v.setCommentoOrganizzatori(set.getString("commentoOrganizzatori"));
                v.setVoto(set.getInt("voto"));
                valutazioni.add(v);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(FactoryUtente.class.getName()).log(Level.SEVERE, null, e);
        }
        return valutazioni;
    }
}
