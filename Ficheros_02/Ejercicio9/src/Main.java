import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public final static String RUTA="resorces"+ File.separator +"resultados.txt";
    public static void recogerDatos(List<Equipos> lista) throws IOException {

        Path path= Paths.get(RUTA);
        String eq1;
        String eq2;
        int res1;
        int res2;

        List<String> lineas= Files.readAllLines(path);
        for (String linea:lineas){
            String [] palabras=linea.split("::");
            eq1=palabras[0];
            eq2=palabras[1];
            res1= Integer.parseInt(palabras[2]);
            res2= Integer.parseInt(palabras[3]);
            Equipos equipo=new Equipos(eq1,res1,eq2,res2);
            lista.add(equipo);
        }
    }
    public static void mostrarDatos(List<Equipos> lista){

        for (Equipos eq:lista){
            System.out.println(eq.getEquipo1()+" "+eq.getResultado1()+"-"+
            eq.getResultado2()+" "+eq.getEquipo2());
        }
    }

    public static List<Equipos> listaEmpates(List<Equipos> lista){

        List<Equipos> lista2=new ArrayList<>();


        for (Equipos eq:lista){
           if (eq.getResultado1()== eq.getResultado2()){
               lista2.add(eq);
           }
        }


        return lista2;
    }

    public static void guardarEmpatesFichero(List<Equipos> lista) {

        Path path = Paths.get("resorces" + File.separator + "empates.txt");
        if (Files.exists(path)) {
            try {
                Files.write(path, "".getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {


            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        for (Equipos eq : lista) {
            String mensaje = eq.getEquipo1() + "::" + eq.getEquipo2() + "::" +
                    eq.getResultado1() + "::" +eq.getResultado2() +"\n";
            try {
                Files.write(path, mensaje.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public static void mostarPorParametro(List<Equipos> lista){
        Scanner sc= new Scanner(System.in);
        int cont=0;
        System.out.println("Dime un equipo y te mostrare los resultados");
        String resp=sc.nextLine();

        for (Equipos eq:lista){
            if (eq.getEquipo1().equals(resp) || eq.getEquipo2().equals(resp)){
                System.out.println(eq.getEquipo1()+" "+eq.getResultado1()+"-"+
                        eq.getResultado2()+" "+eq.getEquipo2());
                cont++;
            }
        }
        if (cont==0){
            System.out.println("No hay resultados de este equipo");
        }
    }

    public static void ganaVisitante(List<Equipos> lista){

        int cont=0;
        System.out.println("Paridos ganados por el visitante: ");


        for (Equipos eq:lista){
            if (eq.getResultado1()< eq.getResultado2()){
                System.out.println(eq.getEquipo1()+" "+eq.getResultado1()+"-"+
                        eq.getResultado2()+" "+eq.getEquipo2());
                cont++;
            }
        }
        if (cont==0){
            System.out.println("No hay resultados que gane el visitante");
        }
    }

    public static void main(String[] args) throws IOException {
    List<Equipos> listaEquipos = new ArrayList<>();
    recogerDatos(listaEquipos);
    mostrarDatos(listaEquipos);
        List<Equipos> listaEquipos2 = new ArrayList<>();
   listaEquipos2= listaEmpates(listaEquipos);
   guardarEmpatesFichero(listaEquipos2);
   mostarPorParametro(listaEquipos);
   ganaVisitante(listaEquipos);
    }
}