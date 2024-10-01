import java.util.Scanner;
public class array2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int[] vector={1, 2, 4, 10, 25, 36};

        System.out.println("Dime un número y te diré si se encuntra en mi array");

        int num_usu=sc.nextInt();


        boolean bandera=false;
        for (int i=0; i<vector.length && bandera==false; i++){


            if (num_usu==vector[i]){
                System.out.println("Tú número se encuentra en mi array");

                bandera=true;
            }
            if (vector[i]>num_usu){
                System.out.println("Tú número no se encuentra en mi array, paro en "+ vector[i]);

                bandera=true;
            }

        }
        if (bandera==false) {
            System.out.println("Tú número no se encuentra en mi array");
        }

    }
}
