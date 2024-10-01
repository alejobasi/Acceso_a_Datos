import java.util.Scanner;



public class Main {
    static int[][] valores = {
            {50, 24, 200, 304},
            {1, 0, 10, 36},
            {0, 0, 59, 8},
            {15, 18, 7, 12}
    };
 static    String[] alimentos={"Fruta","Zumo", "Pizza", "Cereales" };
    String[] prpiedades={"Calorías","Grasas", "Colesterol", "Azúcares" };
    public static void masSano(){
int total = 0;
int numMaxMasSano=0;
int numMasSano=0;
        int totalmax=0;
        boolean bandera=false;

        for (int i=0; i<valores[0].length; i++){
        total=0;
            for (int j=1; j<valores.length; j++){
                total+=valores[j][i];
            }

            total=total/3;
            if (bandera==false){
                numMaxMasSano=total;
                bandera=true;
                numMasSano=i;
                totalmax=total;
            }else {

            if(total<numMaxMasSano){
                numMasSano=i;
                 totalmax=total;


            }
            }
            numMaxMasSano=totalmax;
        }
        System.out.println("El Alimento más sano es: "+alimentos[numMasSano]+ " con "+ totalmax);
    }
    public static void clasificacionNutriScore(){

        for (int col=0; col<valores.length;col++){
            int suma=valores[0][col]-(valores[3][col]+valores[1][col]*valores[2][col]);
            //System.out.println("Calorias: "+valores[0][col]);
            //System.out.println("Grasas: "+valores[1][col]);
            //System.out.println("Colesterol: "+valores[2][col]);
            //System.out.println("Azucares: "+valores[3][col]);
            //System.out.println("Suma: "+suma);

            if (suma>=10){
                System.out.println("ALIMENTO => "+alimentos[col]+" CLASIFICACION => A");
            }else if (suma>5){
                System.out.println("ALIMENTO => "+alimentos[col]+" CLASIFICACION => B");

            }else if (suma>2){
                System.out.println("ALIMENTO => "+alimentos[col]+" CLASIFICACION => C");

            }else if (suma>=0){
                System.out.println("ALIMENTO => "+alimentos[col]+" CLASIFICACION => D");

            }else {
                System.out.println("ALIMENTO => "+alimentos[col]+" CLASIFICACION => E");

            }
        }

    }

    public static void masMenosEnergia(){
        int numMaxEnergia=0;
        int numMinEnergia=0;
        int alimentoMin=0;
        int alimentoMax=0;
        boolean banderamin=false;

        for (int col=0; col<valores.length;col++){
            int energia=valores[0][col]-valores[3][col];

            if (energia>numMaxEnergia){
                numMaxEnergia=energia;
                alimentoMax=col;
            }
            if (banderamin==false){
                numMinEnergia=energia;
                alimentoMin=col;
                banderamin=true;
            }else if (energia<numMinEnergia){
                numMinEnergia=energia;
                alimentoMin=col;
            }

        }
        System.out.println("ALIMENTOS CON MAYOR Y MENOR APORTE ENERGETICO:");
        System.out.println("- MAYOR aporte energetico: "+alimentos[alimentoMax]+ " - "+ numMaxEnergia +" Kj");
        System.out.println("- MENOR aporte energetico: "+alimentos[alimentoMin]+ " - "+ numMinEnergia +" Kj");

    }

    public static void crud(){
        boolean banderaCrud=false;
        do {


        System.out.println("----- Menú de Opciones -----");
        System.out.println("1. ALIMENTO MÁS SANO");
        System.out.println("2. CLASIFICACIÓN NUTISCORE");
        System.out.println("3. ALIMENTOS CON MAYOR Y MENOR ENERGIA");
        System.out.println("4. SALIR");

        Scanner sc=new Scanner(System.in);
        int respuesta=sc.nextInt();

        if (respuesta==1){
            masSano();
        } else if (respuesta==2) {
            clasificacionNutriScore();
        } else if (respuesta==3) {
            masMenosEnergia();
        } else if (respuesta==4) {
            banderaCrud=true;
        }else {
            System.out.println("Valor no valido");
        }

        }while (banderaCrud==false);


}
    public static void main(String[] args) {
    crud();


    }
}