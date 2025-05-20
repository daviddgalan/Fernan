package Controladores;

import FuncionesDeCorreo.FuncionesDeCorreo;
import Modelos.Categoria;
import Modelos.RecompensasDeProyecto;
import MoldelosGestores.GestorDeProyecto;
import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaAdministrador;

import java.io.Serializable;
import java.time.LocalDate;

public class ControladorAdministrador implements Serializable {
    private GestorDeUsuarios gestorDeUsuarios;
    private VistaAdministrador vistaAdministrador;
    private GestorDeProyecto gestorDeProyecto;
    public ControladorAdministrador(GestorDeUsuarios gestorDeUsuarios, VistaAdministrador vistaAdministrador, GestorDeProyecto gestorDeProyecto) {
        this.gestorDeUsuarios = gestorDeUsuarios;
        this.vistaAdministrador = vistaAdministrador;
        this.gestorDeProyecto =gestorDeProyecto;
    }

    public void cambiarContraseñaAdministrdor(String contraseña, String  nombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario(nombreDeUsuario).setContraseña(contraseña);
        vistaAdministrador.cambioDeContraseña();
    }


    public void cambiarUsuarioDeAdministrador(String nombreDeUsuario, String  NuevonombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario(nombreDeUsuario).cambioDeNombreDeUsusario(NuevonombreDeUsuario);
        vistaAdministrador.cambioDeUsuario();
    }


    public void desbloquearUsuario(String  nombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario( nombreDeUsuario).setBloqueado(false);
        vistaAdministrador.usuarioDesbloqueado();
    }


    public void bloquearUsuario(String  nombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario( nombreDeUsuario).setBloqueado(true);
        vistaAdministrador.usuarioBloqueado();
    }


    public void eliminarProyecto(String id){
        gestorDeProyecto.eliminarProyecto(id);
    }

    public void ordenarPorFecha(){
        gestorDeProyecto.ordenarArrayPorFecha(gestorDeProyecto.verArrayDeProyectos());
        vistaAdministrador.mensajeProyectosOrdenadosPorFecha();
    }

    public void ordenarTodosLosProyectosPorOrdenDeCantidadFinanciada(){
        gestorDeProyecto.ordenarPorImporteFinanciado(gestorDeProyecto.verArrayDeProyectos());
        vistaAdministrador.mensajeCantidadFinanciada();
    }

    public void mostrarInversionistasOrdenadoPorNombre(String idProyecto){

        vistaAdministrador.mostrarInversiones(gestorDeProyecto.ordenarInversionesPorNombre(gestorDeProyecto.buscarProyecto(idProyecto).getInvercionesRealizadas()));
    }

    public void mostrarInversionistasOrdenadoPorImporte(String idProyecto){

        vistaAdministrador.mostrarInversiones(gestorDeProyecto.ordenarInversionesPorImporte(gestorDeProyecto.buscarProyecto(idProyecto).getInvercionesRealizadas()));
    }

    public boolean inicioDeSecionAdmin(String nombreDeUsuario, String contraseña) {
        if (gestorDeUsuarios.buscarUsuario( nombreDeUsuario) == null) {
            vistaAdministrador.credencialesNoValidos();
            return false;
        } else if (gestorDeUsuarios.buscarUsuario( nombreDeUsuario).getContraseña().equals(contraseña) && gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getClass().getSimpleName().equals("Administrador")) {
            FuncionesDeCorreo codigo = new FuncionesDeCorreo(gestorDeUsuarios.buscarUsuario( nombreDeUsuario).getCorreo());
            if(codigo.getCodigoDeCorreo().equals(vistaAdministrador.inicioDeSecionCodigo())){
                vistaAdministrador.saludarUsuario();
                return true;
            }
        }
        return false;
    }
}


