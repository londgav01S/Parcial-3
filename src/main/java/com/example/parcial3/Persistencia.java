package com.example.parcial3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {

    public static final String RUTA_ARCHIVO_USUARIOS = "src/main/resources/persistencia/archivoUsuarios.txt";

    public static final String RUTA_ARCHIVO_PERSONAS = "src/main/resources/persistencia/archivoPersonas.txt";
    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/persistencia/log/ParcialLog.txt";
    public static final String RUTA_ARCHIVO_OBJETOS = "Subasta/src/main/resources/persistencia/archivoObjetos.txt";
    public static final String RUTA_ARCHIVO_MODELO_PARCIAL_BINARIO = "src/main/resources/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_PARCIAL_XML = "src/main/resources/persistencia/model.xml";




    //---------------------------------------Cargar Datos----------------------------------------------------------

    public static void cargarDatosArchivos(Parcial parcial) throws FileNotFoundException, IOException {
        //cargar archivo de usuarios

        //cargar archivos Usuarios
        ArrayList<Persona> personasCargados = cargarUsuarios();
        if (!personasCargados.isEmpty())
            parcial.getListaPersonas().addAll(personasCargados);

        //cargar archivo transcciones

        //cargar archivo empleados

        //cargar archivo prestamo

    }

    private static ArrayList<Persona> cargarUsuarios() throws IOException {

        ArrayList<Persona> personas = new ArrayList<>();
        ArrayList<String> contenidos = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PERSONAS);
        String line= "";

        for(int i=0; i<contenidos.size(); i++){
            line= contenidos.get(i);
            Persona persona = new Persona();
            persona.setNombre(line.split(",")[0]);
            persona.setId(line.split(",")[1]);
            persona.setTelefono(line.split(",")[2]);
            persona.setMail(line.split(",")[3]);

            personas.add(persona);
        }
        return personas;
    }


    //---------------------------------------Guardar Datos----------------------------------------------------------

    /*
    public static void guardarUsuarios(ArrayList<Usuario> listaUsuarios) throws IOException {
        String contenido = "";

        for (Usuario usuarioAux : listaUsuarios) {
            contenido += usuarioAux.getNombreUsuario() + "@@" + usuarioAux.getContrasenia() + "@@" + usuarioAux.getNombre()
                    + "@@" + usuarioAux.getTelefono() + "@@" + usuarioAux.getIdentificacion()
                    + "@@" + usuarioAux.getCorreoElectronico() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, true);
    }*/


    public static void guardarPersonas(ArrayList<Persona> listaPersonas) throws IOException {
        String contenido = "";
        for (Persona personaAux : listaPersonas) {
            contenido += personaAux.getNombre() + "," + personaAux.getId() + "," + personaAux.getTelefono()
                    + "," + personaAux.getMail() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PERSONAS, contenido, true);
    }

    //----------------------------------------------LOG-------------------------------------------------------------

    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion) {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }


    //-------------------------------------Procesos Login---------------------------------------------------------
    public static boolean iniciarSesion(String usuario, String contrasenia) throws FileNotFoundException, IOException, UsuarioException {

        if (validarUsuario(usuario, contrasenia)) {
            return true;
        } else {
            throw new UsuarioException("Usuario no existe");
        }

    }

    private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException {
        ArrayList<Persona> usuarios = Persistencia.cargarUsuarios();

        for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++) {
            Persona usuarioAux = usuarios.get(indiceUsuario);
            if (usuarioAux.getNombre().equalsIgnoreCase(usuario) && usuarioAux.getId().equalsIgnoreCase(contrasenia)) {
                return true;
            }
        }
        return false;
    }

    //-----------------------------------------------------------------------------------------------------------



    //------------------------------------SERIALIZACIÓN  y XML ---------------------------------------------------


    public static Parcial cargarRecursoParcialBinario() {
        Parcial Parcial = null;
        try {
            Parcial = (Parcial) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_PARCIAL_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Parcial;
    }

    public static void guardarRecursoParcialBinario(Parcial Parcial) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_PARCIAL_BINARIO, Parcial);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Parcial cargarRecursoParcialXML() {

        Parcial Parcial = null;

        try {
            Parcial = (Parcial) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PARCIAL_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Parcial;

    }

    public static void guardarRecursoParcialXML(Parcial Parcial) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PARCIAL_XML, Parcial);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
