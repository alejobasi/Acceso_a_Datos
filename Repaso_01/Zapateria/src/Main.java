public class Main {
    public static void main(String[] args) {


        int[][] cantidad = {
                {0, 2, 0, 0, 1, 3},
                {1, 0, 2, 1, 2, 0},
                {3, 0, 1, 2, 1, 2},
                {0, 2, 1, 0, 2, 3}
        };
        String[] locaclidad={"Mérida","Don Benito", "Badajoz", "Cáceres" };
        int[] tallas={35,36, 37, 38, 39, 40};

        int num_unidades = 0;
        int max_num_unidades=0;
        int fila_max_unidades=0;
        for (int i=0; i<cantidad.length; i++){
            num_unidades=0;
            for (int j=0; j<cantidad[0].length; j++){
                num_unidades=num_unidades+cantidad[i][j];

            }

            if (num_unidades>max_num_unidades){
                max_num_unidades=num_unidades;
                fila_max_unidades=i;
            }
    }

        System.out.println("La fila con más número de unidades es: "+ locaclidad[fila_max_unidades]);


        int columna_max_unidades=0;
        int columna_min_unidades=0;
        max_num_unidades=0;
        for (int i=0; i<cantidad[0].length; i++){
            num_unidades=0;
            for (int j=0; j<cantidad.length; j++){
                num_unidades=num_unidades+cantidad[j][i];

            }

            if (num_unidades>max_num_unidades){
                max_num_unidades=num_unidades;
                columna_max_unidades=i;
            }
            if (num_unidades<max_num_unidades){
                max_num_unidades=num_unidades;
                columna_min_unidades=i;
            }
        }
        System.out.println("La talla con más ventas es: "+tallas[columna_max_unidades]);
        System.out.println("La talla con menos ventas es: "+tallas[columna_min_unidades]);


        int fila_menos_unidades=0;
        for (int i=0; i<cantidad.length; i++){
            num_unidades=0;
            for (int j=0; j<cantidad[0].length; j++){

                if (cantidad[i][j]==0){
                    num_unidades++;
                }
            }

            if (num_unidades>max_num_unidades){
                max_num_unidades=num_unidades;
                fila_menos_unidades=i;
            }
        }
        System.out.println("La fila con menos número de unidades es: "+ locaclidad[fila_menos_unidades]);



    }


}