package Controladores;

import FuncionesDeCorreo.FuncionesDeCorreo;
import Modelos.*;
import MoldelosGestores.GestorDeProyecto;
import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaGestor;


import java.io.Serializable;
import java.time.LocalDate;

public class ControladorGestor  implements Serializable {
    private GestorDeUsuarios gestorDeUsuarios;
    private VistaGestor vistaGestor;
    private GestorDeProyecto gestorDeProyecto;

    public ControladorGestor(GestorDeUsuarios gestorDeUsuarios, VistaGestor vistaGestor,GestorDeProyecto gestorDeProyecto) {
        this.gestorDeUsuarios = gestorDeUsuarios;
        this.vistaGestor = vistaGestor;
        this.gestorDeProyecto = gestorDeProyecto;
    }

    public void crearProyecto(String nombre, String descripcion, Categoria categoria, int cantidadNecesaria, int cantidadFinanciada, LocalDate fechaDeApertura, LocalDate fechaDeFin, String id,String nombreDeUsuario){
        Proyecto nuevoProyecto=new Proyecto(nombre,descripcion,categoria,cantidadNecesaria,cantidadFinanciada,fechaDeApertura,fechaDeFin,id);
        gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).crearProyecto(nuevoProyecto);
        vistaGestor.mensajeProyectoCreado();
        gestorDeProyecto.añadirProyecto(nuevoProyecto);
    }

    public void eliminarProyecto(String id,String nombreDeUsuario){
        gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).eliminarProyecto(id);
        gestorDeProyecto.eliminarProyecto(id);
        vistaGestor.mensajeProyectoEliminado();
    }

    public void ordenarPorFecha(String nombreDeUsuario){
     gestorDeProyecto.ordenarArrayPorFecha( gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).verArrayDeProyectos());
     vistaGestor.mensajeProyectosOrdenadosPorFecha();
    }

    public void verProyectos(String nombreDeUsuario){
        vistaGestor.mensajeMostrarProyectos(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getNombre());
        vistaGestor.mostrarProyectoDeGestor(gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).verArrayDeProyectos());
    }
    public void enviarCorreoConExcel(String idProyecto, String nombreInversor){
        FuncionesDeCorreo correo = new FuncionesDeCorreo();
        correo.exportarInversionesExcel(gestorDeProyecto.buscarProyecto(idProyecto).getInvercionesRealizadas(), nombreInversor);
    }
    public void ordenarProyectoPorImporteRealizado(String nombreDeUsuario){
       gestorDeProyecto.ordenarPorImporteFinanciado(gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).verArrayDeProyectosDeGestor());
        vistaGestor.mensajeDeOrdenacionPorFinanciacion();
    }
    public void mostrarInversionistasOrdenadoPorNombre(String idProyecto){
        vistaGestor.mostrarInversiones(gestorDeProyecto.ordenarInversionesPorNombre(gestorDeProyecto.buscarProyecto(idProyecto).getInvercionesRealizadas()));
    }

    public void mostrarInversionistasOrdenadoPorImporte(String idProyecto){
        vistaGestor.mostrarInversiones(gestorDeProyecto.ordenarInversionesPorImporte(gestorDeProyecto.buscarProyecto(idProyecto).getInvercionesRealizadas()));
    }

    public void mostrarGraficoBarras(String idProyecto){
        vistaGestor.mostrarGraficoBarras(gestorDeProyecto.contarGraficoBarras(gestorDeProyecto.buscarProyecto(idProyecto)));
    }

    public void modificarnNombreDeProyecto(String idProyecto,String nuevoNobreDeProyecto){
        gestorDeProyecto.buscarProyecto(idProyecto).setNombre(nuevoNobreDeProyecto);
        vistaGestor.mensajeDeCambioDeNombre();
    }

    public void modificarCantidadFinanciada(int cantidadFinanciada, String nombreDeUsuario) {
        gestorDeProyecto.buscarProyecto(nombreDeUsuario).setCantidadFinanciada(cantidadFinanciada);
        vistaGestor.mensajeCantidadFinanciada();
    }

    public void modificarFechaDeApertura(LocalDate fechaDeApertura, String idProyecto) {
        gestorDeProyecto.buscarProyecto(idProyecto).setFechaDeApertura(fechaDeApertura);
        vistaGestor.mensajeFechaDeApertura();
    }

    public void modificarCategoria(Categoria nuevaCategoria,String idDeProyecto){
        gestorDeProyecto.buscarProyecto(idDeProyecto).setCategoria(nuevaCategoria);
        vistaGestor.mensajeCambioDeCambioDeCategoria();
    }


    public void modificarDescripcionDeProyecto(String descripcion, String idProyecto) {
        gestorDeProyecto.buscarProyecto(idProyecto).setDescripcion(descripcion);
        vistaGestor.mensajeDeCambioDeDescripcion();
    }



    public boolean inicioDeSecionGestor(String nombreUsuario, String contraseña) {
        if (gestorDeUsuarios.buscarUsuario(nombreUsuario) == null) {
            vistaGestor.idNoValido();
            return false;
        } else if (gestorDeUsuarios.buscarUsuario(nombreUsuario).getContraseña().equals(contraseña) && gestorDeUsuarios.buscarUsuario(nombreUsuario).getClass().getSimpleName().equals("Gestor")) {
            FuncionesDeCorreo codigo = new FuncionesDeCorreo(gestorDeUsuarios.buscarUsuario(nombreUsuario).getCorreo());
            if(codigo.getCodigoDeCorreo().equals(vistaGestor.inicioDeSecionCodigo())){
                vistaGestor.saludarUsuario();
                return true;

            }
        }
        return false;
    }
    public void usuarioBloqueado(String nombreDeUsuario){
        if(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).isBloqueado()){
            vistaGestor.usuarioBloqueado();
        }
    }
    public void bloquearGestor(String nombreDeGestor){
        gestorDeUsuarios.buscarUsuario(nombreDeGestor).setBloqueado(true);
    }

    public void cambiarUsuarioGestor(String nombreDeUsuario,String nuevoUsuario){
        gestorDeUsuarios.buscarUsuario(nombreDeUsuario).cambioDeNombreDeUsusario(nuevoUsuario);

    }

    public void cambiarContraseñaDeUsuario(String nombreDeUsuario,String nuevaContraseña){
        gestorDeUsuarios.buscarUsuario(nombreDeUsuario).cambioDeContraseña(nuevaContraseña);
    }
    public void añadirGestorAGestorDeUsuarios(Usuario Gestor){
        gestorDeUsuarios.agregarUsuarios(Gestor);
    }

}

