package Crud;

import Dominio.Tarea;
import Model.ModeloCrud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TareaCrud implements ModeloCrud<Tarea> {

    private HashMap<String, Tarea> listTarea;
    @Override
    public void agregar(Tarea objeto) throws Exception {
        try {
            if (listTarea.containsKey(objeto.getDescripcion())) {
                throw new Exception("La tarea ya se encuentra registrado");
            }
            listTarea.put(objeto.getDescripcion(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Tarea buscar(String codigo) throws Exception {
        try {
            if (!listTarea.containsKey(codigo)) {
                throw new Exception("La tarea no se encuentra registrado");
            }
            return listTarea.get(codigo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void editar(Tarea objeto) throws Exception {
        try {
            if (!listTarea.containsKey(objeto.getDescripcion())) {
                throw new Exception("El documento no se encuentra registrado");
            }
            listTarea.put(objeto.getDescripcion(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!listTarea.containsKey(codigo)) {
                throw new Exception("El documento no se encuentra registrado");
            }
            listTarea.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Tarea> listarTodo() throws Exception {
        List<Tarea> tareas = new ArrayList<>();

        try {
            if(listTarea.isEmpty()){
                throw new Exception("No se encuentran elementos dentro de la lista.");
            }
            for(Map.Entry<String, Tarea> informes : listTarea.entrySet()){
                String clave = informes.getKey();
                Tarea tarea = informes.getValue();

                tareas.add(tarea);
            }
            return tareas;

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return null;
    }

    @Override
    public int contar() throws Exception {
        List<Tarea> tareas = listarTodo();
        int numeroElementos = 0;

        try {
            numeroElementos = tareas.size();
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
