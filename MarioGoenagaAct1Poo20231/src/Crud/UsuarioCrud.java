package Crud;

import Dominio.Usuario;

import Model.ModeloCrud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioCrud implements ModeloCrud<Usuario>{

    private HashMap<String, Usuario> listUsuario;
    @Override
    public void agregar(Usuario objeto) throws Exception {
        try {
            if (listUsuario.containsKey(objeto.getUsuario())) {
                throw new Exception("El usuario ya se encuentra registrado");
            }
            listUsuario.put(objeto.getUsuario(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Usuario buscar(String codigo) throws Exception {
        try {
            if (!listUsuario.containsKey(codigo)) {
                throw new Exception("El documento no se encuentra registrado");
            }
            return listUsuario.get(codigo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void editar(Usuario objeto) throws Exception {
        try {
            if (!listUsuario.containsKey(objeto.getUsuario())) {
                throw new Exception("El Usuario no se encuentra registrado");
            }
            listUsuario.put(objeto.getUsuario(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!listUsuario.containsKey(codigo)) {
                throw new Exception("El Usuario no se encuentra registrado");
            }
            listUsuario.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Usuario> listarTodo() throws Exception {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            if(listUsuario.isEmpty()){
                throw new Exception("No se encuentran elementos dentro de la lista.");
            }
            for(Map.Entry<String, Usuario> informes : listUsuario.entrySet()){
                String clave = informes.getKey();
                Usuario usuario = informes.getValue();

                usuarios.add(usuario);
            }
            return usuarios;

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return null;
    }

    @Override
    public int contar() throws Exception {
        List<Usuario> numeroUsuarios = listarTodo();
        int numeroElementos = 0;

        try {
            numeroElementos = numeroUsuarios.size();
            if(numeroElementos == 0)  {
                throw new Exception("Esta lista no tiene elementos");
            }
            return numeroElementos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
