import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public final static String RUTA="resorces"+ File.separator +"productos.txt";
    public static void recogerDatos(List<Productos> lista) throws IOException {

        Path path= Paths.get(RUTA);
        String codigo;
        String nombre;
        double precio;
        int cantidad;
        String categoria;

        List<String> lineas= Files.readAllLines(path);
        for (String linea:lineas){
            String [] palabras=linea.split(";");
            codigo=palabras[0];
            nombre=palabras[1];
            precio= Double.parseDouble(palabras[2]);
            cantidad= Integer.parseInt(palabras[3]);
            categoria=palabras[4];
            Productos producto=new Productos(codigo,nombre,precio,cantidad,categoria);
            lista.add(producto);
        }
    }
    public static void main(String[] args) throws IOException {
    List<Productos>lista=new ArrayList<>();
    recogerDatos(lista);
        System.out.println(lista.get(0).getCategoria());
    }
}