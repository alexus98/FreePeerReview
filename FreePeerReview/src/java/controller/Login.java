/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Articolo;
import model.FactoryArticolo;
import model.FactoryUtente;
import model.Utente;

/**
 *
 * @author Alessandro
 */
@WebServlet(urlPatterns = {"/login.html"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sessione = request.getSession();

        if (request.getParameter("login") != null)
        {
            String email = request.getParameter("username");

            String password = request.getParameter("password");

            Utente utente = FactoryUtente.getInstance().getAutoreByEmailPassword(email, password);

            if (utente != null) {
                sessione.setAttribute("utenteId", utente.getIdUtente());
            }
        }

        if (sessione.getAttribute("utenteId") != null)
        {
            int utenteId = (int) sessione.getAttribute("utenteId");

            Utente utente = FactoryUtente.getInstance().getUtenteById(utenteId);
            if(utente.isOrganizzatore() == false)
            {
                List<Articolo> mieiArticoli = FactoryArticolo.getInstance().getArticoliByAutore(utente);
                List<Articolo> articoliDaValutare = FactoryArticolo.getInstance().getArticoliDaValutare(utente);

                request.setAttribute("utente", utente);
                request.setAttribute("mieiArticoli", mieiArticoli);
                request.setAttribute("articoliDaValutare", articoliDaValutare);
            
            }
                response.sendRedirect("articoli.html");
        }
        else
        {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
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
