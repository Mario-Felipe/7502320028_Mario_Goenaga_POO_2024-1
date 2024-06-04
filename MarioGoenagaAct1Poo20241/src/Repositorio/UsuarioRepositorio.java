package Repositorio;

import Dominio.Usuario;
import Persistencia.UsuarioJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class UsuarioRepositorio {
    
    public static UsuarioJpaController repositorio = new UsuarioJpaController();
    
    public void crear(Usuario usuario){
        
        try {
            if(encontrarUsuario(usuario.getUsuario())!= null){
                throw new Exception("El usuario ya ase encuentra en la BD");
            }
            repositorio.create(usuario);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editar(Usuario usuario){
        try {
            repositorio.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void destroy(int id){
        try {
            repositorio.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(UsuarioRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Usuario buscar(int id){
        return repositorio.findUsuario(id);
    }
    
    public List<Usuario> buscarTodo(){
        return repositorio.findUsuarioEntities();
    }
 
public Usuario encontrarUsuario(String codigo){
        Usuario encontrado = null;


            List<Usuario> lista = buscarTodo();

            Map<String, Usuario> listaUsuarios = new HashMap<>();

            for (Usuario entry : lista) {
                listaUsuarios.put(entry.getUsuario(), entry);
            }

            encontrado = listaUsuarios.get(codigo);

            if (!(encontrado == null)) {
                return encontrado;
            }else{
                return null;
            }
    }

public Usuario IniciarSesion(String usuario, String passwd) throws Exception {

        try {
            Usuario usr = encontrarUsuario(usuario);



            if (usr == null) {
                throw new Exception("No se encontro el Usuario");
            }

            System.out.println(usr.toString());

            if (!(passwd.equals(usr.getContrasena()))) {
                throw new Exception("La clave es incorrecta");
            }

            return usr;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
}
