package Repositorio;

import Dominio.Empresa;
import Persistencia.EmpresaJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmpresaRepositorio {
    
    public static EmpresaJpaController repositorio = new EmpresaJpaController();
    
    public void crear(Empresa empresa){
        repositorio.create(empresa);
    }
    
    public void editar(Empresa empresa){
        try {
            repositorio.edit(empresa);
        } catch (Exception ex) {
            Logger.getLogger(EmpresaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void destruir(int id){
        try {
            repositorio.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpresaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Empresa buscar(int id){
        return repositorio.findEmpresa(id);
    }
    
    public List<Empresa> buscarTodo(){
        return repositorio.findEmpresaEntities();               
    }
    
}
