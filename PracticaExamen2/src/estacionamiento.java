import java.util.Scanner;

public class estacionamiento {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int horas = leerHoras("Horas estacionado:", sc);
        double tarifa = leerTarifa("Tarifa por hora:", sc);
        boolean tieneBoleto = leerBoolean("¿Tiene boleto de descuento? (true/false):", sc);

        double subtotal = horas * tarifa;

        double total = aplicarDescuentoHoras(subtotal, horas);
        total = aplicarDescuentoBoleto(total, tieneBoleto);

        double descuentoTotal = subtotal - total;

        if (total > 1000) {
            System.out.println("Requiere autorización");
        }

        System.out.printf("Subtotal: %.2f\n", subtotal);
        System.out.printf("Descuento total: %.2f\n", descuentoTotal);
        System.out.printf("Total final: %.2f\n", total);

        sc.close();
    }

    // 🔹 Leer horas con validación repetitiva
    public static int leerHoras(String mensaje, Scanner sc) {
        int horas;

        while (true) {
            System.out.println(mensaje);

            if (sc.hasNextInt()) {
                horas = sc.nextInt();

                if (validarHoras(horas)) {
                    return horas;
                }

                System.out.println("Horas inválidas");
            } else {
                System.out.println("Entrada inválida");
                sc.nextLine();
            }
        }
    }

    // 🔹 Leer tarifa con validación repetitiva
    public static double leerTarifa(String mensaje, Scanner sc) {
        double tarifa;

        while (true) {
            System.out.println(mensaje);

            if (sc.hasNextDouble()) {
                tarifa = sc.nextDouble();

                if (validarTarifa(tarifa)) {
                    return tarifa;
                }

                System.out.println("Tarifa inválida");
            } else {
                System.out.println("Entrada inválida");
                sc.nextLine();
            }
        }
    }

    // 🔹 Leer boolean repetitivo
    public static boolean leerBoolean(String mensaje, Scanner sc) {
        boolean value;

        while (true) {
            System.out.println(mensaje);

            if (sc.hasNextBoolean()) {
                value = sc.nextBoolean();
                return value;
            }

            System.out.println("Entrada inválida");
            sc.nextLine();
        }
    }

    // 🔹 Validaciones simples
    public static boolean validarHoras(int horas) {
        return horas >= 0;
    }

    public static boolean validarTarifa(double tarifa) {
        return tarifa > 0;
    }

    // 🔹 Descuento 12%
    public static double aplicarDescuentoHoras(double total, int horas) {
        if (horas > 10) {
            total *= 0.88;
        }
        return total;
    }

    // 🔹 Descuento 5%
    public static double aplicarDescuentoBoleto(double total, boolean tieneBoleto) {
        if (tieneBoleto) {
            total *= 0.95;
        }
        return total;
    }
}
