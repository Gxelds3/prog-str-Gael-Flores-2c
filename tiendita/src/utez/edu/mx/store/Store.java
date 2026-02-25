package utez.edu.mx.store;

/*
 * Autor: Valeria Jatziry Flores Perez
 * Fecha de elaboración: 14-feb-2026
 * Descripción: Sistema de gestión de tienda que permite vender productos,
 * reponer stock (validando enteros positivos) y modificar precios (mínimo $1).
 */

import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Matriz de 5x3 (Nombre, Precio, Stock)
        String[][] inventory = {
                {"Doritos ", "20", "10"},
                {"Coca    ", "18", "10"},
                {"Gansito ", "15", "10"},
                {"Agua    ", "12", "10"},
                {"Galletas", "17", "10"}
        };

        int option = 0;

        while (option != 4) {
            System.out.println("\n--- TIENDITA ESCOLAR ---");
            System.out.println("ID  NOMBRE        PRECIO  STOCK");
            System.out.println("-------------------------------");

            for (int i = 0; i < 5; i++) {
                System.out.println((i + 1) + "   " + inventory[i][0] + "    $" + inventory[i][1] + "     " + inventory[i][2]);
            }

            System.out.println("-------------------------------");
            System.out.println("1) Vender Producto");
            System.out.println("2) Reponer Stock");
            System.out.println("3) Cambiar Precio");
            System.out.println("4) Salir");
            System.out.print("Seleccione una opción: ");
            option = sc.nextInt();

            if (option >= 1 && option <= 3) {
                System.out.print("Seleccione el ID del producto (1-5): ");
                int id = sc.nextInt();
                if (id < 1 || id > 5) {
                    System.out.println("ID no válido.");
                    continue;
                }
                int f = id - 1;

                switch (option) {
                    case 1: // Vender
                        double price = Double.parseDouble(inventory[f][1]);
                        int stock = Integer.parseInt(inventory[f][2]);
                        if (stock > 0) {
                            System.out.print("¿Cantidad a vender? ");
                            int quantity = sc.nextInt();
                            if (quantity > 0 && quantity <= stock) {
                                inventory[f][2] = String.valueOf(stock - quantity);
                                System.out.println("TOTAL: $" + (quantity * price));
                            } else {
                                System.out.println("Cantidad no válida o insuficiente.");
                            }
                        } else {
                            System.out.println("PRODUCTO AGOTADO.");
                        }
                        break;

                    case 2: // Reponer Stock
                        System.out.print("Cantidad de stock a agregar: ");
                        if (sc.hasNextInt()) {
                            int addStock = sc.nextInt();
                            if (addStock > 0) {
                                int currentStock = Integer.parseInt(inventory[f][2]);
                                inventory[f][2] = String.valueOf(currentStock + addStock);
                                System.out.println("Stock actualizado.");
                            } else {
                                System.out.println("Error: No se admiten números negativos.");
                            }
                        } else {
                            System.out.println("Error: Debe ser un número entero (sin decimales).");
                            sc.next(); // Limpiar buffer
                        }
                        break;

                    case 3: // Cambiar Precio
                        System.out.print("Nuevo precio (Mínimo $1): ");
                        double newPrice = sc.nextDouble();
                        if (newPrice >= 1) {
                            inventory[f][1] = String.valueOf(newPrice);
                            System.out.println("Precio actualizado.");
                        } else {
                            System.out.println("Error: El precio debe ser mayor o igual a $1.");
                        }
                        break;
                }
            } else if (option == 4) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
}

