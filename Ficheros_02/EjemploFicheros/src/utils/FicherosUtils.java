package utils;

import model.Coche;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FicherosUtils {

    private final static String RUTA_FICHERO_CONF = "resources/concesionario.xml";
    private final static String DIRECTORIO_FICHERO = "resources";

    public static void crearFichero() {
        Path pathFichero = Paths.get(RUTA_FICHERO_CONF);
        Path pathDirectorio = Paths.get(DIRECTORIO_FICHERO);

        if (Files.exists(pathFichero)) {
            System.out.println("Ya existe el fichero en la ruta especificada.");
            return;
        }

        try {
            // Si no existe el directorio
            if (!Files.isDirectory(pathDirectorio)) {
                Files.createDirectory(pathDirectorio);
            }
            Files.createFile(pathFichero);

            rellenarContenido();
        } catch (IOException e) {
            System.out.println("Error en la creación del fichero.");
            throw new RuntimeException(e);
        }
    }

    private static Document inicializarDocumentBuilder() throws Exception {
        // Declaramos las clases necesarias para DOM
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(RUTA_FICHERO_CONF));

        return doc;
    }

    private static void rellenarContenido() {
        try {
            // Declaramos las clases necesarias para DOM
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Definimos el elemento raíz
            Element root = doc.createElement("concesionario");
            doc.appendChild(root);

            // Definimos el nodo que contiene los valores del coche
            Element coche = doc.createElement("coche");
            coche.setAttribute("id", "1");
            root.appendChild(coche);

            // Definimos cada uno de los hijos de coche y le asignamos valor
            Element marca = doc.createElement("marca");
            marca.appendChild(doc.createTextNode("Renault"));
            coche.appendChild(marca);

            Element modelo = doc.createElement("modelo");
            modelo.appendChild(doc.createTextNode("Megan"));
            coche.appendChild(modelo);

            Element cilindrada = doc.createElement("cilindrada");
            cilindrada.appendChild(doc.createTextNode("1.5"));
            coche.appendChild(cilindrada);

            // TODO: Confirmamos los cambios en el archivo XML mediante Transformer...



            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(RUTA_FICHERO_CONF));

            transformer.transform(source, result);
        } catch (Exception e) {
            System.out.println("No se ha podido escribir en el fichero.");
            throw new RuntimeException(e);
        }
    }

    public static void lecturaConcesionario() {
        try {
            Document doc = inicializarDocumentBuilder();

            // Normalizamos el archivo XML
            doc.getDocumentElement().normalize();

            System.out.println("El elemento raíz es: " + doc.getDocumentElement().getTagName());

            // Obtenemos todos los elementos "coche" (elemento complejo)
            NodeList listaCoches = doc.getElementsByTagName("coche");
            System.out.println("Número de coches: " + listaCoches.getLength());

            // Procesamos cada uno de los coches
            for (int i = 0; i < listaCoches.getLength(); i++) {
                // Recuperamos el nodo en la posicion i
                Node nodoCoche = listaCoches.item(i);
                nodoCoche.getAttributes();

                // Nos aseguramos que el nodo es un elemento (y no es, por ejemplo, un comentario)
                if (nodoCoche.getNodeType() == Node.ELEMENT_NODE) {
                    // Convertimos el nodo a Element para poder procesarlo
                    Element coche = (Element) nodoCoche;

                    // Recuperamos el atributo id
                    String id = coche.getAttribute("id");

                    // Recuperamos los elementos simples
                    String marca = coche.getElementsByTagName("marca").item(0).getTextContent();
                    String modelo = coche.getElementsByTagName("modelo").item(0).getTextContent();
                    double cilindrada = Double.parseDouble(coche.getElementsByTagName("cilindrada").item(0).getTextContent());

                    System.out.println("Coche " + id + ". Marca: " + marca + ". Modelo: " + modelo + ". Clindrada: " + cilindrada);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void escrituraConcesionario() {

        try {
            Document doc = inicializarDocumentBuilder();

            // Creamos el elemento coche
            Element cocheNuevo = doc.createElement("coche");
            cocheNuevo.setAttribute("id", "4");

            // Creamos el elemento marca
            Element marca = doc.createElement("marca");
            // Le añadimos el valor como nodo de texto
            marca.appendChild(doc.createTextNode("Toyota"));
            // Incluimos la marca como elemento hijo de coche
            cocheNuevo.appendChild(marca);

            // Mismo proceso para el resto de hijos de coche
            Element modelo = doc.createElement("modelo");
            modelo.appendChild(doc.createTextNode("Corola"));
            cocheNuevo.appendChild(modelo);

            Element cilindrada = doc.createElement("cilindrada");
            cilindrada.appendChild(doc.createTextNode("1.8"));
            cocheNuevo.appendChild(cilindrada);

            // Añadimos el nuevo coche como hijo del elemento raíz concesionario
            // Recuperamos todos los nodos con nombre concesionario
            NodeList concesionarioList = doc.getElementsByTagName("concesionario");
            // Sabemos que solo hay un nodo concesionario por lo que recuperamos el elemento
            Element concesionario = (Element) concesionarioList.item(0);
            concesionario.appendChild(cocheNuevo);

            // Guardar los cambios en el fichero XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(RUTA_FICHERO_CONF));
            transformer.transform(source, result);

            System.out.println("Se ha añadido un coche");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
