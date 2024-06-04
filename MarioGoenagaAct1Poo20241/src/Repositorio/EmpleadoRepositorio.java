package Repositorio;

import Dominio.Empleado;
import Persistencia.EmpleadoJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmpleadoRepositorio {
    
    public static EmpleadoJpaController repositorio = new EmpleadoJpaController();
    
    public void crear(Empleado empleado){
        repositorio.create(empleado);
    }
    
    public void editar(Empleado empleado){
        try {
            repositorio.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void destruir(int id){
        try {
            repositorio.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpleadoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Empleado buscar(int id){
        return repositorio.findEmpleado(id);
    }
    
    public List<Empleado> buscarTodo(){
        return repositorio.findEmpleadoEntities();
    }
}
