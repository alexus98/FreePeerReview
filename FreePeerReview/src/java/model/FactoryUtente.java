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
        
        Utente autore_1 = new Utente();
        autore_1.setIdUtente(1);
        autore_1.setName("Alessandro");
        autore_1.setSurname("Vacca");
        autore_1.setEmail("ale@gmail.com");
        autore_1.setPassword("123");
        autore_1.setOrganizzatore(true);
        utenti.add(autore_1);
        
        Utente autore_2 = new Utente();
        autore_2.setIdUtente(2);
        autore_2.setName("Roberto");
        autore_2.setSurname("Zedda");
        autore_2.setEmail("roberto@gmail.com");
        autore_2.setPassword("456");
        autore_2.setOrganizzatore(false);
        utenti.add(autore_2);
        
        Utente nico = new Utente();
        nico.setIdUtente(3);
        nico.setName("Nicola");
        nico.setSurname("Loi Zedda");
        nico.setEmail("nicola@gmail.com");
        nico.setPassword("789");
        nico.setOrganizzatore(false);
        utenti.add(nico);
        
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
