import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String autor = datos[0];
                String titulo = datos[1];
                String categoria = datos[2];
                boolean disponible = Boolean.parseBoolean(datos[3]);
                Libro libro = new Libro(autor, titulo, categoria, disponible);
                biblioteca.registrarLibro(libro);
            }
            System.out.println("Libros cargados desde archivo.");
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }

        while (continuar) {
            System.out.println("Sistema de Gestion de Biblioteca :D");
            System.out.println("1. Registrar un nuevo libro");
            System.out.println("2. Registrar un nuevo usuario");
            System.out.println("3. Prestar un libro");
            System.out.println("4. Devolver un libro");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");

    
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();  
                System.out.println("Has seleccionado la opcion: " + opcion);

                switch (opcion) {
                    case 1:
                        System.out.print("Introduce el titulo del libro: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Introduce el autor del libro: ");
                        String autor = scanner.nextLine();
                        System.out.print("Introduce la categoria del libro: ");
                        String categoria = scanner.nextLine();

                        Libro nuevoLibro = new Libro(autor, titulo, categoria, true);
                        biblioteca.registrarLibro(nuevoLibro);
                        System.out.println("Libro registrado correctamente.");
                        break;

                    case 2:
                        System.out.print("Introduce el ID del usuario: ");
                        int idUsuario = scanner.nextInt();
                        scanner.nextLine();  
                        System.out.print("Introduce el nombre del usuario: ");
                        String nombreUsuario = scanner.nextLine();

                        Usuario nuevoUsuario = new Usuario(idUsuario, nombreUsuario);
                        biblioteca.registrarUsuario(nuevoUsuario);
                        System.out.println("Usuario registrado correctamente.");
                        break;

                    case 3:
                        try {
                            System.out.print("Introduce el ID del usuario: ");
                            int usuarioId = scanner.nextInt();
                            scanner.nextLine(); 
                            System.out.print("Introduce el título del libro que deseas prestar: ");
                            String tituloPrestar = scanner.nextLine();

                            biblioteca.prestarLibro(usuarioId, tituloPrestar);
                            System.out.println("Libro prestado correctamente.");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 4:
                        try {
                            System.out.print("Introduce el título del libro que deseas devolver: ");
                            String tituloDevolver = scanner.nextLine();

                            biblioteca.devolverLibro(tituloDevolver);
                            System.out.println("Libro devuelto correctamente.");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 5:
                        continuar = false;
                        System.out.println("Saliendo del sistema... :0");
                        break;

                    default:
                        System.out.println("Opcion no valida. Por favor, elige una opcion correcta.");
                        break;
                }
            } else {
                System.out.println("Error: Entrada no valida, por favor ingresa un numero.");
                scanner.next(); 

                System.out.println("Me gustarian mas clases sobre codigos (ejemplo commit)");
            }
        }

        scanner.close(); 
    }
}
