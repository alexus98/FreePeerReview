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
public class FactoryCategoria {

    private static FactoryCategoria singleton;

    private FactoryCategoria() {
    }

    public static FactoryCategoria getInstance() {
        if (singleton == null) {
            singleton = new FactoryCategoria();
        }
        return singleton;
    }

    public List<Categoria> getAllCategorie() {
        List<Categoria> categorie = new ArrayList<>();
        try {
            DbConnection connectFactory = DbConnection.getInstance();
            Connection conn = connectFactory.getConnection();
            String sql = "select * from categorie";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                Categoria c = new Categoria();
                c.setIdCategoria(set.getInt("idCategoria"));
                c.setNomeCategoria(set.getString("nomeCategoria"));
                categorie.add(c);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(FactoryUtente.class.getName()).log(Level.SEVERE, null, e);
        }
        return categorie;
    }

    public Categoria getCategoriaById(int id) {
        Boolean loggedIn;
        try {
            Connection conn = DbConnection.getInstance().getConnection();
            String sql = "select * from categorie where idCategoria = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Integer.toString(id));
            ResultSet set = stmt.executeQuery();

            loggedIn = set.next(); // Controllo se c'è almeno una riga
            if (loggedIn) {
                Categoria c = new Categoria();
                c.setIdCategoria(set.getInt("idCategoria"));
                c.setNomeCategoria(set.getString("nomeCategoria"));
                stmt.close();
                conn.close();
                return c;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactoryUtente.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Categoria> getCategoriePerArticolo(int idArticolo) {
        List<Categoria> categorie = new ArrayList<>();

        try {
            DbConnection connectFactory = DbConnection.getInstance();
            Connection conn = connectFactory.getConnection();
            String sql = "select categorie.* from categorie natural join categorieArticoli where idArticolo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Integer.toString(idArticolo));
            ResultSet set = stmt.executeQuery();

            while (set.next()) {               
                Categoria c = new Categoria();
                c.setIdCategoria(set.getInt("idCategoria"));
                c.setNomeCategoria(set.getString("nomeCategoria"));
                categorie.add(c);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(FactoryUtente.class.getName()).log(Level.SEVERE, null, e);
        }
        return categorie;
    }
}

