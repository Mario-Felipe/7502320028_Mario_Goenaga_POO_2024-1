package Repositorio;

import Dominio.Version;
import Persistencia.VersionJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VersionRepositorio {
    
    public static VersionJpaController repositorio = new VersionJpaController();
    
    public void crear(Version version){
        repositorio.create(version);
    }
    
    public void edit(Version version){
        try {
            repositorio.edit(version);
        } catch (Exception ex) {
            Logger.getLogger(VersionRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void destroy(int id){
        try {
            repositorio.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(VersionRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Version buscar(int id){
        return repositorio.findVersion(id);
    }
    
    public List<Version> buscarTodo(){
        return repositorio.findVersionEntities();
    }
    
}
