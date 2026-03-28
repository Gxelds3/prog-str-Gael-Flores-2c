package utez.edu.mx.cycles;

import java.util.Scanner;

// Un blucle es una estructura que puede repetirse N
// cantidad de veces y existe el:
// While, Do while, For
public class Cycles {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cycleWhile();
    }

    /*Bucle que se puede repetir de 0 a N cantidad de veces*/
    private static void cycleWhile(){
        final int HIDDEN = 4;
        int answer = 0;

        // El bucle se repetira miesntras la exprecion sea verdadera
        while (answer != HIDDEN) {
            System.out.println("Adivina el numero");
            answer = sc.nextInt();

            if (answer == HIDDEN){
                System.out.println("Exelente! adivinaste el numero...");
            } else {
                System.out.println("Intenta de nuevo...");
            }
        }
    }
}
