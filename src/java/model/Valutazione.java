/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alessandro
 */
public class Valutazione {
    private int voto;
    private String commentoAutori;
    private String commentoOrganizzatori;
    private int idArticolo;
    private int idUtente;
    
    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
    
    public String getCommentoAutori() {
        return commentoAutori;
    }

    public void setCommentoAutori(String commentoAutori) {
        this.commentoAutori = commentoAutori;
    }

    public String getCommentoOrganizzatori() {
        return commentoOrganizzatori;
    }

    public void setCommentoOrganizzatori(String commentoOrganizzatori) {
        this.commentoOrganizzatori = commentoOrganizzatori;
    }

    public int getIdArticolo() {
        return idArticolo;
    }

    public void setIdArticolo(int idArticolo) {
        this.idArticolo = idArticolo;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }
}
