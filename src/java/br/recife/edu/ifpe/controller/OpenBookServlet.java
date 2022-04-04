
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
@WebServlet(name = "OpenBookServlet", urlPatterns = {"/OpenBookServlet"})
public class OpenBookServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Books book = functions.read(id);
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Detalhes do Livro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Livro: " + book.getTitle() + "</h1>");
            out.println("Subtitulo: " + book.getSubtitle() + "<br>");
            out.println("Autor: " + book.getAuthor() + "<br>");
            out.println("Ano de publicação: " + book.getYearPublication()+ "<br>");
            out.println("Editora: " + book.getPublishingCompany()+ "<br>");
            out.println("Status: " + book.getStatus()+ "<br>");
            out.println("<a href='ViewBookServlet'>Voltar para a TBR</a>");
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
    }

}
