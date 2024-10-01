
    import java.util.Scanner;
    public class ejer2 {
        public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);

            System.out.println("Dime el numero del que quieres hacer el factorial:");
            int num= sc.nextInt();
            int num_guar=num;
            for (int i=num-1; i>=1; i--){
                num_guar= num_guar*i;
            }
            System.out.println("El factorial de: "+num+" es: "+num_guar);

        }
    }

