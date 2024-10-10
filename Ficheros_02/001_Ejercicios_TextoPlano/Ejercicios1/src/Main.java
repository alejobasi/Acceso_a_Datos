import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {


    public static void crearFichero(String nomRuta, String contFichero) {
        Path pathRuta = Paths.get(nomRuta);
        Path pathDirectorio = pathRuta.getParent();
        System.out.println(pathDirectorio);

        try {
            if (Files.exists(pathDirectorio)) {
                if (Files.exists(pathRuta)) {
                    System.out.println("El archivo ya existe");
                    return ;
                } else {

                    Files.createFile(pathRuta);

                }
            } else {
                Files.createDirectories(pathDirectorio);
                Files.createFile(pathRuta);
                Files.write(pathRuta,contFichero.getBytes(), StandardOpenOption.APPEND);
                return ;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void leerMayuMinus(String nomRuta) {
        Path pathRuta = Paths.get(nomRuta);

        try {

            String contenido = new String(Files.readAllBytes(pathRuta));



        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la ruta del fichero y el nombre del fichero");
        String respRuta = sc.nextLine();

        System.out.println("Dime el contenido que quieres añadir a dicho fichero");
        String respContenido = sc.nextLine();


      crearFichero(respRuta,respContenido);
      leerMayuMinus(respRuta);



    }
}
