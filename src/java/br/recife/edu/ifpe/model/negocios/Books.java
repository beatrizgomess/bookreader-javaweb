
package br.recife.edu.ifpe.model.negocios;

/**
 *
 * @author bea
 */
public class Books {
    
    private int id;
    private String title;
    private String subtitle;
    private String author;
    private String yearPublication;
    private String publishingCompany;
    private String status;
    
    
    public Books(String title, String subtitle, String author, String yearPublication, String publishingCompany, String status){
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.yearPublication = yearPublication;
        this.publishingCompany = publishingCompany;
        this.status = status;
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(String yearPublication) {
        this.yearPublication = yearPublication;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}


    
