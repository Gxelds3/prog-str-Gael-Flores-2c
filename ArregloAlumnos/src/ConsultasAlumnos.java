import java.util.Scanner;

public class ConsultasAlumnos {

    private Alumno[] alumnos;
    private ValueAlumnos validator;

    public ConsultasAlumnos(Alumno[] alumnos, ValueAlumnos validator) {
        this.alumnos = alumnos;
        this.validator = validator;
    }

    public void alta(Scanner sc) {

        int id = validator.getValidInt("ID: ", sc);

        if (existeId(id)) {
            System.out.println("Ese ID ya existe");
            return;
        }

        String nombre = validator.getValidString("Nombre: ", sc);
        double promedio = validator.getValidPromedio("Promedio (0-10): ", sc);

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio);
                System.out.println("Alumno registrado correctamente");
                return;
            }
        }

        System.out.println("Arreglo lleno");
    }

    public void buscarPorId(Scanner sc) {

        int id = validator.getValidInt("ID a buscar: ", sc);

        for (Alumno a : alumnos) {
            if (a != null && a.isActivo() && a.getId() == id) {
                System.out.println(a);
                return;
            }
        }

        System.out.println("Alumno activo no encontrado");
    }

    public void actualizarPromedio(Scanner sc) {

        int id = validator.getValidInt("ID a actualizar: ", sc);

        for (Alumno a : alumnos) {
            if (a != null && a.isActivo() && a.getId() == id) {
                double nuevoProm = validator.getValidPromedio("Nuevo promedio (0-10): ", sc);
                a.setPromedio(nuevoProm);
                System.out.println("Promedio actualizado");
                return;
            }
        }

        System.out.println("Alumno activo no encontrado");
    }

    public void bajaLogica(Scanner sc) {

        int id = validator.getValidInt("ID a dar de baja: ", sc);

        for (Alumno a : alumnos) {
            if (a != null && a.isActivo() && a.getId() == id) {
                a.setActivo(false);
                System.out.println("Baja logica realizada");
                return;
            }
        }

        System.out.println("Alumno activo no encontrado");
    }

    public void listarActivos() {

        boolean hay = false;

        for (Alumno a : alumnos) {
            if (a != null && a.isActivo()) {
                System.out.println(a);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay alumnos activos");
        }
    }

    public void reportes() {

        double suma = 0;
        int contador = 0;
        int mayores8 = 0;

        Alumno mayor = null;
        Alumno menor = null;

        for (Alumno a : alumnos) {

            if (a != null && a.isActivo()) {

                suma += a.getPromedio();
                contador++;

                if (a.getPromedio() >= 8.0) {
                    mayores8++;
                }

                if (mayor == null || a.getPromedio() > mayor.getPromedio()) {
                    mayor = a;
                }

                if (menor == null || a.getPromedio() < menor.getPromedio()) {
                    menor = a;
                }
            }
        }

        if (contador == 0) {
            System.out.println("No hay alumnos activos para generar reportes");
            return;
        }

        System.out.println("----- REPORTES -----");
        System.out.println("Promedio general: " + (suma / contador));
        System.out.println("Alumno con mayor promedio: " + mayor);
        System.out.println("Alumno con menor promedio: " + menor);
        System.out.println("Cantidad con promedio >= 8.0: " + mayores8);
    }

    private boolean existeId(int id) {
        for (Alumno a : alumnos) {
            if (a != null && a.getId() == id) {
                return true;
            }
        }
        return false;
    }
}