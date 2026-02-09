import java.util.Scanner;

public class AppCalificaciones{
    public static void main(String[] args){
        inputvalueValidator inputvalueValidator = new inputvalueValidator();
        GradeService gradeService = new GradeService();
        imprimirReporte imprimirReporte = new imprimirReporte();
        Scanner sc = new Scanner(System.in);

        // INPUT
        String nameAlumno = inputvalueValidator.leerTextoNoVacio(sc, "Ingrese su nombre: ");
        Double parcial1 = inputvalueValidator.leerDoubleEnRango(sc, "Ingrese su calificacion del 1er parcial: ", 0.0, 100.0);
        Double parcial2 = inputvalueValidator.leerDoubleEnRango(sc, "Ingrese su calificacion del 2do parcial: ", 0.0, 100.0);
        Double parcial3 = inputvalueValidator.leerDoubleEnRango(sc, "Ingrese su calificacion del 3er parcial: ", 0.0, 100.0);
        int asistencia = inputvalueValidator.leerIntEnRango(sc, "Ingrese su asistencia: ", 0, 100);
        boolean entregaProyecto = inputvalueValidator.leerBoolean(sc, "Ingrese si entrego proyecto (true/false): ");

        // PROCESS
        gradeService.process(nameAlumno, parcial1, parcial2, parcial3, asistencia, entregaProyecto);

        // OUTPUT
        imprimirReporte.imprimir(nameAlumno, parcial1, parcial2, parcial3, asistencia, entregaProyecto, gradeService);
    }
}
