import java.util.Scanner;
public class ejer1 {
    static Scanner num_sc= new Scanner(System.in);
    public static void main(String[] args) {



        System.out.println("Dime la altura de la figura");
        int numero = num_sc.nextInt();

        for (int i =1; i<=numero;i++){
            System.out.println();
            for (int j=i ; j<=numero; j++){
                System.out.print(i);
            }

        }
    }
}