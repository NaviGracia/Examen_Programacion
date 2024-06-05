/**
 * Libro
 */
public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int any_publicacion;
    private String genero;

    public Libro(int id, String titulo, String autor, int any_publicacion, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.any_publicacion = any_publicacion;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public int getAny_publicacion() {
        return any_publicacion;
    }
    
    public void setAny_publicacion(int any_publicacion) {
        this.any_publicacion = any_publicacion;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    } 

    @Override
    public String toString(){
        return id + " " + titulo + " " + autor + " " + any_publicacion + " " + genero;
    }
}
