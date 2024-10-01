import java.util.ArrayList;
import java.util.Scanner;
public class ParqueBomberos {

    private int id;
    private ArrayList<Avisos> avisos;
    private ArrayList<Bomberos> listaBomberos;



    private enum Avisos {
        FUEGO, ACCIDENTE, INUNDACION, OTROS
    }
    Bomberos b1=new Bomberos(1,"Alejo Basilio Alfonso", 20, Bomberos.Rango.CABO);
    Bomberos b2=new Bomberos(2,"Desiree Valle Caballero", 20, Bomberos.Rango.RASO);
    Bomberos b3=new Bomberos(3,"Raul Sanchez Polan", 20, Bomberos.Rango.OFICIAL);


    public ParqueBomberos(int id) {
        this.id = id;
        this.avisos = new ArrayList<>();
        this.listaBomberos = new ArrayList<>();
        this.avisos.add(Avisos.FUEGO);
        this.avisos.add(Avisos.INUNDACION);
        this.avisos.add(Avisos.OTROS);
        this.listaBomberos.add(b1);
        this.listaBomberos.add(b2);
        this.listaBomberos.add(b3);
    }

    public void anadirAviso(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Que tipo de aviso quieres añadir:\n" +
                "1 -- Fuego\n" +
                "2 -- Accidente\n" +
                "3 -- Inundacion\n" +
                "4 -- Otros");
        int numEleg= sc.nextInt();
        switch (numEleg){
            case 1:
                avisos.add(Avisos.FUEGO);
                System.out.println("Aviso de Fuego añadido");
                break;
            case 2:
                avisos.add(Avisos.ACCIDENTE);
                System.out.println("Aviso de Accidente añadido");

                break;
            case 3:
                avisos.add(Avisos.INUNDACION);
                System.out.println("Aviso de Inundación añadido");

                break;
            case 4:
                avisos.add(Avisos.OTROS);
                System.out.println("Aviso de Otros añadido");
                break;
            default:
                System.out.println("Número no valido");
                break;
        }


    }

    public void tratarAviso(){
        String aviso= String.valueOf(avisos.get(0));
        System.out.println(aviso);
        boolean banderabom=false;
        if (aviso=="FUEGO" || aviso=="ACCIDENTES"){
            for (int i=0; i<listaBomberos.size()&&banderabom==false;i++){
                Bomberos b=listaBomberos.get(i);
                if (String.valueOf(b.getRango())=="CABO"){
                    System.out.println("Aviso resuelto por el Cabo: "+b.getNombreCompleto().toString());
                    banderabom=true;
                    avisos.remove(0);
                }
            }
            if (banderabom == false) {
                System.out.println("“POR FAVOR INTRODUCE BOMBEROS\n" +
                        "ADECUADOS PARA TODOS LOS AVISOS”");
            }
        } else if (aviso=="INUNDACION") {
            for (int i=0; i<listaBomberos.size()&&banderabom==false;i++){
                Bomberos b=listaBomberos.get(i);
                if (String.valueOf(b.getRango())=="OFICIAL"){
                    System.out.println("Aviso resuelto por el Oficial: "+b.getNombreCompleto().toString());
                    banderabom=true;
                    avisos.remove(0);

                }
            }
            if (banderabom == false) {
                System.out.println("“POR FAVOR INTRODUCE BOMBEROS\n" +
                        "ADECUADOS PARA TODOS LOS AVISOS”");
            }
        }else {
            for (int i=0; i<listaBomberos.size()&&banderabom==false;i++){
                Bomberos b=listaBomberos.get(i);
                if (String.valueOf(b.getRango())=="RASO"){
                    System.out.println("Aviso resuelto por el Raso: "+b.getNombreCompleto().toString());
                    banderabom=true;
                    avisos.remove(0);

                }
            }
            if (banderabom == false) {
                System.out.println("“POR FAVOR INTRODUCE BOMBEROS\n" +
                        "ADECUADOS PARA TODOS LOS AVISOS”");
            }
        }

    }

    public void mostrarBomberos(){
        for (int i=0; i<listaBomberos.size();i++){
            Bomberos b=listaBomberos.get(i);
            System.out.println("ID: "+b.getId()+" -- Nombre Completo: "+b.getNombreCompleto()+ " Edad: "+b.getEdad()+" Rango: "+b.getRango());
        }
    }
}
