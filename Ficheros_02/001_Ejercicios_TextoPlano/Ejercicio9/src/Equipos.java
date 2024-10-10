import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Equipos {

    private String equipo1;
    private int resultado1;
    private String equipo2;
    private int resultado2;

    public Equipos(String equipo1, int resultado1, String equipo2, int resultado2) {
        this.equipo1 = equipo1;
        this.resultado1 = resultado1;
        this.equipo2 = equipo2;
        this.resultado2 = resultado2;
    }

    public Equipos() {
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public int getResultado1() {
        return resultado1;
    }

    public void setResultado1(int resultado1) {
        this.resultado1 = resultado1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getResultado2() {
        return resultado2;
    }

    public void setResultado2(int resultado2) {
        this.resultado2 = resultado2;
    }


}
