import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {

    private final  static String RUTA_DIRECTORIO="resorces"+ File.separator;
    private final  static String RUTA_FICHERO=RUTA_DIRECTORIO+ "prueba.txt";
    private final  static String RUTA_PROPERTIES="resorces"+File.separator+"bbdd.properties";

    public static void crearFichero(){
        Path path= Paths.get(RUTA_DIRECTORIO);
        Path pathFichero= Paths.get(RUTA_FICHERO);
        try {
        if (Files.exists(path)){
            if (Files.exists(pathFichero)){
                return;
            }else {

                    Files.createFile(pathFichero);

            }
        }else {
            Files.createDirectories(path);
            Files.createFile(pathFichero);
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }

    public static void escribirFichero(){
        Path pathFichero= Paths.get(RUTA_FICHERO);
        String mensaje="Hola\n";
        String mensaje2="Soy Alejo";
        try {
            Files.write(pathFichero, mensaje.getBytes(), StandardOpenOption.APPEND);
            Files.write(pathFichero, mensaje2.getBytes(), StandardOpenOption.APPEND);


        } catch (IOException e) {
            System.out.println("No se ha podido escribir con el fichero");
            throw new RuntimeException(e);
        }

        List <String> listaMensajes=new ArrayList<>();
        listaMensajes.add("Esto es una prueba\n");
        listaMensajes.add("Esta es otra linea\n");

        try {
            Files.write(pathFichero,listaMensajes, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leerFichero(){
        Path pathFichero= Paths.get(RUTA_FICHERO);

        try {
            List<String> lineasFichero=Files.readAllLines(pathFichero);
            for (String msj: lineasFichero)
                System.out.println(msj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//crearFichero();
//escribirFichero();
    //    leerFichero();

        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream(RUTA_PROPERTIES));
            String hostname=properties.getProperty("mysql.hostname");
            System.out.println(hostname);

            int puerto=3000;
            properties.setProperty("mysql.port",String.valueOf(puerto));
            properties.store(new FileOutputStream(RUTA_PROPERTIES),"Añadidas config");

        } catch (IOException e) {
            System.out.println("Error lectura del fichero");
            throw new RuntimeException(e);
        }
    }

}