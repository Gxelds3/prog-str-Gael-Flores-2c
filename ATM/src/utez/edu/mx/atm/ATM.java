package utez.edu.mx.atm;

import java.util.Scanner;

/*
 * Autor: Valeria Jatziry Flores Perez
 * Fecha y elaboración: 28-ene-2026
 * Grado y Grupo: 2°A DSM
 * Descripción: Esta clase esta echa como un cajero automatico que permite al usuario
 * consultar saldo, depositar dinero, retirar dinero y salir del sistema, pero
 * para entrar a las opciones el usuario debe ingresar la contraseña correcta
 */

public class ATM {

    static int PIN = 1007; // Esta variable es estatica

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 1000; // Esta variable almacena el saldo actual
        double deposite; // Esta variable almacena el deposito que ingrese el usuario
        double withdrawal; //Esta variable almacena lo que retirara el usuario
        int opc, pin; // Esta variable sera para guardar la opcion que ingrese el usurio
        int tries = 0;

        System.out.println("Bienvenido al cajero automatico");// Da la bienvenida al usuario

        while (tries < 3) {
            System.out.println("Ingrese su pin: "); // solicita el pin
            pin = sc.nextInt(); // lee el pin

            if (pin != PIN) { // Evalua si el pin es correcto
                System.out.println("Contraseña incorrecta");
                tries = tries + 1;
                if (tries >= 3) {
                    System.out.println("Limite de intentos alcanzados...");
                }
            } else {
                tries = 0;
                System.out.println("--- Menu ------");// Abre el menu
                System.out.println("Eleija una opción:"); //Solicita elejir una opción
                System.out.println("1. Consultar saldo."); // Opción 1
                System.out.println("2. Ingresar dinero."); // Opción 2
                System.out.println("3. Retirar dinero.");// Opción 3
                System.out.println("4. Salir");// Opción 4
                opc = sc.nextInt();


                switch (opc) { // Depende la opcion ejecuta el caso
                    case 1:
                        System.out.println("Su saldo es de: " + balance); // Muestra el saldo
                        break;
                    case 2:
                        System.out.println("Cuanto desea depositar: "); // Solicita el deposito
                        deposite = sc.nextDouble();
                        balance = balance + deposite; // Realiza la operación
                        System.out.println("Deposito exitoso");
                        System.out.println("Su saldo es de: " + balance); // Manda a pantalla el saldo actual
                        break;
                    case 3:
                        System.out.println("Cuanto desea retirar de su cuenta: "); // Solicita el retiro
                        withdrawal = sc.nextDouble();
                        balance = balance - withdrawal; // Realiza la operacion
                        System.out.println("Retiro exitoso.");
                        System.out.println("Su saldo es de: " + balance); // Manda a pantalla el saldo actual
                        break;
                    case 4:
                        System.out.println("Gracias por elejir este banco"); // Manda un mensaje de agradecimiento
                        System.out.println("Saliendo del sistema....."); // sale del sistema
                        return;
                    default:
                        System.out.println("Opción no válida"); // Muestra mensaje de Opción invalida
                        break;

                }


            }
        }
    }
}
