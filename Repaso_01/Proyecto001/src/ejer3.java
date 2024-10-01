import java.util.Scanner;
public class ejer3 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Dime el numero del que quieres que empiece a hacer el factorial:");
        int num= sc.nextInt();

        int num_total=0;
        for (int a=num;a>=0; a--){
            int num_guar=1;
        for (int i=a; i>0; i--){
            num_guar*=i;

        }
        num_total+=num_guar;

        }
        System.out.println("El factorial de todos es: "+num_total);

    }
}
