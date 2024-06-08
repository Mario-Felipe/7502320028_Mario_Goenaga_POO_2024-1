package Repositorio;

import Dominio.Empleado;
import Persistencia.EmpleadoJpaController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;


public class EmpleadoRepositorio {
    
    public static EmpleadoJpaController repositorio = new EmpleadoJpaController();
    
    public void crear(Empleado empleado){
        try {
            if (encontrarEmpleado(empleado.getDni()) != null) {
                throw new Exception("El empleado ya ase encuentra en la BD");
            }
            repositorio.create(empleado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editar(Empleado empleado){
        try {
            if (encontrarEmpleado(empleado.getDni()) == null) {
                throw new Exception("El empleado no se encuentra en la BD");
            }
            repositorio.edit(empleado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void destruir(String empleado){
        Empleado encontrado = encontrarEmpleado(empleado);
        try {
            if ( encontrado == null) {
                throw new Exception("El empleado no se encuentra en la BD");
            }
            repositorio.destroy(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public Empleado buscar(String empleado){
        Empleado encontrado = encontrarEmpleado(empleado);
        try {
            if (encontrado == null) {
                throw new Exception("El empleado no se encuentra en la BD");

            }
            return repositorio.findEmpleado(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return null;
        }        
    }
    
    public List<Empleado> buscarTodo(){
        return repositorio.findEmpleadoEntities();
    }
    
    public Empleado encontrarEmpleado(String codigo){
        Empleado encontrado = null;
        
        List<Empleado> lista = buscarTodo();
        
        Map<String, Empleado> listaEmpleados = new HashMap();
        
        for(Empleado entry : lista){
            listaEmpleados.put(entry.getDni(), entry);
        
        }
        
        encontrado = listaEmpleados.get(codigo);
        
        if(encontrado != null){
            return encontrado;
        } else {
            return null;
        }
    }
}
