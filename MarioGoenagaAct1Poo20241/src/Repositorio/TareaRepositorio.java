package Repositorio;

import Dominio.Tarea;
import Persistencia.TareaJpaController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;


public class TareaRepositorio {
    
    public static TareaJpaController repositorio = new TareaJpaController();
    
    public void crear(Tarea tarea){
        
        try {
            if (encontrarTarea(tarea.getIdentificadorTarea()) != null) {
                throw new Exception("La tarea ya ase encuentra en la BD");
            }
            repositorio.create(tarea);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
    }
    
    public void editar(Tarea tarea){
        try {
            if (encontrarTarea(tarea.getIdentificadorTarea()) == null) {
                throw new Exception("La tarea no se encuentra en la BD");
            }
            repositorio.edit(tarea);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void destruir(String tarea){
        Tarea encontrado = encontrarTarea(tarea );
        try {
            if ( encontrado == null) {
                throw new Exception("La tarea no se encuentra en la BD");
            }
            repositorio.destroy(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public Tarea buscar(String tarea){
        Tarea encontrado = encontrarTarea(tarea);
        try {
            if (encontrado == null) {
                throw new Exception("El usuario no se encuentra en la BD");

            }
            return repositorio.findTarea(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return null;            
        }    
    }
    
    public List<Tarea> buscarTodo(){
        return repositorio.findTareaEntities();
    }
    
    public int contarTodoTarea(){        
        return repositorio.getTareaCount();
    }
    
    public Tarea encontrarTarea(String codigo){
        Tarea encontrado = null;
        
        List<Tarea> lista = buscarTodo();
        
        Map<String, Tarea> listaTareas = new HashMap();
        
        for(Tarea entry : lista){
            listaTareas.put(entry.getIdentificadorTarea(), entry);
        
        }
        
        encontrado = listaTareas.get(codigo);
        
        if(encontrado != null){
            return encontrado;
        } else {
            return null;
        }
        
    }  
}
