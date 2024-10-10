import org.w3c.dom.Document;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static String RUTA_FICHERO="Dataset"+ File.separator+"deportistas.xml";


    public static void altaDeportistas(List<Deportistas> deportistas){
        GestionFicheros.guardarDeportistas(deportistas);
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

        try{
            DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
            DocumentBuilder dBulider  =  dbFactory.newDocumentBuilder();
            try {
                Document doc=dBulider.parse(new File(RUTA_FICHERO));
                Element deportistaNuevo=doc.createElement("Deportista");

                Element elementoDni=doc.createElement("Dni");
                elementoDni.appendChild(doc.createTextNode(dni));
                deportistaNuevo.appendChild(elementoDni);

                Element elementoNombre=doc.createElement("Nombre");
                elementoNombre.appendChild(doc.createTextNode(nombre));
                deportistaNuevo.appendChild(elementoNombre);

                Element elementoFecha=doc.createElement("FechaNacimiento");
                elementoFecha.appendChild(doc.createTextNode(fechaNac));
                deportistaNuevo.appendChild(elementoFecha);

                Element elementoDeporte=doc.createElement("Deporte");
                elementoDeporte.appendChild(doc.createTextNode(String.valueOf(d)));
                deportistaNuevo.appendChild(elementoDeporte);

                NodeList DeportistasLista= doc.getElementsByTagName("Deportistas");

                Element deportista=(Element) DeportistasLista.item(0);
                deportista.appendChild(deportistaNuevo);


                try {
                    TransformerFactory tfFactory= TransformerFactory.newInstance();
                    Transformer  transformer = tfFactory.newTransformer();
                    DOMSource source= new DOMSource(doc);
                    StreamResult result=new StreamResult(new File(RUTA_FICHERO));
                    transformer.transform(source,result);
                } catch (TransformerConfigurationException e) {
                    throw new RuntimeException(e);
                } catch (TransformerException e) {
                    throw new RuntimeException(e);
                }


            } catch (SAXException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }



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



                try {
                    DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBulider  = dbFactory.newDocumentBuilder();
                    Document doc=dBulider.parse(new File(RUTA_FICHERO));
                    doc.getDocumentElement().normalize();

                    NodeList listaDeportistas=doc.getElementsByTagName("Deportista");

                    for (int i=0; i<listaDeportistas.getLength();i++){
                        Node nodoDeportita=listaDeportistas .item(i);
                        nodoDeportita.getAttributes();

                        if (nodoDeportita.getNodeType()==Node.ELEMENT_NODE){

                            Element deportista= (Element) nodoDeportita;

                            String dni= deportista.getElementsByTagName("Dni").item(0).getTextContent();

                            if (baja.equals(dni)){

                                nodoDeportita.getParentNode().removeChild(nodoDeportita);
                                borrado=true;
                            }
                        }

                    }

                    if (borrado) {
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult result = new StreamResult(new File(RUTA_FICHERO));
                        transformer.transform(source, result);
                    }

                } catch (ParserConfigurationException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (SAXException e) {
                    throw new RuntimeException(e);
                } catch (TransformerConfigurationException e) {
                    throw new RuntimeException(e);
                } catch (TransformerException e) {
                    throw new RuntimeException(e);
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
        String dnibaja=sc.next();

        try {
            DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
            DocumentBuilder dBulider  = dbFactory.newDocumentBuilder();
            Document doc=dBulider.parse(new File(RUTA_FICHERO));
            doc.getDocumentElement().normalize();

            NodeList listaDeportistas=doc.getElementsByTagName("Deportista");

            for (int i=0; i<listaDeportistas.getLength();i++){
                Node nodoDeportita=listaDeportistas .item(i);
                nodoDeportita.getAttributes();

                if (nodoDeportita.getNodeType()==Node.ELEMENT_NODE){

                    Element deportista= (Element) nodoDeportita;

                    String dni= deportista.getElementsByTagName("Dni").item(0).getTextContent();

                    if (dnibaja.equals(dni)){
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
                                depor= Deporte.valueOf(deportista.getElementsByTagName("Deporte").item(0).getTextContent());
                                break;

                        }

                        deportista.getElementsByTagName("Nombre").item(0).setTextContent(nombre);
                        deportista.getElementsByTagName("FechaNacimiento").item(0).setTextContent(fechaNac);
                        deportista.getElementsByTagName("Deporte").item(0).setTextContent(String.valueOf(depor));



                    }
                }

            }


                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(RUTA_FICHERO));
                transformer.transform(source, result);


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }




    }

    public static void listarAlfabetico(List<Deportistas> deportistas){
        deportistas.sort(Comparator.comparing(Deportistas::getNombre));

        verDeportistas(deportistas);
    }

    public static void listarFechaNacimiento(List<Deportistas> deportistas){
        deportistas.sort(Comparator.comparing(Deportistas::getFecha_nacimiento));

        verDeportistas(deportistas);
    }
    public static void main(String[] args) {
Scanner sc= new Scanner(System.in);
        List<Deportistas> deportistas = new ArrayList<>();
if (GestionFicheros.binarioExiste()){
    GestionFicheros.DeBinarioAXml();
}else if(!GestionFicheros.xmlExiste()){
    GestionFicheros.crearXmlVacio();

}


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
                   GestionFicheros.guardarDeportistas(deportistas);

                   System.out.println("Adiooooooos");
           }


        }while (res!=6);
    }
}