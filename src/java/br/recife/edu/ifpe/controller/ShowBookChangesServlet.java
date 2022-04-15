
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
@WebServlet(name = "ShowBookChangesServlet", urlPatterns = {"/ShowBookChangesServlet"})
public class ShowBookChangesServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       
            int id = Integer.parseInt(request.getParameter("id"));
            Books l = functions.read(id);
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"css/update_book.css\" media=\"screen\"/>");
            out.println("<title>Servlet ShowBookChanges</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Altere o contato</h1>");
            out.println("<a href='ViewBookServlet'>Livros</a><br>");
            out.println("<form method='post' action='ChangeBookServlet'>");
            out.println("<input type='hidden' name='id' value='"+l.getId()+"'/>");
            out.println("Título: <input type=\"text\" name=\"title\" value='"+l.getTitle()+"'><br>");
            out.println("Subtítulo: <input type=\"text\" name=\"subtitle\" value='"+l.getSubtitle()+"'><br>");
            out.println("Autor: <input type=\"text\" name=\"author\" value='"+l.getAuthor()+"'><br>");
            out.println("Ano de Publicação: <input type=\"text\" name=\"yearPublication\" value='"+l.getYearPublication()+"'><br>");
            out.println("Editora: <input type=\"text\" name=\"publishingCompany\" value='"+l.getPublishingCompany()+"'><br>");
            out.println("Status: <input type=\"text\" name=\"status\" value='"+l.getStatus()+"'><br>");
            out.println("<input type='submit' value='enviar'/>");
            out.println("</form>");
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
