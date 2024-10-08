import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void altaDeportistas(List<Deportistas> deportistas){

        Scanner sc =new Scanner(System.in);

        System.out.println("--------- Formulario Alta ---------\n");

        System.out.println("Dime el DNI");
        String dni=sc.next();

        System.out.println("Dime el Nombre");
        String nombre=sc.next();

        System.out.println("Dime la fecha de Nacimiento (01-01-2000)");
        String fechaNac=sc.next();

        System.out.println("Dime el deporte que practica indicando la letra\n- N: natacion\n- R: Remo\n- V: Vela\n- W: Waterpolo");
        String respuestaDeporte=sc.next();
        Deporte d = null;

        switch (respuestaDeporte){
            case "N":
                d=Deporte.Natacion;
                break;
            case "n":
                d=Deporte.Natacion;
                break;
            case "R":
                d=Deporte.Remo;
                break;
            case "r":
                d=Deporte.Remo;
                break;
            case "V":
                d=Deporte.Vela;
                break;
            case "v":
                d=Deporte.Vela;
                break;
            case "W":
                d=Deporte.Waterpolo;
                break;
            case "w":
                d=Deporte.Waterpolo;
                break;
            default:
                System.out.println("Respuesta incorrecta se pone natacion por defecto");
                d=Deporte.Natacion;
                break;

        }
        Deportistas depor=new Deportistas(dni,nombre,fechaNac,d);
        deportistas.add(depor);


    }

    public static void verDeportistas(List<Deportistas> deportistas){
        for (Deportistas d:deportistas){
            System.out.println("DNI: "+d.getDNI()+" Nombre: "+ d.getNombre()+" Fecha Nacimiento: "+ d.getFecha_nacimiento()+" Deporte: "+d.getDeporte());
            System.out.println("");
        }
    }

    public static void bajaDeportistas(List<Deportistas> deportistas){
        System.out.println("--------- Formulario Baja ---------\n");
        int res;
        do {
            System.out.println("1: Baja\n2: Ver Deportistas");
    Scanner sc =new Scanner(System.in);
        res=sc.nextInt();
        switch (res){
            case 1:
                System.out.println("dime el Dni del Deportista que quieres dar de Baja:");
                String baja=sc.next();
                boolean borrado=false;
                for (Deportistas d:deportistas){
                    if (d.getDNI().equals(baja)){
                        deportistas.remove(d);
                        borrado=true;
                    }
                }
                if (borrado){
                    System.out.println("Usuario Borrado");
                }else {
                    System.out.println("Ningun usuario ha sido borrado");
                }
                break;
            case 2:
                verDeportistas(deportistas);
               break;


        }


}while (res!=1);


    }

    public static void modificarDeportistas(List<Deportistas> deportistas){

        System.out.println("------- Modificar Deportistas -------");
        System.out.println("");
        Scanner sc =new Scanner(System.in);

        System.out.println("Lista de Deportistas");
        verDeportistas(deportistas);
        System.out.println("");

        System.out.println("Dime el Dni del que quieres Modificar");
        String dni=sc.next();

        for (Deportistas d:deportistas){
            if (d.getDNI().equals(dni)){

                System.out.println("Dime el Nombre");
                String nombre=sc.next();

                System.out.println("Dime la fecha de Nacimiento (01-01-2000)");
                String fechaNac=sc.next();

                System.out.println("Dime el deporte que practica indicando la letra\n- N: natacion\n- R: Remo\n- V: Vela\n- W: Waterpolo");
                String respuestaDeporte=sc.next();
                Deporte depor = null;

                switch (respuestaDeporte){
                    case "N":
                        depor=Deporte.Natacion;
                        break;
                    case "n":
                        depor=Deporte.Natacion;
                        break;
                    case "R":
                        depor=Deporte.Remo;
                        break;
                    case "r":
                        depor=Deporte.Remo;
                        break;
                    case "V":
                        depor=Deporte.Vela;
                        break;
                    case "v":
                        depor=Deporte.Vela;
                        break;
                    case "W":
                        depor=Deporte.Waterpolo;
                        break;
                    case "w":
                        depor=Deporte.Waterpolo;
                        break;
                    default:
                        System.out.println("Respuesta incorrecta no se cambia");
                        depor=d.getDeporte();
                        break;

                }
                d.setNombre(nombre);
                d.setFecha_nacimiento(fechaNac);
                d.setDeporte(depor);

            }else {
                System.out.println("No se encontro ese Dni");
            }
        }

    }

    public static void listarAlfabetico(List<Deportistas> deportistas){
        deportistas.sort((d1,d2)->d1.getNombre().compareTo(d2.getNombre()));

        verDeportistas(deportistas);
    }

    public static void listarFechaNacimiento(List<Deportistas> deportistas){
        deportistas.sort((d1,d2)->d1.getFecha_nacimiento().compareTo(d2.getFecha_nacimiento()));

        verDeportistas(deportistas);
    }
    public static void main(String[] args) {
Scanner sc= new Scanner(System.in);
List<Deportistas> deportistas= new ArrayList<>();

int res=0;
        do {
            System.out.println("Acciones Deportistas");
            System.out.println(" 1: Alta \n 2: Baja \n 3: Modificar \n 4: Orden Nombre \n 5: Orden Fecha Nacimineto \n 6: Salir");

           res=sc.nextInt();

           switch (res){
               case 1:
                   altaDeportistas(deportistas);
                    break;
               case 2:
                   bajaDeportistas(deportistas);
                   break;
               case 3:
                   modificarDeportistas(deportistas);
                   break;
               case 4:
                   listarAlfabetico(deportistas);
                   break;
               case 5:
                   listarFechaNacimiento(deportistas);
                   break;
               case 6:
                   System.out.println("Adiooooooos");
           }


        }while (res!=6);
    }
}