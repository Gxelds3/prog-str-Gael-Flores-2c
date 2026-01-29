//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner sc = new Scanner(System.in);

    int edad = obtenerEdad(sc, "Ingrese su Edad:");
    boolean esEstudiante = obtenerBooleano(sc, "Eres estudiante FALSE/TRUE");
    int tarifa = calcularEdad(edad, esEstudiante);

    System.out.println("La edad ingresada es: " + edad);
    System.out.println("Es estudiante: " + esEstudiante);
    System.out.println("La tarifa es: " + tarifa);
}

/**
 * Metodo para obtener un numero int desde la consola
 * @param sc -> objeto previamente instalado
 * @param mensaje -> mensaje a mostrar en consola
 * @return -> Numero int ingresado por el usuario
 */
public static int obtenerEdad(Scanner sc, String mensaje){
    System.out.print(mensaje);
    return sc.nextInt();
}

/**
 * Metodo para obtener el objeto booleano
 * @param sc -> objeto Scanner
 * @param mensaje -> mensaje a mostrar
 * @return -> Retorna el booleano de si es estudiante o no
 */
public static boolean obtenerBooleano(Scanner sc, String mensaje){
    System.out.print(mensaje);
    return sc.nextBoolean();
}

/**
 * Metodo para calcular la tarifa
 * @param edad -> edad ingresada
 * @param esEstudiante -> Marca si es estudiante o no
 * @return -> retorna la tarifa calculada
 */
public static int calcularEdad(int edad, boolean esEstudiante){
    int tarifa = 0;

    if (edad < 0 || edad > 120){
        System.out.println("Edad invalida.");
    } else if (edad < 12){
        tarifa = 50;
    } else if (edad >= 12 && edad <= 17) {
        if (esEstudiante == true){
            tarifa = 60;
        }else {
            tarifa = 80;
        }
    } else if (edad >= 18) {
        if (esEstudiante == true){
            tarifa = 90;
        } else {
            tarifa = 120;
        }
    }
    return tarifa;

}
