import java.util.Scanner;
public class array1 {



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int[] vector={2, 1, 20,13, 15, 6};

        System.out.println("Dime un número y te diré si se encuntra en mi array");

        int num_usu=sc.nextInt();
        boolean bandera=false;
        for (int i=0; i<vector.length && bandera==false; i++){
            if (num_usu==vector[i]){
                System.out.println("Tú número se encuentra en mi array");
                bandera=true;
            }
        }
        if (bandera) {
            System.out.println("Tú número no se encuentra en mi array");
        }


    }
}