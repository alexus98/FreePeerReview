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

        int utenteId = (int) sessione.getAttribute("utenteId");

        if (sessione.getAttribute("utenteId") != null) {
            Utente utente = FactoryUtente.getInstance().getUtenteById(utenteId);
            request.setAttribute("utente", utente);
            List<Articolo> mieiArticoli = FactoryArticolo.getInstance().getArticoliByAutore(utente);
            List<Articolo> articoliDaValutare = FactoryArticolo.getInstance().getArticoliDaValutare(utente);
            List<Utente> allUtenti = FactoryUtente.getInstance().getUtenti();
            int pid = Integer.parseInt(request.getParameter("pid"));

            if (request.getParameter("salva") != null) {
                Articolo b = FactoryArticolo.getInstance().getArticoloById(pid);
                
                List<Categoria> cat = new ArrayList<>();
                if (request.getParameter("html") != null) {
                    cat.add(FactoryCategoria.getInstance().getCategoriaById(Integer.parseInt(request.getParameter("html"))));
                }
                if (request.getParameter("jsp") != null) {
                    cat.add(FactoryCategoria.getInstance().getCategoriaById(Integer.parseInt(request.getParameter("jsp"))));
                }
                if (request.getParameter("css") != null) {
                    cat.add(FactoryCategoria.getInstance().getCategoriaById(Integer.parseInt(request.getParameter("css"))));
                }
                if (request.getParameter("javascript") != null) {
                    cat.add(FactoryCategoria.getInstance().getCategoriaById(Integer.parseInt(request.getParameter("javascript"))));
                }
                if (request.getParameter("servlet") != null) {
                    cat.add(FactoryCategoria.getInstance().getCategoriaById(Integer.parseInt(request.getParameter("servlet"))));
                }
                if (request.getParameter("ajax") != null) {
                    cat.add(FactoryCategoria.getInstance().getCategoriaById(Integer.parseInt(request.getParameter("ajax"))));
                }

                b.setCategoria(cat);
                b.setTitolo(request.getParameter("titolo"));
                String data = request.getParameter("data");
                b.setData(request.getParameter("data"));
                b.setImmagine(request.getParameter("immagine"));
                b.setTesto(request.getParameter("testo"));

                request.setAttribute("articolo", b);
            } else if (utente.isOrganizzatore() == false) {
                Articolo a = FactoryArticolo.getInstance().getArticoloById(pid);
                request.setAttribute("articolo", a);
            }
            request.setAttribute("allUtenti", allUtenti);
            request.setAttribute("mieiArticoli", mieiArticoli);
            request.setAttribute("articoliDaValutare", articoliDaValutare);
        }
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
