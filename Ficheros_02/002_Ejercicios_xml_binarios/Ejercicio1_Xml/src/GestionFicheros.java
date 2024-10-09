import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
    public static String RUTA_FICHERO_XML=RUTA_DIRECTORIO+ File.separator+"deportistas.xml";

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
        List<Deportistas> deportistas = new ArrayList<>();  // Inicializamos una lista vacía

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
    public static void DeBinarioAXml(){
        Path pathRutaBinario=Paths.get(RUTA_FICHERO);
        Path pathRutaXml=Paths.get(RUTA_FICHERO_XML);

        if (Files.exists(pathRutaBinario)){

            List<Deportistas> depo=recuperarDeportistas();
            try {
                Files.createFile(pathRutaXml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
                DocumentBuilder dBulider= dbFactory.newDocumentBuilder();
                Document doc=dBulider.newDocument();

                Element elementoPrincipal= doc.createElement("Deportistas");
                doc.appendChild(elementoPrincipal);

                for (Deportistas deportista: depo){
                    Element elementoDeportista= doc.createElement("Deportista");
                    elementoDeportista.appendChild(elementoDeportista);

                    Element elementoDni=doc.createElement("Dni");
                    elementoDni.appendChild(doc.createTextNode(deportista.getDNI()));
                    elementoDeportista.appendChild(elementoDni);

                    Element elementoNombre=doc.createElement("Nombre");
                    elementoNombre.appendChild(doc.createTextNode(deportista.getNombre()));
                    elementoDeportista.appendChild(elementoNombre);

                    Element elementoFecha=doc.createElement("FechaNacimiento");
                    elementoFecha.appendChild(doc.createTextNode(deportista.getFecha_nacimiento()));
                    elementoDeportista.appendChild(elementoFecha);

                    Element elementoDeporte=doc.createElement("Deporte");
                    elementoDeporte.appendChild(doc.createTextNode(String.valueOf(deportista.getDeporte())));
                    elementoDeportista.appendChild(elementoDeporte);
                }

                try {
                    TransformerFactory tfFactory= TransformerFactory.newInstance();
                    Transformer transformer=tfFactory.newTransformer();
                    DOMSource source= new DOMSource(doc);
                    StreamResult result=new StreamResult(new File(RUTA_FICHERO_XML));
                    transformer.transform(source,result);
                    Files.delete(pathRutaBinario);
                } catch (TransformerConfigurationException e) {
                    throw new RuntimeException(e);
                } catch (TransformerException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static boolean binarioExiste(){
        Path path=Paths.get(RUTA_FICHERO);
        if (Files.exists(path)){
            return true;

        }else {
            return true;
        }
    }
    public static boolean xmlExiste(){
        Path path=Paths.get(RUTA_FICHERO_XML);
        if (Files.exists(path)){
            return true;

        }else {
            return true;
        }
    }
    public static void crearXmlVacio() {
        Path pathRutaXml = Paths.get(RUTA_FICHERO_XML);
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBulider = dbFactory.newDocumentBuilder();
            Document doc = dBulider.newDocument();

            Element elementoPrincipal = doc.createElement("Deportistas");
            doc.appendChild(elementoPrincipal);

            try {
                TransformerFactory tfFactory= TransformerFactory.newInstance();
                Transformer transformer=tfFactory.newTransformer();
                DOMSource source= new DOMSource(doc);
                StreamResult result=new StreamResult(new File(RUTA_FICHERO_XML));
                transformer.transform(source,result);

            } catch (TransformerConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

    }
    }

