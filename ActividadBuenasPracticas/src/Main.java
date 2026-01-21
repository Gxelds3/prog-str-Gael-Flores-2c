import java.util.Scanner;

public class Main {
    int SUMA = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidad=pedirEntero(sc, "Ingresa la cantidad de numeros a sumar:");
        int resultado=sumarHastaN(cantidad);
        System.out.println("EL Resultado de la Suma total es: " + resultado);
    }

    /**
     * Método para pedir un numero entero al usuario que se sumaran hasta el numero que ingreses
     * @param sc -> Objeto previamente instanciado
     * @param mensaje -> Mensaje a mostrar
     * @return -> Entero ingresado por el usuario
     */
    public static int pedirEntero(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }

    /**
     * Método para sumar los numeros desde 1 hasta la cantidad que ingreso el usuario
     * @param numero -> Cantidad de números a sumar
     * @return -> Resultado de la suma
     */
    public static int sumarHastaN(int numero) {
        int suma = 0;
        for (int i = 1; i <= numero; i++) {
            suma += i;
        }
        return suma;
    }
}
