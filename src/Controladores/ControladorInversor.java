package Controladores;
import DAO.DAOInversion;
import DAO.DAOInversorSQL;
import DAO.DAOManager;
import FuncionesDeCorreo.FuncionesDeCorreo;
import Inversión.Inversion;
import Modelos.Amigo;
import Modelos.Inversor;
import Modelos.Proyecto;
import Modelos.Usuario;
import MoldelosGestores.GestorDeProyecto;
import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaInversor;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorInversor implements Serializable {
    private GestorDeProyecto gestorDeProyecto;
    private GestorDeUsuarios gestorDeUsuarios;
    private VistaInversor vistaInversor;

    public ControladorInversor(GestorDeUsuarios gestoDeUsuarios, VistaInversor vistaInversor,GestorDeProyecto gestorDeProyecto) {
        this.gestorDeUsuarios = gestoDeUsuarios;
        this.vistaInversor = vistaInversor;
        this.gestorDeProyecto = gestorDeProyecto;
    }

    public void misInversiones(String nombreDeUsuario,DAOManager daoManager) {
        DAOInversion daoInversion = new DAOInversion();
        if(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)==null){
            vistaInversor.mensajeUsuarioNoEncontrado();
        }
        vistaInversor.textoParaMostrarInversiones(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getNombre());
        vistaInversor.mostrarInverciones(daoInversion.optenerInversion(daoManager,gestorDeProyecto,gestorDeUsuarios),nombreDeUsuario);
    }

    public void verCartera(String nombreDeUsuario) {
        vistaInversor.textoParaCartera(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getNombre());
        vistaInversor.verCarteraDeInversor(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).verCatera());
    }

    public void añadirCreditoAcartera(int creditoAñadido, String nombreDeUsuario ,DAOManager daoManager) {
        DAOInversorSQL daoInversorSQL = new DAOInversorSQL();
       if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
           vistaInversor.mensajeUsuarioNoEncontrado();
       }
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).añadirSaldoACartera(creditoAñadido);
        vistaInversor.mensajeCreditoAñadido(creditoAñadido);
        daoInversorSQL.insertarInversor(nombreDeUsuario,creditoAñadido,daoManager);
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
    public void invertir(String nombreDeUsuario, Proyecto proyecto, int cantidad, LocalDate fechaDeInversion, DAOManager daoManager){
        DAOInversion daoInversion = new DAOInversion();
        if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
            vistaInversor.mensajeUsuarioNoEncontrado();
            return;
        }

        if(cantidad>gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).verCatera())
             {vistaInversor.mensajeCantidadInsuficiente();return;}

            Inversion nuevaInversion = new Inversion(proyecto,cantidad,fechaDeInversion, (Inversor) gestorDeUsuarios.buscarUsuario(nombreDeUsuario));
            daoInversion.insertarInversion(nuevaInversion,daoManager);
            gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).invertir(nuevaInversion);
            gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).restarSaldoACartera(cantidad);


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
    public void cambiarCartera(int cartera,String nombreDeUsuario){
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).setCartera(cartera);
    }

}
