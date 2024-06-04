package Repositorio;

import Dominio.Proyecto;
import Persistencia.ProyectoJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProyectoRepositorio {
    
    public static ProyectoJpaController repositorio = new ProyectoJpaController();
    
    public void crear(Proyecto proyecto){
        repositorio.create(proyecto);
    }
    
    public void editar(Proyecto proyecto){
        try {
            repositorio.edit(proyecto);
        } catch (Exception ex) {
            Logger.getLogger(ProyectoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void destruir(int id){
        try {
            repositorio.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProyectoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Proyecto buscar(int id){
        return repositorio.findProyecto(id);
    }
    
    public List
        <Proyecto> buscarTodo(){
        return repositorio.findProyectoEntities(); 
    }
        
}
