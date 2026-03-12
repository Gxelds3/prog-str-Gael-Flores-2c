import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalValidos = 0;
        int totalPermitidos = 0;
        int totalDenegados = 0;

        while (true) {

            // 1) Código
            String codigo = esCodigoValido(sc, "Ingrese su codigo (o SALIR): ");

            if (codigo.equals("SALIR")) {
                break;
            }

            totalValidos++;

            // 2) Tipo usuario
            System.out.print("Es alumno (true/false)? ");
            if (!sc.hasNextBoolean()) {
                System.out.println("Tipo inválido");
                return; // termina programa
            }

            boolean esAlumno = sc.nextBoolean();

            // 3) Hora
            System.out.print("Ingrese hora de entrada (0..23): ");
            if (!sc.hasNextInt()) {
                System.out.println("Hora inválida");
                return; // termina programa
            }

            int hora = sc.nextInt();

            if (hora < 0 || hora > 23) {
                System.out.println("Hora inválida");
                return; // termina programa
            }

            sc.nextLine(); // limpiar buffer

            // Regla: biblioteca cerrada
            if (hora >= 21) {
                System.out.println("Biblioteca cerrada");
                break;
            }

            // Regla horario permitido
            if (esHorarioPermitido(hora, esAlumno)) {
                System.out.println("Acceso permitido");
                totalPermitidos++;
            } else {
                System.out.println("Acceso denegado");
                totalDenegados++;
            }
        }

        // Resumen final
        System.out.println("\n--- RESUMEN ---");
        System.out.println("Total registros válidos: " + totalValidos);
        System.out.println("Total permitidos: " + totalPermitidos);
        System.out.println("Total denegados: " + totalDenegados);

        double porcentaje = 0;
        if (totalValidos > 0) {
            porcentaje = (totalPermitidos * 100.0) / totalValidos;
        }

        System.out.printf("Porcentaje de permitidos: %.2f%%\n", porcentaje);

        sc.close();
    }

    // Validación de código
    public static String esCodigoValido(Scanner sc, String mensaje) {

        while (true) {

            System.out.print(mensaje);
            String value = sc.nextLine();

            if (value.equals("SALIR")) {
                return "SALIR";
            }

            if (value == null) {
                System.out.println("Código inválido");
                continue;
            }

            value = value.trim();

            if (value.length() != 6) {
                System.out.println("Código inválido");
                continue;
            }

            if (!value.chars().allMatch(Character::isLetterOrDigit)) {
                System.out.println("Código inválido");
                continue;
            }

            return value;
        }
    }

    // Regla horario permitido
    public static boolean esHorarioPermitido(int hora, boolean esAlumno) {

        if (esAlumno) {
            return hora >= 8 && hora <= 20;
        } else {
            return hora >= 10 && hora <= 18;
        }
    }
}
