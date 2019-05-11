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
public class FactoryUtente
{
    
    private static FactoryUtente singleton;
    
     private FactoryUtente(){ }
    
    public static FactoryUtente getInstance()
    {
        if(singleton == null)
        {
            singleton = new FactoryUtente();
        }
        return singleton;
    }
    
    public List<Utente> getUtenti()
    {
        List<Utente> utenti = new ArrayList<>();
        
        Utente ale = new Utente();
        ale.setIdUtente(1);
        ale.setName("Alessandro");
        ale.setSurname("Vacca");
        ale.setEmail("ale@gmail.com");
        ale.setPassword("123");
        ale.setOrganizzatore(true);
        utenti.add(ale);
        
        Utente roberto = new Utente();
        roberto.setIdUtente(2);
        roberto.setName("Roberto");
        roberto.setSurname("Zedda");
        roberto.setEmail("roberto@gmail.com");
        roberto.setPassword("456");
        roberto.setOrganizzatore(false);
        utenti.add(roberto);
        
        return utenti;
    }
    
    public Utente getUtenteById(int id){
        List<Utente> utenti = this.getUtenti();
        for(Utente u : utenti){
            if(u.getIdUtente()== id){
                return u;
            }
        }
        return null;
    }
    
    public Utente getAutoreByEmailPassword(String email, String password){
        List<Utente> utenti = this.getUtenti();
        for(Utente u : utenti){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
}
