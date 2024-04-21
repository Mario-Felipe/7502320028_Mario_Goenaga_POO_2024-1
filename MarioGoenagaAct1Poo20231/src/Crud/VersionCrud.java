package Crud;

import Dominio.Version;
import Model.ModeloCrud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VersionCrud implements ModeloCrud<Version> {

    private HashMap<String, Version> listVersion;
    @Override
    public void agregar(Version objeto) throws Exception {
        try {
            if (listVersion.containsKey(objeto.getIdentificacion())) {
                throw new Exception("La version ya se encuentra registrado");
            }
            listVersion.put(objeto.getIdentificacion(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Version buscar(String codigo) throws Exception {
        try {
            if (!listVersion.containsKey(codigo)) {
                throw new Exception("La version no se encuentra registrado");
            }
            return listVersion.get(codigo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void editar(Version objeto) throws Exception {
        try {
            if (!listVersion.containsKey(objeto.getIdentificacion())) {
                throw new Exception("La version no se encuentra registrado");
            }
            listVersion.put(objeto.getIdentificacion(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!listVersion.containsKey(codigo)) {
                throw new Exception("La version no se encuentra registrado");
            }
            listVersion.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Version> listarTodo() throws Exception {
        List<Version> versiones = new ArrayList<>();

        try {
            if(listVersion.isEmpty()){
                throw new Exception("No se esta version elementos dentro de la lista.");
            }
            for(Map.Entry<String, Version> informes : listVersion.entrySet()){
                String clave = informes.getKey();
                Version version = informes.getValue();

                versiones.add(version);
            }
            return versiones;

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return null;
    }

    @Override
    public int contar() throws Exception {
        List<Version> versiones = listarTodo();
        int numeroElementos = 0;

        try {
            numeroElementos = versiones.size();
            if(numeroElementos == 0)  {
                throw new Exception("Esta Version no tiene elementos");
            }
            return numeroElementos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}