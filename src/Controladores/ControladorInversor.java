package Controladores;
import FuncionesDeCorreo.FuncionesDeCorreo;
import Inversión.Inversion;
import Modelos.Amigo;
import Modelos.Inversor;
import Modelos.Proyecto;
import Modelos.Usuario;
import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaInversor;

import java.io.Serializable;
import java.time.LocalDate;

public class ControladorInversor implements Serializable {
    private GestorDeUsuarios gestorDeUsuarios;
    private VistaInversor vistaInversor;

    public ControladorInversor(GestorDeUsuarios gestoDeUsuarios, VistaInversor vistaInversor) {
        this.gestorDeUsuarios = gestoDeUsuarios;
        this.vistaInversor = vistaInversor;
    }

    public void misInversiones(String nombreDeUsuario) {
        if(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)==null){
            vistaInversor.mensajeUsuarioNoEncontrado();
        }
        vistaInversor.textoParaMostrarInversiones(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getNombre());
        vistaInversor.mostrarInverciones(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).mostrarListaDeInversiones());
    }


    public void verCartera(String nombreDeUsuario) {
        vistaInversor.textoParaCartera(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getNombre());
        vistaInversor.verCarteraDeInversor(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).verCatera());
    }

    public void añadirCreditoAcartera(int creditoAñadido, String nombreDeUsuario) {
       if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
           vistaInversor.mensajeUsuarioNoEncontrado();
       }
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).añadirSaldoACartera(creditoAñadido);
        vistaInversor.mensajeCreditoAñadido(creditoAñadido);
    }


    public void restarCreditoAcartera(int creditorestado, String nombreDeUsuario) {
        if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
            vistaInversor.mensajeUsuarioNoEncontrado();
        }
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).restarSaldoACartera(creditorestado);
        vistaInversor.mensajeCreditoRestado(creditorestado);
    }


    public void mostrarAmigosDelIversor(String nombreDeUsuairo) {
        vistaInversor.mensajeAmigos(gestorDeUsuarios.buscarUsuario(nombreDeUsuairo).getNombre());
        vistaInversor.verAmigosDeGestor(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuairo)).verListaDeAmigos());
    }

    public void añadirAmigoDeInversor(Amigo amigo, String nombreDeUsuario) {
        if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
            vistaInversor.mensajeUsuarioNoEncontrado();
        }
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).añadirAmigo(amigo);
        vistaInversor.mensajeAmigoAñadido();
    }

    public void cambiarNombreDeInversor(String nombre, String nombreDeUsuario) {
        if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
            vistaInversor.mensajeUsuarioNoEncontrado();
        }
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).cambioDeUsusario(nombre);
        vistaInversor.mensajeCambioDeUsusaio();
    }


    public void cambioDeContraseñaDeInversor(String contraseña, String nombreDeUsuario) {
        if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
            vistaInversor.mensajeUsuarioNoEncontrado();
        }
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).cambioDeContraseña(contraseña);
        vistaInversor.mensajeDeCabioDeContraseña();
    }

    public boolean inicioDeSecionInversor
            (String nombreDeUsuario, String contraseña) {
        if (gestorDeUsuarios.buscarUsuario(nombreDeUsuario) == null) {
            vistaInversor.idNoValido();
            return false;
        } else if (gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getContraseña().equals(contraseña) && gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getClass().getSimpleName().equals("Inversor")) {
            FuncionesDeCorreo codigo = new FuncionesDeCorreo(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getCorreo());
            if (codigo.getCodigoDeCorreo().equals(vistaInversor.inicioDeSesionCodigo())) {
                vistaInversor.saludarUsuario();
                return true;
            }
        }
        return false;
    }
    public void invertir(String nombreDeUsuario, Proyecto proyecto, float cantidad, LocalDate fechaDeInversion){
        if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
            vistaInversor.mensajeUsuarioNoEncontrado();
        }else{
            Inversion nuevaInversion = new Inversion(proyecto,cantidad,fechaDeInversion, (Inversor) gestorDeUsuarios.buscarUsuario(nombreDeUsuario));
            gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).invertir(nuevaInversion);
        }
    }

    public void bloquearInversor(String nombreDeGestor) {
        gestorDeUsuarios.buscarUsuario(nombreDeGestor).setBloqueado(true);
    }

    public Inversion verInvercionesRealizadas(String nombreDeUsuario){
        return gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).verUltimaInversion();
    }

    public void añadirInversorAGestorDeUsuarios(Usuario Gestor){
        gestorDeUsuarios.agregarUsuarios(Gestor);
    }
}
