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
public class FactoryCategoria
{    
    private static FactoryCategoria singleton;

    private FactoryCategoria() {
    }

    public static FactoryCategoria getInstance() {
        if (singleton == null) {
            singleton = new FactoryCategoria();
        }
        return singleton;
    }

    public List<Categoria> getAllCategorie()
    {
        List<Categoria> categorie = new ArrayList<>();

        Categoria html=new Categoria();
        html.setIdCategoria(1);
        html.setNomeCategoria("HTML");
        categorie.add(html);
                
        Categoria jsp=new Categoria();
        jsp.setIdCategoria(2);
        jsp.setNomeCategoria("jsp");
        categorie.add(jsp);
        
        Categoria css=new Categoria();
        css.setIdCategoria(3);
        css.setNomeCategoria("CSS");
        categorie.add(css);
                
        Categoria javaScript=new Categoria();
        javaScript.setIdCategoria(4);
        javaScript.setNomeCategoria("JavaScript");
        categorie.add(javaScript);
        
        Categoria servlet=new Categoria();
        servlet.setIdCategoria(5);
        servlet.setNomeCategoria("Servlet");
        categorie.add(servlet);
        
        Categoria ajax=new Categoria();
        ajax.setIdCategoria(6);
        ajax.setNomeCategoria("AJAX");
        categorie.add(ajax);
        
        return categorie;
    }
    
    public Categoria getCategoriaById(int id)
    {
        List<Categoria> categorie = this.getAllCategorie();
        for(Categoria c : categorie){
            if(c.getIdCategoria()== id){
                return c;
            }
        }
        return null;
    }
}
