public class Bomberos {
    private int id;
    private String nombreCompleto;
    private int edad;
    private Rango rango;

    public Bomberos(int id, String nombreCompleto, int edad, Rango rango) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.rango = rango;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    enum Rango{BOMBERO,RASO, CABO, OFICIAL}
}
