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
public class FactoryUtente {

    private static FactoryUtente singleton;

    private FactoryUtente() {
    }

    public static FactoryUtente getInstance() {
        if (singleton == null) {
            singleton = new FactoryUtente();
        }
        return singleton;
    }

    public List<Utente> getUtenti() {
        List<Utente> utenti = new ArrayList<>();

        try {
            DbConnection connectFactory = DbConnection.getInstance();
            Connection conn = connectFactory.getConnection();
            String sql = "select * from utenti";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                Utente u = new Utente();
                u.setIdUtente(set.getInt("idUtente"));
                u.setName(set.getString("nome"));
                u.setSurname(set.getString("cognome"));
                u.setEmail(set.getString("email"));
                u.setPassword(set.getString("password"));
                u.setOrganizzatore(set.getBoolean("isOrganizzatore"));
                u.setEnte(set.getString("ente"));
                u.setFoto(set.getString("foto"));
                utenti.add(u);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(FactoryUtente.class.getName()).log(Level.SEVERE, null, e);
        }
        return utenti;
    }

    public Utente getUtenteById(int id) {
        try {
            Boolean loggedIn;

            Connection conn = DbConnection.getInstance().getConnection();
            String sql = "select * from utenti where idUtente = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, Integer.toString(id));

            ResultSet set = stmt.executeQuery();

            loggedIn = set.next();
            if (loggedIn) {
                Utente u = new Utente();
                u.setIdUtente(set.getInt("idUtente"));
                u.setName(set.getString("nome"));
                u.setSurname(set.getString("cognome"));
                u.setEmail(set.getString("email"));
                u.setPassword(set.getString("password"));
                u.setOrganizzatore(set.getBoolean("isOrganizzatore"));
                u.setEnte(set.getString("ente"));
                u.setFoto(set.getString("foto"));
                stmt.close();
                conn.close();
                return u;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactoryUtente.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public Utente getAutoreByEmailPassword(String email, String password) {
        try {
            Boolean loggedIn;

            Connection conn = DbConnection.getInstance().getConnection();
            String sql = "select * from utenti where email = ? and password = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet set = stmt.executeQuery();

            loggedIn = set.next(); // Controllo se c'è almeno una riga
            if (loggedIn) {
                Utente u = new Utente();
                u.setIdUtente(set.getInt("idUtente"));
                u.setName(set.getString("nome"));
                u.setSurname(set.getString("cognome"));
                u.setEmail(set.getString("email"));
                u.setPassword(set.getString("password"));
                u.setOrganizzatore(set.getBoolean("isOrganizzatore"));
                u.setEnte(set.getString("ente"));
                u.setFoto(set.getString("foto"));
                stmt.close();
                conn.close();
                return u;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactoryUtente.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Utente> getAutori() {
        List<Utente> utenti = new ArrayList<>();

        try {
            DbConnection connectFactory = DbConnection.getInstance();
            Connection conn = connectFactory.getConnection();
            String sql = "select * from utenti where isOrganizzatore = 0";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                Utente u = new Utente();
                u.setIdUtente(set.getInt("idUtente"));
                u.setName(set.getString("nome"));
                u.setSurname(set.getString("cognome"));
                u.setEmail(set.getString("email"));
                u.setPassword(set.getString("password"));
                u.setOrganizzatore(set.getBoolean("isOrganizzatore"));
                u.setEnte(set.getString("ente"));
                u.setFoto(set.getString("foto"));
                utenti.add(u);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(FactoryUtente.class.getName()).log(Level.SEVERE, null, e);
        }
        return utenti;
    }
    
    public List<Utente> getAutoriPerArticolo(int idArticolo) {
        List<Utente> utenti = new ArrayList<>();

        try {
            DbConnection connectFactory = DbConnection.getInstance();
            Connection conn = connectFactory.getConnection();
            String sql = "select utenti.* from utenti natural join autoriArticoli where idArticolo = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Integer.toString(idArticolo));
            ResultSet set = stmt.executeQuery();

            while (set.next()) {
                Utente u = new Utente();
                u.setIdUtente(set.getInt("idUtente"));
                u.setName(set.getString("nome"));
                u.setSurname(set.getString("cognome"));
                u.setEmail(set.getString("email"));
                u.setPassword(set.getString("password"));
                u.setOrganizzatore(set.getBoolean("isOrganizzatore"));
                u.setEnte(set.getString("ente"));
                u.setFoto(set.getString("foto"));
                utenti.add(u);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(FactoryUtente.class.getName()).log(Level.SEVERE, null, e);
        }
        return utenti;
    }
}
