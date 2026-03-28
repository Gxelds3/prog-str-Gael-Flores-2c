package com.example.praciticaexamne.Contacto;

public class contacto {
    private int id;
    private String nombre;
    private String telefono;
    private String parentesco;

    public contacto(String nombre, String telefono, String parentesco, int id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.parentesco = parentesco;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getParentesco() {
        return parentesco;
    }

    @Override
    public String toString() {
        return nombre+"-"+telefono+"-"+parentesco;
    }
    }