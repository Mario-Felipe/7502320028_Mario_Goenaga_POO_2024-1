package Repositorio;

import Dominio.Empresa;
import Persistencia.EmpresaJpaController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;


public class EmpresaRepositorio {
    
    public static EmpresaJpaController repositorio = new EmpresaJpaController();
    
    public void crear(Empresa empresa){
        try {
            if (encontrarEmpresa(empresa.getNit()) != null) {
                throw new Exception("La empresa ya ase encuentra en la BD");
            }
            repositorio.create(empresa);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
    }
    
    public void editar(Empresa empresa){
        try {
            if (encontrarEmpresa(empresa.getNit()) == null) {
                throw new Exception("La empresa no se encuentra en la BD");
            }
            repositorio.edit(empresa);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void destruir(String empresa){
        Empresa encontrado = encontrarEmpresa(empresa);
        try {
            if ( encontrado == null) {
                throw new Exception("La empresa no se encuentra en la BD");
            }
            repositorio.destroy(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public Empresa buscar(String empresa){
        Empresa encontrado = encontrarEmpresa(empresa);
        try {
            if (encontrado == null) {
                throw new Exception("La empresa no se encuentra en la BD");

            }
            return repositorio.findEmpresa(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return null;
        }        
    }
    
    public List<Empresa> buscarTodo(){
        return repositorio.findEmpresaEntities();               
    }
    
    public Empresa encontrarEmpresa(String codigo){
        Empresa encontrado = null;
        
        List<Empresa> lista = buscarTodo();
        
        Map<String, Empresa> listaEmpresas = new HashMap();
        
        for(Empresa entry : lista){
            listaEmpresas.put(entry.getNit(), entry);
        
        }
        
        encontrado = listaEmpresas.get(codigo);
        
        if(encontrado != null){
            return encontrado;
        } else {
            return null;
        }
    }
    
}
