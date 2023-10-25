package com.example.parcial3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Parcial implements Serializable {

    private static final long serialVersionUID = 1L;
    public List<Persona> listaPersonas = new ArrayList<>();

    public Parcial(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public Parcial() {}

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public void agregarPersona(Persona persona) throws Exception {
        if (listaPersonas.contains(persona)) {
            throw new Exception("El usuario ya existe");
        } else {
            listaPersonas.add(persona);
        }
    }

    public void eliminarPersona(Persona persona) throws Exception {
        if (listaPersonas.contains(persona)) {
            listaPersonas.remove(persona);
        } else {
            throw new Exception("El usuario no existe");
        }
    }

    public Persona buscarPersonaPorId(String id) throws Exception {
        for (Persona persona : listaPersonas) {
            if (persona.getId().equals(id)) {
                return persona;
            }
        }
        throw new Exception("El usuario no existe");
    }

    public void crearPersona(String id, String nombre, String mail, String telefono){

    }

}
