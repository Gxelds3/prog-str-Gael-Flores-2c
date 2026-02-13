import java.util.Scanner;

public class ValueCrud {

    public int getValidInt(String message, Scanner sc) {
        int value;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();
                if (value > 0) {
                    return value;
                }
                System.out.println("El numero debe ser mayor a 0");
            } else {
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }
        }
    }

    public String getValidString(String message, Scanner sc) {
        String value;
        while (true) {
            System.out.print(message);
            value = sc.nextLine();
            if (!value.trim().isEmpty()) {
                return value;
            }
            System.out.println("El texto no puede estar vacio");
        }
    }

    public int getMenuOption(Scanner sc) {
        int option;
        while (true) {
            System.out.print("Opcion: ");
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                sc.nextLine();
                return option;
            } else {
                System.out.println("Opcion invalida");
                sc.nextLine();
            }
        }
    }
}
