
package br.recife.edu.ifpe.model.repositorio;


import br.recife.edu.ifpe.model.negocios.Books;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author bea
 */
public class functions {
    
    private static int code = 1;
    private static List<Books> livros = new ArrayList<>();
    
    public static void insert(Books book){
        book.setId(code++);
        livros.add(book);
    }
    
    public static void edit(Books book){
        
        for(Books liv: livros){
            if(liv.getId() == book.getId()){
                liv.setTitle(book.getTitle());
                liv.setSubtitle(book.getSubtitle());
                liv.setAuthor(book.getAuthor());
                liv.setYearPublication(book.getYearPublication());
                liv.setPublishingCompany(book.getPublishingCompany());
                liv.setStatus(book.getStatus());
            }
            
        }
    }
    
      public static Books read(int id){
        for(Books book: livros){
            if(book.getId() == id){
                return book;
            }

        }
        return null;
    }

    public static void delete(Books book){
        Books cont = null;
        for(Books bk: livros){
            if(bk.getId() == book.getId()){
                cont = bk;
                break;
                
            }
        }
        
        livros.remove(cont);
        
    }
    
    public static List<Books> allread(){
        return livros;
    }
    
  
    
    
}
