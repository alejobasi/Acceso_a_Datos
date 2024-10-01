import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private final static String RUTA_FICHERO ="resorces"+File.separator+"carta.txt";

    public static void Contar(){
        int lineas=0;
        int caracteres=0;
        int palabras=0;
        Path path=Paths.get(RUTA_FICHERO);
        try {
            List<String> contenidoCarta= Files.readAllLines(path);
            for (String msj: contenidoCarta){
                lineas++;
                String [] palabra=msj.split(" ");
                palabras+=palabra.length;
                for (String pal: palabra){
                    String[] caracter=pal.split("");
                    caracteres+=caracter.length;
                }


            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Nº de Lineas: "+lineas+" \nNº de Palabras: "+palabras+"\n Nº de Caracteres: "+caracteres);

    }

    public static void main(String[] args) {

        Contar();

    }
}