import java.util.Random;
public class vector1 {
    public static void main(String[] args) {

        Random rand = new Random();
        int int_random = rand.nextInt(31);

        int[] vector = new int[9];
        //int[] vector2={1111, 112, 14, 10, 5, 3};
        for (int i=0; i<9;i++){
            vector[i]=rand.nextInt(31);
            System.out.println(vector[i]);
        }


        boolean banderaasc=false;
        boolean banderades=false;
       for (int j=1;j<vector.length ;j++){

           if (vector[j-1]<vector[j]&& banderades== false){
               banderades=true;

           }else if (vector[j-1]>vector[j] && banderaasc==false){
               banderaasc=true;
           }
       }
       if (banderades== true&& banderaasc==true){
           System.out.println("Está desordenado");
       }else if (banderades== true&& banderaasc==false){
           System.out.println("Está ordenado ascendetemente");
       }else {
           System.out.println("Está ordenado descente");
       }

    }
}