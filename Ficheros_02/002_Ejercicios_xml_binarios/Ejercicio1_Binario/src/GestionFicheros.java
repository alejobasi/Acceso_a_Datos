import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestionFicheros {
    public static String RUTA_DIRECTORIO="Dataset";
    public static String RUTA_FICHERO=RUTA_DIRECTORIO+ File.separator+"ListaDeporistas.bin";
    public static void guardarDeportistas(List<Deportistas>deportistas){
        Path pathDirectorio=Paths.get(RUTA_DIRECTORIO);
        Path path= Paths.get(RUTA_FICHERO);


        if (Files.isDirectory(pathDirectorio)){
            if (Files.exists(path)){
                //Directorio Si y Fichero Si
                try {
                    OutputStream archivoSalida= Files.newOutputStream(path);

                    ObjectOutputStream flujoSalida= new ObjectOutputStream(archivoSalida);

                    flujoSalida.writeObject(deportistas);


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
                //Directorio Si y Fichero No
                try {
                    Files.createFile(path);

                    OutputStream archivoSalida= Files.newOutputStream(path);

                    ObjectOutputStream flujoSalida= new ObjectOutputStream(archivoSalida);

                    flujoSalida.writeObject(deportistas);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }else {
            try {
                Files.createDirectories(pathDirectorio);
                Files.createFile(path);
                OutputStream archivoSalida= Files.newOutputStream(path);

                ObjectOutputStream flujoSalida= new ObjectOutputStream(archivoSalida);

                flujoSalida.writeObject(deportistas);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static List<Deportistas> recuperarDeportistas() {
        List<Deportistas> deportistas = new ArrayList<>();

        Path path = Paths.get(RUTA_FICHERO);

        if (Files.exists(path)) {
            try {
                InputStream archivoEntrada = Files.newInputStream(path);
                ObjectInputStream flujoEntrada = new ObjectInputStream(archivoEntrada);

                deportistas = (List<Deportistas>) flujoEntrada.readObject();

            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Clase no encontrada: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe, se devolverá una lista vacía.");
        }

        return deportistas;
    }

}
