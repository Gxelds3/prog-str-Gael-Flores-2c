import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("<<<<<Menu>>>>>");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");
        System.out.println("Elija una opcion del menu");
        opcion = sc.nextInt();

        switch (opcion) {

            case 1:
                double variableA = obtenerDouble(sc, "Ingrese el 1er valor: ");
                double variableB = obtenerDouble(sc, "Ingrese el 2do valor: ");
                double suma = calcularSuma(variableA, variableB);
                System.out.println("Opcion elegida suma +");
                System.out.println("Valores ingresados: " + variableA + " y " + variableB);
                System.out.println("La suma es: " + suma);
                break;

            case 2:
                variableA = obtenerDouble(sc, "Ingrese el 1er valor: ");
                variableB = obtenerDouble(sc, "Ingrese el 2do valor: ");
                double resta = calcularResta(variableA, variableB);
                System.out.println("Opcion elegida Resta -");
                System.out.println("Valores ingresados: " + variableA + " y " + variableB);
                System.out.println("La resta es: " + resta);
                break;

            case 3:
                variableA = obtenerDouble(sc, "Ingrese el 1er valor: ");
                variableB = obtenerDouble(sc, "Ingrese el 2do valor: ");
                double multiplicacion = calcularMultiplicacion(variableA, variableB);
                System.out.println("Opcion elegida multiplicacion *");
                System.out.println("Valores ingresados: " + variableA + " 2do " + variableB);
                System.out.println("La multiplicacion es: " + multiplicacion);
                break;

            case 4:
                variableA = obtenerDouble(sc, "Ingrese el 1er valor: ");
                variableB = obtenerDouble(sc, "Ingrese el 2do valor: ");
                double division = calcularDivision(variableA, variableB);
                System.out.println("Opcion elegida division /");
                System.out.println("Valores ingresados: " + variableA + " 2do " + variableB);
                System.out.println("La division es: " + division);
                break;

            default:
                System.out.println("Opcion invalida");
        }
    }

    public static double obtenerDouble(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextDouble();
    }
    public static double calcularSuma(double variableA, double variableB) {
        return variableA + variableB;
    }

    public static double calcularResta(double variableA, double variableB) {
        return variableA - variableB;
    }

    public static double calcularMultiplicacion(double variableA, double variableB) {
        return variableA * variableB;
    }

    public static double calcularDivision(double variableA, double variableB) {
        if (variableB == 0) {
            System.out.println("No se puede dividir entre 0");
        }
        return variableA / variableB;
    }
}
