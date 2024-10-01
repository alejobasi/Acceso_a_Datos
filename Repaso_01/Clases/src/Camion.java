public class Camion {

    public static final double PESO_UN_EJE = 4.5;
    public static final int PESO_DOS_EJES = 18;
    public static final int PESO_TRES_EJES = 25;
    public static final int PESO_CINCO_EJES = 40;
    public static int contCamiones;
    public static int id=1;
    public static int kmsRecorridosTotales;
    private  String matricula;
    private Marca marca;
    private int peso;
    private int kmActuales;
    private int consumo;
    private  int capacidadMaxima;
    private int combustibleActual;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Camion.id = id;
    }


    public Camion(String s, int i, int i1, Object pesoUnEje) {
        combustibleActual=180;
        consumo=20;
        contCamiones++;
        id+=contCamiones;
    }

    public int calcularKmDisponibles(){
        int kmRestantes=combustibleActual*100/consumo;

        if (peso>=PESO_DOS_EJES){
            kmRestantes-=50;
        } else if (peso>=PESO_TRES_EJES) {
            kmRestantes-=75;

            
        } else if (peso>=PESO_CINCO_EJES) {
            kmRestantes-=100;

        }

        if (kmRestantes<0){
            return 0;
        }else {
            return kmRestantes;
        }

    }

    public static Camion masAntiguo(Camion c1, Camion c2) {
        if (c1.kmsRecorridosTotales>c2.kmsRecorridosTotales){
            return c1;
        }else {
            return c2;
        }

    }

    public double repostarCombustible(int cant, double precio) {
        double gasto=0;
        if (combustibleActual+cant<capacidadMaxima) {
            private enum Marca {
                SCANIA, MAN, MERCEDES, BENZ , NISSAN
            }
            gasto = cant * precio;
        }else {
            gasto= (capacidadMaxima-combustibleActual)*precio;
        }
        return gasto;
    }

    public void realizarViaje(int km) {
        int kmDisponibles=calcularKmDisponibles();
        if (km>kmDisponibles){
            System.out.println("ERROR: No dispone de combustible suficiente");
        }else {
            System.out.println("Viaje realizado");
            kmsRecorridosTotales+=km;
        }
    }





    public Camion(String matricula, int capacidadMaxima, int marca) {

        combustibleActual=180;
        consumo=20;
        contCamiones++;
        id+=contCamiones;
    }

    public Camion(String matricula) {

        combustibleActual=180;
        consumo=20;
        contCamiones++;
        id+=contCamiones;
        capacidadMaxima=200;
        marca=Marca.NISSAN;
        Object pesoDosEjes = Camion.PESO_DOS_EJES;
    }
}
