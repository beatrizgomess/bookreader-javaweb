/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller;

import br.recife.edu.ifpe.model.negocios.Books;
import br.recife.edu.ifpe.model.repositorio.functions;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author bea
 */
@WebServlet(name = "ChangeBookServlet", urlPatterns = {"/ChangeBookServlet"})
public class ChangeBookServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String subtitle = request.getParameter("subtitle");
        String author = request.getParameter("author");
        String publishingCompany = request.getParameter("publishingCompany");
        String status = request.getParameter("status");
        String yearPublication = request.getParameter("yearPublication");
        
        Books book = new Books(title, subtitle, author, yearPublication, publishingCompany, status);
        book.setId(id);
        functions.edit(book);
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangeBook</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>O Contato foi alterado com Sucesso!</h1>");
            out.println("<a href='ViewBookServlet'>Livros</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
