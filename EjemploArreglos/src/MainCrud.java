import java.util.Scanner;

public class MainCrud {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[20];
        ValueCrud validator = new ValueCrud();
        ConsultasCrud consultas = new ConsultasCrud(personas, validator);

        int choice;

        do {
            System.out.println("----- MENU -----");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Baja logica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID");
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
                    consultas.bajaLogica(sc);
                    break;
                case 4:
                    consultas.listarActivas();
                    break;
                case 5:
                    consultas.actualizarNombre(sc);
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opcion invalida, intenta de nuevo");
            }

        } while (choice != 0);
    }
}
