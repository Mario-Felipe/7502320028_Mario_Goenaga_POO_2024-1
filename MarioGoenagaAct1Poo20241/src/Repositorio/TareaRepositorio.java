package Repositorio;

import Dominio.Tarea;
import Persistencia.TareaJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TareaRepositorio {
    
    public static TareaJpaController repositorio = new TareaJpaController();
    
    public void crear(Tarea tarea){
        repositorio.create(tarea);
    }
    
    public void editar(Tarea tarea){
        try {
            repositorio.edit(tarea);
        } catch (Exception ex) {
            Logger.getLogger(TareaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void destruir(int id){
        try {
            repositorio.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(TareaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Tarea buscar(int id){
        return repositorio.findTarea(id);
    }
    
    public List<Tarea> buscarTodo(){
        return repositorio.findTareaEntities();
    }
    
}
