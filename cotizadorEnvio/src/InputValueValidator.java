import java.util.Scanner;

public class InputValueValidator {

    public double leerDoubleEnPeso(String message, Scanner sc, double min, double max){
        double valuePeso;
        while(true){
            System.out.println(message);
            if(sc.hasNextDouble()){
                valuePeso = sc.nextDouble();
                if(valuePeso >= min && valuePeso <= max){
                    return valuePeso;
                }
                System.out.println("El numero no es valido");
            }else{
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }
        }
    }

    public int leerIntEnDistancia(String message, Scanner sc, int min, int max) {
        int valueDistancia;

        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                valueDistancia = sc.nextInt();
                if (valueDistancia >= min && valueDistancia <= max) {
                    if (valueDistancia <= 50) {
                        valueDistancia = 20;
                        return valueDistancia;
                    }
                    if (valueDistancia <= 200) {
                        valueDistancia = 60;
                        return valueDistancia;
                    }
                    valueDistancia = 120;
                    return valueDistancia;
                }
                System.out.println("El numero no es valido");
            } else {
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }
        }
    }

    public int leerIntEnServicio(String message, Scanner sc, int min, int max) {
        int valueServicio;

        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                valueServicio = sc.nextInt();
                if (valueServicio >= min && valueServicio <= max) {
                    if (valueServicio == 1) {
                        valueServicio = 50;
                        return valueServicio;
                    }
                    if (valueServicio == 2) {
                        valueServicio = 90;
                        return valueServicio;
                    }
                }
                System.out.println("Opcion invalida");
            } else {
                System.out.println("El valor no es numérico");
                sc.nextLine();
            }
        }
    }

    public boolean leerBooleanZona(String message, Scanner sc) {
        boolean valueZona;
        while (true) {
            System.out.println(message);
            if (sc.hasNextBoolean()) {
                valueZona = sc.nextBoolean();
                return valueZona;
            }
            System.out.println("El valor no es booleano (true/false)");
            sc.nextLine();
        }
    }
}