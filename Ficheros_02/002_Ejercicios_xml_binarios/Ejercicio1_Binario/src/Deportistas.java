import java.io.Serializable;

public class Deportistas implements Serializable {
    private String DNI;
    private String nombre;
    private String fecha_nacimiento;
    private Deporte deporte;

    public Deportistas(String DNI, String nombre, String fecha_nacimiento, Deporte deporte) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.deporte = deporte;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }


}
