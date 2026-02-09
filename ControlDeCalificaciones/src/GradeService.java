public class GradeService {

    private final int PARCIALES = 3;
    private double promedio;
    private double promedioFinal;
    private String estado;

    public GradeService(){}

    public void process(String nameAlumno, double parcial1, double parcial2, double parcial3, int asistencia, boolean entregaProyecto){
        calcularPromedio(parcial1, parcial2, parcial3);
        calcularFinal(promedio, asistencia);
        estado = determinarEstado(promedioFinal, asistencia, entregaProyecto);
    }

    private void calcularPromedio(double parcial1, double parcial2, double parcial3){
        this.promedio = (parcial1 + parcial2 + parcial3) / PARCIALES;
    }

    private void calcularFinal(double promedio, int asistencia){
        this.promedioFinal = (promedio * 0.7) + (asistencia * 0.3);
    }

    public String determinarEstado(double finalCal, int asistencia, boolean entregoProyecto){
        if(asistencia < 80){
            return "REPROBADO por asistencia";
        }else if(!entregoProyecto){
            return "REPROBADO por proyecto";
        }else{
            if(finalCal >= 70){
                return "APROBADO";
            }else{
                return "REPROBADO por calificación";
            }
        }
    }

    // GETTERS
    public double getPromedio(){
        return promedio;
    }

    public double getPromedioFinal(){
        return promedioFinal;
    }

    public String getEstado(){
        return estado;
    }
}
