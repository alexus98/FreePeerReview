/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Articolo;
import model.Categoria;
import model.FactoryArticolo;
import model.FactoryCategoria;
import model.FactoryUtente;
import model.Utente;

/**
 *
 * @author Alessandro
 */
@WebServlet(urlPatterns = {"/scriviArticolo.html"})
public class WriteArticolo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sessione = request.getSession();

        if (sessione.getAttribute("utenteId") != null) {
            int utenteId = (int) sessione.getAttribute("utenteId");
            Utente utente = FactoryUtente.getInstance().getUtenteById(utenteId);
            request.setAttribute("utente", utente);
            List<Articolo> mieiArticoli = FactoryArticolo.getInstance().getArticoliByAutore(utente);
            List<Articolo> articoliDaValutare = FactoryArticolo.getInstance().getArticoliDaValutare(utente);
            List<Categoria> allCategorie = FactoryCategoria.getInstance().getAllCategorie();
            request.setAttribute("mieiArticoli", mieiArticoli);
            request.setAttribute("articoliDaValutare", articoliDaValutare);
            request.setAttribute("allCategorie", allCategorie);

            if (request.getParameter("salva") != null) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                Articolo a = FactoryArticolo.getInstance().getArticoloById(pid);
                a.setTitolo(request.getParameter("titolo"));
                a.setImmagine(request.getParameter("immagine"));
                a.setData(request.getParameter("data"));
                a.setTesto(request.getParameter("testo"));
                
                
                if (!request.getParameter("listaAutori").equals("null")) 
                {
                    String s = request.getParameter("listaAutori");
                    a.addAutore(FactoryUtente.getInstance().getUtenteById(Integer.parseInt(request.getParameter("listaAutori"))));
                }
                a.getCategoria().clear();
                for (String s : request.getParameterValues("categoria"))
                {
                    a.addCategoria(FactoryCategoria.getInstance().getCategoriaById(Integer.parseInt(s)));
                }
                FactoryArticolo.getInstance().modificaArticoloDb(a);
                
                List<Utente> allAutori = FactoryUtente.getInstance().getAutori();
                request.setAttribute("articolo", a);
                request.setAttribute("allAutori", allAutori);
            }
            else if (!utente.isOrganizzatore()) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                Articolo a = FactoryArticolo.getInstance().getArticoloById(pid);
                List<Utente> allAutori = FactoryUtente.getInstance().getAutori();
                request.setAttribute("articolo", a);
                request.setAttribute("allAutori", allAutori);
            }
        }
        /*)
         List<Articolo> mieiArticoli = FactoryArticolo.getInstance().getArticoliByAutore(utente);
         List<Articolo> articoliDaValutare = FactoryArticolo.getInstance().getArticoliDaValutare(utente);
            
         List<Categoria> allCategorie = FactoryCategoria.getInstance().getAllCategorie();
         
         request.setAttribute("mieiArticoli", mieiArticoli);
         request.setAttribute("articoliDaValutare", articoliDaValutare);
         request.setAttribute("allCategorie", allCategorie);
         }*/
        request.getRequestDispatcher("scriviArticolo.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
