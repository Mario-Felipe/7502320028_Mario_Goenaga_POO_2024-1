package Repositorio;

import Dominio.Proyecto;
import Persistencia.ProyectoJpaController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;


public class ProyectoRepositorio {
    
    public static ProyectoJpaController repositorio = new ProyectoJpaController();
    
    public void crear(Proyecto proyecto){
        try {
            if (encontrarProyecto(proyecto.getCodigoProyecto()) != null) {
                throw new Exception("El proyecto ya ase encuentra en la BD");
            }
            repositorio.create(proyecto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
    }
    
    public void editar(Proyecto proyecto){
        try {
            if (encontrarProyecto(proyecto.getCodigoProyecto()) == null) {
                throw new Exception("El proiyecto no se encuentra en la BD");
            }
            repositorio.edit(proyecto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void destruir(String proyecto){
        Proyecto encontrado = encontrarProyecto(proyecto);
        try {
            if ( encontrado == null) {
                throw new Exception("El proyecto no se encuentra en la BD");
            }
            repositorio.destroy(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public Proyecto buscar(String proyecto){
        Proyecto encontrado = encontrarProyecto(proyecto);
        try {
            if (encontrado == null) {
                throw new Exception("El proyecto no se encuentra en la BD");

            }
            return repositorio.findProyecto(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return null;
        }
    }
    
    public List
        <Proyecto> buscarTodo(){
        return repositorio.findProyectoEntities(); 
    }
        
    public Proyecto encontrarProyecto(String codigo){
        Proyecto encontrado = null;
        
        List<Proyecto> lista = buscarTodo();
        
        Map<String, Proyecto> listaProyectos = new HashMap();
        
        for(Proyecto entry : lista){
            listaProyectos.put(entry.getCodigoProyecto(), entry);
        
        }
        
        encontrado = listaProyectos.get(codigo);
        
        if(encontrado != null){
            return encontrado;
        } else {
            return null;
        }
        
    }    
        
}
