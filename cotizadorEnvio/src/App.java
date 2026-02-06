//Base llama a los demas metodos o clases
//despues sigue inputvalidator que es que valida la
//entrada de variable
//en ticket hace el proceso
//y imprime la s
    import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TicketEnvio ticket = new TicketEnvio();
        InputValueValidator InputValueValidator= new InputValueValidator();
        ShippingCalculator ShippingCalculator= new ShippingCalculator();
        Scanner sc = new Scanner(System.in);
//I-P-O
//Input
        double pesoKg = InputValueValidator.leerDoubleEnPeso("Ingresa tu peso: ", sc, 0.1, 50.0);
        int distanciaKm = InputValueValidator.leerIntEnDistancia("Ingrese distancia en enteros", sc, 1, 2000);
        int tipoServicio = InputValueValidator.leerIntEnServicio("Ingresa tu tipo de servicio 1) Estandar -> $50, 2) Express -> $90: ", sc, 1, 2);
        boolean zonaRemota = InputValueValidator.leerBooleanZona("Zona Remota (true/false)", sc);



//Process
        ShippingCalculator.process(pesoKg, distanciaKm, tipoServicio, zonaRemota);

//Output
        ticket.imprimirTicket(pesoKg, distanciaKm, tipoServicio, zonaRemota, ShippingCalculator);
    }
}