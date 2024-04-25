package Crud;

import Dominio.Proyecto;
import Model.ModeloCrud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProyectoCrud implements ModeloCrud<Proyecto> {
    private HashMap<String, Proyecto> listProyecto;

    @Override
    public void agregar(Proyecto objeto) throws Exception {
        try {
            if (listProyecto.containsKey(objeto.getCodigoProyecto())) {
                throw new Exception("El Proyecto ya se encuentra registrado");
            }
            listProyecto.put(objeto.getNombreClave(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Proyecto buscar(String codigo) throws Exception {
        try {
            if (!listProyecto.containsKey(codigo)) {
                throw new Exception("El Proyecto no se encuentra registrado");
            }
            return listProyecto.get(codigo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void editar(Proyecto objeto) throws Exception {
        try {
            if (!listProyecto.containsKey(objeto.getNombreClave())) {
                throw new Exception("El Proyecto no se encuentra registrado");
            }
            listProyecto.put(objeto.getNombreClave(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!listProyecto.containsKey(codigo)) {
                throw new Exception("El Proyecto no se encuentra registrado");
            }
            listProyecto.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Proyecto> listarTodo() throws Exception {
        List<Proyecto> proyectos = new ArrayList<>();

        try {
            if(listProyecto.isEmpty()){
                throw new Exception("No se encuentran elementos dentro de la lista.");
            }
            for(Map.Entry<String, Proyecto> informes : listProyecto.entrySet()){
                String clave = informes.getKey();
                Proyecto proyecto = informes.getValue();

                proyectos.add(proyecto);
            }
            return proyectos;

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return null;
    }

    @Override
    public int contar() throws Exception {
        List<Proyecto> proyectos = listarTodo();
        int numeroElementos = 0;

        try {
            numeroElementos = proyectos.size();
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
