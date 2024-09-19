public class Libro {
    private String nombre;
    private String autor;
    private String categoria;
    private boolean disponible;

    public Libro(String nombre, String autor, String categoria, boolean disponible) {
        this.autor = autor;
        this.nombre = nombre;
        this.categoria = categoria;
        this.disponible = disponible;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }  
}

