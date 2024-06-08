package Repositorio;

import Dominio.Version;
import Persistencia.VersionJpaController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class VersionRepositorio {

    public static VersionJpaController repositorio = new VersionJpaController();

    public void crear(Version version) {

        try {
            if (encontrarVersion(version.getIdentificacion()) != null) {
                throw new Exception("La versión ya ase encuentra en la BD");
            }
            repositorio.create(version);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

    public void editar(Version version) {
        try {
            if (encontrarVersion(version.getIdentificacion()) == null) {
                throw new Exception("La versión no se encuentra en la BD");
            }
            repositorio.edit(version);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void destruir(String version) {
        Version encontrado = encontrarVersion(version);
        try {
            if (encontrado == null) {
                throw new Exception("La version no se encuentra en la BD");
            }
            repositorio.destroy(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public Version buscar(String version) {
        Version encontrado = encontrarVersion(version);
        try {
            if (encontrado == null) {
                throw new Exception("La versión no se encuentra en la BD");

            }
            return repositorio.findVersion(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return null;
        }

    }

    public List<Version> buscarTodo() {
        return repositorio.findVersionEntities();
    }

    public Version encontrarVersion(String codigo) {
        Version encontrado = null;

        List<Version> lista = buscarTodo();

        Map<String, Version> listaVersiones = new HashMap();

        for (Version entry : lista) {
            listaVersiones.put(entry.getIdentificacion(), entry);

        }

        encontrado = listaVersiones.get(codigo);

        if (encontrado != null) {
            return encontrado;
        } else {
            return null;
        }

    }

}
