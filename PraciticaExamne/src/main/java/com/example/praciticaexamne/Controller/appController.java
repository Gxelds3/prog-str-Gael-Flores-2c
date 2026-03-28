package com.example.praciticaexamne.Controller;

import com.example.praciticaexamne.Contacto.contacto;
import com.example.praciticaexamne.validaciones.validaciones;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class appController {

    private validaciones validador = new validaciones();
    private int contadorId = 0;

    @FXML
    private ComboBox<String> parentestos;

    @FXML
    private TextField nombre;

    @FXML
    private TextField telefono;

    @FXML
    private Label Mensaje;

    @FXML
    private TextField buscarCon;

    @FXML
    private ListView<contacto> listaContactos;

    private ObservableList<contacto> listaObservable = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        String[] opcionesParentesco = {
                "Padre", "Madre", "Hermano", "Hermana",
                "Abuelo", "Abuela", "Tío", "Tía"
        };
        parentestos.getItems().addAll(opcionesParentesco);
        listaContactos.setItems(listaObservable);
    }

    public void actualizar() {
        String nombreABuscar = buscarCon.getText();
        String nuevoNombre = nombre.getText();
        String nuevoTelefono = telefono.getText();
        String nuevoParentesco = parentestos.getValue();

        if (validador.Validar(nuevoNombre, nuevoTelefono, nuevoParentesco)) {
            for (int i = 0; i < listaObservable.size(); i++) {
                contacto contactoActual = listaObservable.get(i);

                if (contactoActual.getNombre().equalsIgnoreCase(nombreABuscar)) {
                    int idExistente = contactoActual.getId();
                    contacto contactoActualizado = new contacto(nuevoNombre, nuevoTelefono, nuevoParentesco, idExistente);

                    listaObservable.set(i, contactoActualizado);
                    limpiar();
                    Mensaje.setText("Contacto actualizado correctamente");
                    Mensaje.setStyle("-fx-text-fill: green");
                    return;
                }
            }
            Mensaje.setText("No se encontró el contacto para actualizar");
            Mensaje.setStyle("-fx-text-fill: orange");
        } else {
            Mensaje.setText("Error: Datos inválidos");
            Mensaje.setStyle("-fx-text-fill: red");
        }
    }

    public void agregar() {
        String nombreIngresado = nombre.getText();
        String telefonoIngresado = telefono.getText();
        String parentescoSeleccionado = parentestos.getValue();

        // Validar duplicados
        for (contacto c : listaObservable) {
            if (c.getNombre().equalsIgnoreCase(nombreIngresado)) {
                Mensaje.setText("El nombre ya existe en la lista");
                Mensaje.setStyle("-fx-text-fill: orange");
                return;
            }
        }

        if (validador.Validar(nombreIngresado, telefonoIngresado, parentescoSeleccionado)) {
            contacto nuevoContacto = new contacto(nombreIngresado, telefonoIngresado, parentescoSeleccionado, contadorId++);
            listaObservable.add(nuevoContacto);

            limpiar();
            Mensaje.setText("Contacto guardado con éxito");
            Mensaje.setStyle("-fx-text-fill: green");
        } else {
            Mensaje.setText("Error en los campos de datos");
            Mensaje.setStyle("-fx-text-fill: red");
        }
    }

    public void eliminar() {
        String nombreAEliminar = nombre.getText();
        boolean fueEliminado = listaObservable.removeIf(c -> c.getNombre().equalsIgnoreCase(nombreAEliminar));

        if (fueEliminado) {
            limpiar();
            Mensaje.setText("Contacto eliminado");
            Mensaje.setStyle("-fx-text-fill: blue");
        } else {
            Mensaje.setText("No se pudo eliminar: nombre no encontrado");
        }
    }

    public void buscar() {
        String criterioBusqueda = buscarCon.getText();
        boolean encontrado = false;

        for (contacto c : listaObservable) {
            if (c.getNombre().equalsIgnoreCase(criterioBusqueda)) {
                nombre.setText(c.getNombre());
                telefono.setText(c.getTelefono());
                parentestos.setValue(c.getParentesco());

                Mensaje.setText("Contacto encontrado");
                Mensaje.setStyle("-fx-text-fill: green");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            Mensaje.setText("Contacto no registrado.");
            Mensaje.setStyle("-fx-text-fill: red");
        }
    }

    public void limpiar() {
        buscarCon.clear();
        nombre.clear();
        telefono.clear();
        parentestos.setValue(null);
    }
}