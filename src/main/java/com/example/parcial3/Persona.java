package com.example.parcial3;

import java.io.Serializable;

public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String telefono;
    private String mail;
    private String id;

    public Persona() {}

    public Persona(String nombre, String telefono, String mail, String id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;

        return id.equals(persona.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
