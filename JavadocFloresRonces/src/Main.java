import java.util.Scanner;

public class Main {
    public static double BAJO= 18.5;
    public static double MEDIO=25;
    public static double ALTO=30;
    public static double PI=3.1416;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {

            System.out.println("<<<<<<<<<<Menu>>>>>>>>>>");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular el area de un rectangulo");
            System.out.println("3. Calcular el area de un Circulo");
            System.out.println("4. Conversion de °C a °F");
            System.out.println("5. Salir del programa");
            System.out.print("Ingrese su eleccion: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    double pesoKG = obtenerDouble(sc, "Ingresa el pero en (KG) -> 80");
                    double alturaM = obtenerDouble(sc, "Ingresa la Altura en (M) -> 1.80");
                    double IMC = calcularIMC(pesoKG, alturaM);
                    System.out.println("El IMC es: " + IMC);
                    System.out.println("Clasificación: " + clasificarIMC(IMC));
                    break;
                case 2:
                    double base = obtenerDouble(sc, "Ingrese la base del rectángulo: ");
                    double alturaRectangulo = obtenerDouble(sc, "Ingrese la altura del rectángulo: ");
                    System.out.println("Area del rectángulo: " + areaRectangulo(base, alturaRectangulo));
                    break;
                case 3:
                    double radio = obtenerDouble(sc, "Ingrese el radio del circulo: ");
                    System.out.println("Area del círculo: " + areaCirculo(radio));
                    break;
                case 4:
                    double celsius = obtenerDouble(sc, "Ingrese grados Celsius: ");
                    System.out.println("Resultado en Fahrenheit: " + conversionCelsiusAFahrenheit(celsius));
                    break;
                case 5:
                    System.out.println("Termino el Programa :).");
                    break;
                default:
                    System.out.println("Opcion invalida, vuelva a intentar porfavor.");
            }
            System.out.println();

        } while (choice != 5);
    }

    /**
     * Metodo para obtener un numero double desde la consola
     *  @param sc -> objeto previamente instanciado
     * @param mensaje -> mensaje a mosntrar en consola
     *  @return Numero double ingresado por el usuario*/
    public static double obtenerDouble(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextDouble();
    }

    /**
     * Metodo para calcular y devolver el IMC con con formula peso/altura al cuadrado
     *  @param pesoKG -> expresado en KG (80)
     *  @param alturaM -> expresado en M (1.80)
     *  @return -> returna el calculo de IMC */
    public static double calcularIMC(double pesoKG, double alturaM) {
        return pesoKG / (alturaM * alturaM);
    }

    /**
     * Metodo que devuelve la clasificación basada en el IMC
     * @param IMC -> previamente calculado
     * @return Returna el mensaje de acuerdo al IMC*/
    public static String clasificarIMC(double IMC){
        if(IMC<BAJO) return "Peso Bajo";
        else if(IMC<MEDIO) return "Medio";
        else if(IMC<ALTO) return "Sobre peso";
        else return "Obesidad";
    }

    /**
     * Metodo para calcular el área de un rectangulo
     * @param base   Base del rectangulo
     * @param alturaRectangulo Altura del rectangulo
     * @return Returna el calculo del area del rectangulo */
    public static double areaRectangulo(double base, double alturaRectangulo) {
        return base * alturaRectangulo;
    }

    /**
     * Metodo para calcular el área de un círculo
     * @param radio Radio del círculo
     * @return Returna el calculo del area del cierculo */
    public static double areaCirculo(double radio) {
        return PI * radio * radio;
    }

    /**
     * Metodo para convertir grados Celsius a Fahrenheit
     * @param celsius Temperatura en grados Celsius
     * @return Returna la conversion del calculo
     */
    public static double conversionCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }
}
