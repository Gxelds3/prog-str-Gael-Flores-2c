import java.util.Scanner;

public class CrudSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[20];
        int choice;
        do {
            System.out.println("<<<<<Menu>>>>>");
            System.out.println(" 1) Alta");
            System.out.println(" 2) Buscar por ID (solo activas)");
            System.out.println(" 3) Baja lógica por ID");
            System.out.println(" 4) Listar activas");
            System.out.println(" 5) Actualizar nombre por ID (solo activas)");
            System.out.println(" 0) Salir");
            System.out.println("--------------");
            choice = sc.nextInt();

            switch (choice) {
                case 1:






                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Error opcion no valida");
            }

        }while(choice!=0);
    }
}
