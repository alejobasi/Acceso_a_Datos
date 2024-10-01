public class vector2 {
    public static int[][] rellenar() {
        int[][] vector = new int[5][15];

        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector[0].length; j++) {
                if (i == 0 || j == 0||j==14 ||i==4) {
                    vector[i][j] = 1;
                } else {
                    vector[i][j] = 0;
                }
            }
        }
        return vector;
    }
    public static void mostrar(int[][] vector) {
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector[0].length; j++) {
                System.out.print(vector[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int vector[][] = vector2.rellenar();
        vector2.mostrar(vector);
    }
}
