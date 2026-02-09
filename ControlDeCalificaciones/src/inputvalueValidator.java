import java.util.Scanner;

public class inputvalueValidator {

    public String leerTextoNoVacio(Scanner sc, String msg){
            String valueName;
            while(true){
                System.out.println(msg);
                if(sc.hasNext()){
                    valueName = sc.next();
                    return valueName;
                }else{
                    System.out.println("El valor no es String");
                    sc.nextLine();
                }
            }
        }

    public Double leerDoubleEnRango(Scanner sc, String msg, double min, double max){
        double valueCalificacion;
        while(true){
            System.out.println(msg);
            if(sc.hasNextDouble()){
                valueCalificacion = sc.nextDouble();
                if(valueCalificacion >= 0 && valueCalificacion <= 100){
                    return valueCalificacion;
                }
                System.out.println("El numero no es valido");
            }else{
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }
        }
    }

    public int leerIntEnRango(Scanner sc, String msg, int min, int max){
        int valueCalificacion;
        while(true){
            System.out.println(msg);
            if(sc.hasNextInt()){
                valueCalificacion = sc.nextInt();
                if(valueCalificacion >= 0 && valueCalificacion <= 100){
                    return valueCalificacion;
                }
                System.out.println("El numero no es valido");
            }else{
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }
        }
    }


    public Boolean leerBoolean(Scanner sc, String msg){
        boolean valueProyecto;
        while(true){
            System.out.println(msg);
            if(sc.hasNextBoolean()){
                valueProyecto = sc.nextBoolean();
                return valueProyecto;
            }
            System.out.println("El valor no es booleano (true/false)");
            sc.nextLine();
        }
    }
}