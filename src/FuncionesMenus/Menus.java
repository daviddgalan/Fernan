package FuncionesMenus;

import java.io.Serializable;
import java.util.Scanner;

public class Menus implements Serializable {

    public static int menuPrincipal()  {
        Scanner S = new Scanner(System.in);
        System.out.println("Cómo quieres acceder al sistema?");
        System.out.println("1. Administrador");
        System.out.println("2. Gestor");
        System.out.println("3. Inversor");
        System.out.println("4. Crear nuevo Usuario");
        System.out.println("5. Usuario Invitado");
        int opcion = Integer.parseInt(S.next());
        return opcion;
    }

    public static int menuAdministrador() {
        Scanner S = new Scanner(System.in);
        System.out.println("1: Desbloqueo de usuarios");
        System.out.println("2: Bloquear usario");
        System.out.println("3: Ver proyectos");
        System.out.println("4: Eliminar proyecto");
        System.out.println("5: Cambios de credenciales");
        System.out.println("6: Ordenar todos los proyectos por orden de invercion");
        System.out.println("7: Ordenar todos los proyectos por fecha");
        System.out.println("8: Ordenar Inversionistas por Nombre según el proyecto");
        System.out.println("9: Ordenar Inversionistas por Importe según el proyecto");
        System.out.println("10: Habilitacion de usuario invitado");
        System.out.println("11: Cerrar sesión");
        int opcion = Integer.parseInt(S.next());
        return opcion;
    }

    public static int muenuGestor() {
        Scanner S = new Scanner(System.in);
        System.out.println("1: Ver todos los proyectos creados por el gestor");
        System.out.println("2: Crear proyecto");
        System.out.println("3: Eliminar proyecto");
        System.out.println("4: Gráfico");
        System.out.println("5: Cambio de credenciales");
        System.out.println("6  Buscar un proyecto");
        System.out.println("7 Agregar recompensa a proyecto");
        System.out.println("8: Ver recompensas de proyecto");
        System.out.println("9: Ordenar proyectos por orden de importe financiado");
        System.out.println("10: Ordenar poryectos por orden de fecha ");
        System.out.println("11: Ordenar Inversionistas por Nombre");
        System.out.println("12: Ordenar Inversionistas por Importe");
        System.out.println("13: Modificar Proyecto");
        System.out.println("14: Cerrar sesión");
        int opcion = S.nextInt();
        return opcion;
    }



    public static int muenuInversor() {
        Scanner S = new Scanner(System.in);
        System.out.println("1: Ver todas mis inversiones");
        System.out.println("2: Ver todos los proyectos");
        System.out.println("3: Ver saldo de cartera");
        System.out.println("4: Aumentar saldo");
        System.out.println("5  Disminuir saldo");
        System.out.println("6: Ver amigos");
        System.out.println("7: Añadir amigos");
        System.out.println("8: Cambiar credenciales");
        System.out.println("9: Invertir");
        System.out.println("10: Enviar correo con tus inversiones en excel");
        System.out.println("11: Salir");
        int opcion = S.nextInt();
        return opcion;
    }

    public static int MenuModificarProyecto(){
        Scanner S = new Scanner(System.in);
        System.out.println("1: Cambiar nombre de proyecto");
        System.out.println("2: Cambiar descripcion de proyecto");
        System.out.println("3: Cambiar categoria del proyecto");
        System.out.println("4: Cambiar la cantidad necesaria para financiar el proyecto");
        System.out.println("5: Cambiar fecha fecha de fin");
        int opcion = S.nextInt();
        return opcion;
    }

    public static int muenuCreacionUsuarios() {
        Scanner S = new Scanner(System.in);
        System.out.println("1: Crear un gestor");
        System.out.println("2: Crear Inversor");
        int opcion = S.nextInt();
        return opcion;

    }

    public static int menuInvitado() {
        int opcion=0;
        do {
        Scanner S = new Scanner(System.in);
        System.out.println("1: Ver proyectos");
        System.out.println("2: Salir");
        opcion = S.nextInt();
            return opcion;
        }while (opcion!=2);

    }

    public static int menuAdminOpcionesProperties(){
        int opcion=0;
        Scanner S = new Scanner(System.in);
        System.out.println("1: Habilitacion de usuario invitado");
        System.out.println("2: Mostrar ultimas conexiones de todos los usuarios");
        opcion = S.nextInt();
        return opcion;
    }

    public static String menuAdminHabilitacionInvitado(){
        Scanner S = new Scanner(System.in);
        System.out.println("Habilitación de usuario invitado: (si o no)");
        return S.next();
    }


}

