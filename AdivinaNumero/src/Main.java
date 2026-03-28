import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 1;
        int max = 100;
        int intentos = 0;
        int limiteIntentos = 7;
        boolean gano = false;

        Random random = new Random();
        int secreto = random.nextInt(100) + 1;

        System.out.println("Adivina el numero del 1 al 100. Limite: " + limiteIntentos + " para lograrlo");

        while (intentos < limiteIntentos){
            int numero = obtenerNumeroValido("Intento: " + (intentos + 1), sc, min, max);
            intentos++;

            if (numero == secreto){
                System.out.println("Felicidades ganaste en el intento " + intentos);
                gano = true;
                break;
            } else if (numero > secreto) {
                System.out.println("El numero secreto es menor a " + numero);
            } else {
                System.out.println("El numero es mayor a " + numero);
            }
        }

        if (!gano){
            System.out.println("Perdiste, el numero secreto era: " + secreto);
        }
    }

    public static int obtenerNumeroValido(String mensaje, Scanner sc, int min, int max){
        int entrada;
        while (true){
            System.out.println(mensaje);
            if (sc.hasNextInt()){
                entrada = sc.nextInt();
                if (entrada >= min && entrada <= max){
                    return entrada;
                }
                System.out.println("El numero ingresado esta fuera del rango :(, solo numeros del 1 al 100");
            } else {
                System.out.println("El dato ingresado no es numerico");
                sc.next();
            }
        }
    }
}
