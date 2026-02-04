//Base llama a los demas metodos o clases
//despues sigue inputvalidator que es que valida la
//entrada de variable
//en ticket hace el proceso
//y imprime la s
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();//Declaracion un objeto
        inputValidator inputValidator= new inputValidator();
        Scanner sc = new Scanner(System.in);
//I-P-O
//Input
        int cantidad = inputValidator.getValidInt("Ingresa la cantidad de articulos",sc);
//Process
       ticket.process(cantidad);

//Output
        ticket.imprimirTicket(cantidad);

    }
}