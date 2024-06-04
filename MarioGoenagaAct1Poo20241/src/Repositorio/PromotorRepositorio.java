package Repositorio;

import Dominio.Promotor;
import Persistencia.PromotorJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PromotorRepositorio {
    
    public static PromotorJpaController repositorio = new PromotorJpaController();
    
    public void crear(Promotor promotor){
        repositorio.create(promotor);
    }
    
    public void editar(Promotor promotor){
        try {
            repositorio.edit(promotor);
        } catch (Exception ex) {
            Logger.getLogger(PromotorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void destroy(int id){
        try {
            repositorio.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PromotorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Promotor buscar(int id){
        return repositorio.findPromotor(id);
    }
    
    public List<Promotor> buscarTodo(){
        return repositorio.findPromotorEntities();                
    }
    
}
