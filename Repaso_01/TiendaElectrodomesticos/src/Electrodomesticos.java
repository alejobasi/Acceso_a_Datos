import java.util.ArrayList;
import java.util.HashMap;

public class Electrodomesticos {

    private int precioBase;
    private int peso;
    private ArrayList<Letras> consumoEnergetico;
    private ArrayList<Color> color;

    public Electrodomesticos() {
        precioBase=100;
        peso=5;
        this.consumoEnergetico = new ArrayList<>();
        this.color = new ArrayList<>();
        this.consumoEnergetico.add(Letras.F);
        this.color.add(Color.blanco);
    }

    public Electrodomesticos(int precioBase, int peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.consumoEnergetico = new ArrayList<>();
        this.color = new ArrayList<>();
        this.consumoEnergetico.add(Letras.F);
        this.color.add(Color.blanco);

    }

    public Electrodomesticos(int precioBase, int peso, ArrayList<Letras> consumoEnergetico, ArrayList<Color> color) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.consumoEnergetico = new ArrayList<>();
        this.color = new ArrayList<>();
    }

    private final Letras comprobarConsumoEnergetico(Letras l){

        for (Letras c :Letras.values()) {
    if (c==l){
        return l;
    }

    }

        return l;
    }

    private mostrarDatos()
}
