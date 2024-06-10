package Repositorio;

import Dominio.Promotor;
import Persistencia.PromotorJpaController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;


public class PromotorRepositorio {
    
    public static PromotorJpaController repositorio = new PromotorJpaController();
    
    public void crear(Promotor promotor){
        try {
            if (encontrarPromotor(promotor.getUsuario()) != null) {
                throw new Exception("El promotor ya se encuentra en la BD");
            }
            repositorio.create(promotor);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editar(Promotor promotor){
        try {
            if (encontrarPromotor(promotor.getDni()) == null) {
                throw new Exception("El promotor no se encuentra en la BD");
            }
            repositorio.edit(promotor);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void destruir(String promotor){
        Promotor encontrado = encontrarPromotor(promotor);
        try {
            if ( encontrado == null) {
                throw new Exception("El promotor no se encuentra en la BD");
            }
            repositorio.destroy(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public Promotor buscar(String promotor){
        Promotor encontrado = encontrarPromotor(promotor);
        try {
            if (encontrado == null) {
                throw new Exception("El promotor no se encuentra en la BD");

            }
            return repositorio.findPromotor(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return null;
        }
    }
    
    public List<Promotor> buscarTodo(){
        return repositorio.findPromotorEntities();                
    }
    
    public int contarTodoPromotor(){        
        return repositorio.getPromotorCount();
    }
    
    public Promotor encontrarPromotor(String codigo){
        Promotor encontrado = null;
        
        List<Promotor> lista = buscarTodo();
        
        Map<String, Promotor> listaPromotores = new HashMap();
        
        for(Promotor entry : lista){
            listaPromotores.put(entry.getDni(), entry);
        
        }
        
        encontrado = listaPromotores.get(codigo);
        
        if(encontrado != null){
            return encontrado;
        } else {
            return null;
        }
    }
}
