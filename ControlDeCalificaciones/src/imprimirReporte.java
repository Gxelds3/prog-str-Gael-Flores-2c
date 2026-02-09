public class imprimirReporte {
public void imprimir(String nameAlumno, Double parcial1,Double parcial2,Double parcial3,int asistencia,boolean entregaProyecto, GradeService service){
    System.out.println("-------------------Boleta-------------------");
    System.out.println("Nombre: " + nameAlumno);
    System.out.println("Calificacion del 1er parcial: " + parcial1);
    System.out.println("Calificacion del 2do parcial: " + parcial2);
    System.out.println("Calificacion del 3er parcial: " + parcial3);
    System.out.println("Promedio: " + service.getPromedio());
    System.out.println("Asistencia: " + asistencia);
    System.out.println("Entrego Proyecto: " + entregaProyecto);
    System.out.println("Promedio Final: " + service.getPromedioFinal());
    System.out.println("Estado: " + service.getEstado());
    System.out.println("--------------------------------------------");

    }
}
