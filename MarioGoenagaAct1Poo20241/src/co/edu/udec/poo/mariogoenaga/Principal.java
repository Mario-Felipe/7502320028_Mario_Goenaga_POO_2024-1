package co.edu.udec.poo.mariogoenaga;

//import java.util.Date;
import Dominio.Usuario;
import Repositorio.DocumentoRepositorio;
import Repositorio.EmpleadoRepositorio;
import Repositorio.EmpresaRepositorio;
import Repositorio.PromotorRepositorio;
import Repositorio.ProyectoRepositorio;
import Repositorio.TareaRepositorio;
import Repositorio.UsuarioRepositorio;
import Repositorio.VersionRepositorio;
import Vistas.gui.Login;
import javax.swing.JOptionPane;

//import Crud.DocumentoCrud;
//import Crud.EmpleadoCrud;
//import Crud.EmpresaCrud;
//import Crud.PromotorCrud;
//import Crud.ProyectoCrud;
//import Crud.TareaCrud;
//import Crud.VersionCrud;
//import Dominio.Documento;
//import Dominio.Empleado;
//import Dominio.Empresa;
//import Dominio.FuerzaLaboral;
//import Dominio.Promotor;
//import Dominio.Proyecto;
//import Dominio.RutaTrabajo;
//import Dominio.Tarea;
//import Dominio.Version;
public class Principal {

    public static DocumentoRepositorio documentoBd = new DocumentoRepositorio();
    public static EmpleadoRepositorio empleadoBd = new EmpleadoRepositorio();
    public static EmpresaRepositorio empresaBd = new EmpresaRepositorio();
    public static PromotorRepositorio promotorBd = new PromotorRepositorio();
    public static ProyectoRepositorio proyectoBd = new ProyectoRepositorio();
    public static TareaRepositorio tareaBd = new TareaRepositorio();
    public static UsuarioRepositorio usuarioBd = new UsuarioRepositorio();
    public static VersionRepositorio versionBd = new VersionRepositorio();
    
    private static Usuario usuarioSesion = null;

    public static void main(String args[]) {
        Login login = new Login();
        
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
//        ventana.setExtendedState(ventana.MAXIMIZED_BOTH);
        
    }

    public static Usuario getUsuarioSesion() {
        return usuarioSesion;
    }

    public static void setUsuarioSesion(Usuario usuarioSesion) {
        Principal.usuarioSesion = usuarioSesion;
    }
    
    
    
    public static boolean LoginUser(String usuario, String clave) throws Exception {

        try {
            Usuario usuarioLoged = usuarioBd.IniciarSesion(usuario, clave);

            usuarioSesion = usuarioLoged;

            return usuarioLoged != null;
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Success", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }
    
    public static void Loguot() {
        setUsuarioSesion(null);
        
    }
    
         
}
