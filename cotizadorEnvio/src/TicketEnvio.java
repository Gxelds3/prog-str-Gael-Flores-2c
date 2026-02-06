public class TicketEnvio {

    public void imprimirTicket(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota, ShippingCalculator calculator) {
        System.out.println("----- TICKET -----");
        System.out.println("Servicio: $" + tipoServicio);
        System.out.println("Peso: " + pesoKg + " Kg");
        System.out.println("Distancia: $" + distanciaKm);
        System.out.println("Zona remota: " + zonaRemota);
        System.out.println("Subtotal: $" + calculator.subtotal);
        System.out.println("IVA: $" + calculator.ivaCalcular);
        System.out.println("Total: $" + calculator.total);
        System.out.println("------------------");
    }
}

