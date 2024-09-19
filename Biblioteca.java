import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
    private ArrayList<Libro> libros;
    private HashMap<Integer, Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new HashMap<>();
        prestamos = new ArrayList<>();
    }

    public void registrarLibro(Libro libro) {
        libros.add(libro);
    }

    
    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }


     
    public void prestarLibro(int usuarioId, String tituloLibro) throws Exception {
        Usuario usuario = usuarios.get(usuarioId);
        Libro libro = buscarLibro(tituloLibro);
        
        if (libro == null) {
            throw new Exception("Libro no encontrado.");
        }
        
        if (!libro.isDisponible()) {
            throw new Exception("Libro no disponible.");
        }

        Prestamo prestamo = new Prestamo(usuario, libro);
        prestamos.add(prestamo);
    }

    
    public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getNombre().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    
    public void devolverLibro(String tituloLibro) throws Exception {
        Libro libro = buscarLibro(tituloLibro);
        
        if (libro == null) {
            throw new Exception("Libro no encontrado.");
        }

        libro.setDisponible(true); // Marcar el libro como disponible
    }
}
