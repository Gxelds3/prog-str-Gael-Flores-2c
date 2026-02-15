import java.util.Scanner;

public class MainAlumnos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[25];
        ValueAlumnos validator = new ValueAlumnos();
        ConsultasAlumnos consultas = new ConsultasAlumnos(alumnos, validator);

        int choice;

        do {
            System.out.println("----- MENU -----");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID (solo activos)");
            System.out.println("3) Actualizar promedio por ID (solo activos)");
            System.out.println("4) Baja logica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");

            choice = validator.getMenuOption(sc);

            switch (choice) {
                case 1:
                    consultas.alta(sc);
                    break;
                case 2:
                    consultas.buscarPorId(sc);
                    break;
                case 3:
                    consultas.actualizarPromedio(sc);
                    break;
                case 4:
                    consultas.bajaLogica(sc);
                    break;
                case 5:
                    consultas.listarActivos();
                    break;
                case 6:
                    consultas.reportes();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (choice != 0);

        sc.close();
    }
}