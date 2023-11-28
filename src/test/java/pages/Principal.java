package pages;

public class Principal {

    public static void main(String[] args) {

        /*
         * int[] numeros1;
         * numeros1 = new int[5];
         * 
         * int[] numeros2 = new int[5];
         * 
         * System.out.println("Elementos de numeros1");
         * for (int i=0; i<numeros1.length; i++){
         * System.out.println(numeros1[i]);
         * }
         */

        /*
         * int[] numeros3 = {0,1,2,3,4,5,6,7,8,9};
         * 
         * int primerValor = numeros3[6];
         * 
         * System.out.println(primerValor);
         * System.out.println(numeros3[numeros3.length - 1]);
         */

        /*
         * int contador = 0;
         * while(contador < numeros3.length){
         * System.out.println(numeros3[contador]);
         * contador++;
         * }
         */

        int[][] tabla = new int[4][4];

        int[][] tablaValores = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 0, 22, 34, 55 },
                { 77, 88, 34, 23 }
        };

        int elementoDeTabla = tablaValores[1][2];
        System.out.println(elementoDeTabla);
    }

}
