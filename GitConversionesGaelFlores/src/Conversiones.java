import java.util.Scanner;

public class Conversiones {
    public static double MI = 0.621371;
    public static double KM = 1.60934;

    public static int TOTAL = 0;
    public static int cAF = 0;
    public static int fAC = 0;
    public static int kmAMi = 0;
    public static int miAKm = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("<<<<<<<<<<Menu de Conversiones>>>>>>>>>>");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir del programa");
            System.out.print("Ingrese su eleccion: ");
            choice = obtenerEntero(sc);

            switch (choice) {
                case 1:
                    double celsius = obtenerDouble(sc, "Ingrese grados Celsius: ");
                    System.out.println("Resultado en Fahrenheit: " + conversionCelsiusAFahrenheit(celsius));
                    cAF++;
                    break;
                case 2:
                    double fahrenheit = obtenerDouble(sc, "Ingrese grados Fahrenheit: ");
                    System.out.println("Resultado en Celsius: " + conversionFahrenheitACelsius(fahrenheit));
                    fAC++;
                    break;
                case 3:
                    double kilometros = obtenerDouble(sc, "Ingrese los kilometros: ");
                    System.out.println("Resultado en Millas: " + conversionKmAMillas(kilometros));
                    kmAMi++;
                    break;
                case 4:
                    double millas = obtenerDouble(sc, "Ingrese las millas: ");
                    System.out.println("Resultado en Kilometros: " + conversionMillasAKm(millas));
                    miAKm++;
                    break;
                case 5:
                    System.out.println("Termino el Programa :).");
                    break;
                default:
                    System.out.println("Opcion invalida, vuelva a intentar por favor.");
            }
            System.out.println();

        } while (choice != 5);

        TOTAL = cAF + fAC + kmAMi + miAKm;
        System.out.println("<<<<<< RESUMEN >>>>>>");
        System.out.println("Total de conversiones: " + TOTAL);
        System.out.println("°C a °F: " + cAF);
        System.out.println("°F a °C: " + fAC);
        System.out.println("Km a Millas: " + kmAMi);
        System.out.println("Millas a Km: " + miAKm);
    }

    /**
     * Metodo para obtener un numero double desde la consola y validar solo valores numericos
     * @param sc -> objeto previamente instanciado
     * @param mensaje -> mensaje a mostrar en consola
     * @return -> Numero double ingresado por el usuario
     */
    public static double obtenerDouble(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        if (!sc.hasNextDouble()) {
            System.out.print("Error. Solo valores numericos: ");
            sc.next();
            return obtenerDouble(sc, mensaje);
        }
        return sc.nextDouble();
    }

    /**
     * Metodo para Solo resivir valores numericos en el menu
     * @param sc -> objeto previamente instanciado
     * @return -> Numero double ingresado por el usuario
     */
    public static int obtenerEntero(Scanner sc) {
        if (!sc.hasNextInt()) {
            System.out.print("Error. Solo valores numericos: ");
            sc.next();
            return obtenerEntero(sc);
        }
        return sc.nextInt();
    }

    /**
     * Metodo para convertir grados Celsius a Fahrenheit
     * @param celsius -> Temperatura en grados Celsius
     * @return -> Retorna la conversion del calculo
     */
    public static double conversionCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Metodo para convertir Fahrenheit a grados celsius
     * @param fahrenheit -> temperatura en grados Fahrenheit
     * @return -> retorna la conversion de °F a °C
     */
    public static double conversionFahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }

    /**
     * Metodo para conversion de km a millas
     * @param kilometros -> Valor de km
     * @return -> retorna la conversion de km a millas
     */
    public static double conversionKmAMillas(double kilometros) {
        return kilometros * MI;
    }

    /**
     * Metodo para conversion de millas a km
     * @param millas -> Valor de millas
     * @return -> retorna la conversion de millas a Km
     */
    public static double conversionMillasAKm(double millas) {
        return millas * KM;
    }
}