/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.controller;

import br.recife.edu.ifpe.model.negocios.Books;
import br.recife.edu.ifpe.model.repositorio.functions;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bea
 */
@WebServlet(name = "ViewBookServlet", urlPatterns = {"/ViewBookServlet"})
public class ViewBookServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Books> books = functions.allread();
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"book_register.css\" media=\"screen\"/>");
            out.println("<title>Livros da sua TBR</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div><img class=\"img\" src=\"images/book-stack.png\" alt=\"\"></div>");
            out.println("<h1 class='title'>Livros da sua TBR</h1>");
            out.println("<div><i class=\"fa-duotone fa-house-chimney\"></i></div>");
            out.println("<a class='home' href=\"index.html\">HOME</a>");
            out.println("<p class=\"line\"></p>");
            out.println("<table > ");
            
            out.println("<tr>"
                    + "<th>ID</th>"
                    + "<th>Titulo</th>"
                    + "<th id='sub'>Subtitulo</th>"
                    + "<th>Autor</th>"
                    + "<th>Ano de publicação</th>"
                    + "<th>Editora</th>"
                    + "<th>Status</th>"
                    + "<th>Visualizar</th>"
                    + "<th>Alterar</th>"
                    + "<th>Deletar</th>"
                    + "</tr>");
            
            for(Books l: books){
                out.println(
                        "<tr>"
                        + "<td>" + l.getId() + "</td>"
                        + "<td>" + l.getTitle() + "</td>"
                        + "<td id='sub'>" + l.getSubtitle() + "</td>"
                        + "<td>" + l.getAuthor() + "</td>"
                        + "<td>" + l.getYearPublication() + "</td>"
                        + "<td>" + l.getPublishingCompany() + "</td>"
                        + "<td>" + l.getStatus() + "</td>"
                        + "<td><a href='OpenBookServlet?id=" +l.getId()+"'> Visualizar</a>"
                        + "<td><a href='ShowBookChangesServlet?id="+ l.getId()+"'> Alterar</a></td>" 
                        + "<td id='delete'><a href='DeleteBookServlet?id="+ l.getId()+"'> Deletar</a></td>"
                        + "</td>"
                        + "</tr>");
                
            }
            
            out.println("</table>");
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
