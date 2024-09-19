
public class Prestamo {
    private Usuario usuario;
    private Libro libro;

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        libro.setDisponible(false);
    }
    
    public void mostrarInfoPrestamo() {
        System.out.println("Prestamo realizado por:" + usuario.getNombre());
        System.out.println("Libro prestado: " + libro.getNombre());
    }
     
    public void verificarDisponibilidad (){
        if (libro.isDisponible()){
            System.out.println("El libro no está disponible.");
        } else {
            System.out.println("El libro esta disponible");
        }
    }
} 