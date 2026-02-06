public class ShippingCalculator {
public ShippingCalculator(){

}//Constructor por default
private final double PRECIOPORKG = 12;
private final double IVA = 0.16;
public double subtotal;
public double ivaCalcular;
public double total;

public void process(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota){
    calcularSubtotal(pesoKg, distanciaKm, tipoServicio, zonaRemota);
    calcularIVA(subtotal);
    calcularTotal(subtotal);
}

private void calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {
    this.subtotal = (pesoKg * PRECIOPORKG) + distanciaKm + tipoServicio;

    if (zonaRemota) {
        this.subtotal += this.subtotal*0.10;
    }
}

private void calcularIVA(double subtotal) {
    this.ivaCalcular = subtotal * IVA;
}

private void calcularTotal(double subtotal) {
    this.total = subtotal + this.ivaCalcular;
    }
}