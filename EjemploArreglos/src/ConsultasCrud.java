public class ConsultasCrud {

    private Persona[] personas;
    private ValueCrud validator;

    public ConsultasCrud(Persona[] personas, ValueCrud validator) {
        this.personas = personas;
        this.validator = validator;
    }

    public void alta(java.util.Scanner sc) {
        int id = validator.getValidInt("ID: ", sc);

        if (existeId(id)) {
            System.out.println("Ese ID ya existe");
            return;
        }

        String nombre = validator.getValidString("Nombre: ", sc);

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new Persona(id, nombre);
                System.out.println("Persona registrada");
                return;
            }
        }

        System.out.println("Arreglo lleno");
    }

    public void buscarPorId(java.util.Scanner sc) {
        int id = validator.getValidInt("ID a buscar: ", sc);

        for (Persona p : personas) {
            if (p != null && p.isActiva() && p.getId() == id) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Persona activa no encontrada");
    }

    public void bajaLogica(java.util.Scanner sc) {
        int id = validator.getValidInt("ID a dar de baja: ", sc);

        for (Persona p : personas) {
            if (p != null && p.isActiva() && p.getId() == id) {
                p.setActiva(false);
                System.out.println("Baja logica realizada");
                return;
            }
        }
        System.out.println("Persona activa no encontrada");
    }

    public void listarActivas() {
        boolean hay = false;
        for (Persona p : personas) {
            if (p != null && p.isActiva()) {
                System.out.println(p);
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay personas activas");
        }
    }

    public void actualizarNombre(java.util.Scanner sc) {
        int id = validator.getValidInt("ID a actualizar: ", sc);

        for (Persona p : personas) {
            if (p != null && p.isActiva() && p.getId() == id) {
                String nuevoNombre = validator.getValidString("Nuevo nombre: ", sc);
                p.setNombre(nuevoNombre);
                System.out.println("Nombre actualizado");
                return;
            }
        }
        System.out.println("Persona activa no encontrada");
    }

    private boolean existeId(int id) {
        for (Persona p : personas) {
            if (p != null && p.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
