package Crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dominio.Empresa;
import Model.ModeloCrud;

public class EmpresaCrud implements ModeloCrud<Empresa> {
    private HashMap<String, Empresa> listEmpresa;

    @Override
    public void agregar(Empresa objeto) throws Exception {
        try {
            if (listEmpresa.containsKey(objeto.getNit())) {
                throw new Exception("El Nit. ya se encuentra registrado");
            }
            listEmpresa.put(objeto.getNit(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }     
    }

    @Override
    public Empresa buscar(String codigo) throws Exception {
        try {
            if (!listEmpresa.containsKey(codigo)) {
                throw new Exception("El Nit. no se encuentra registrado");
            }
            return listEmpresa.get(codigo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;       
    }

    @Override
    public void editar(Empresa objeto) throws Exception {
        try {
            if (!listEmpresa.containsKey(objeto.getNit())) {
                throw new Exception("El Nit. no se encuentra registrado");
            }
            listEmpresa.put(objeto.getNit(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!listEmpresa.containsKey(codigo)) {
                throw new Exception("El Nit. no se encuentra registrado");
            }
            listEmpresa.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Empresa> listarTodo() throws Exception {
        List<Empresa> empleados = new ArrayList<>();

        try {
            if(listEmpresa.isEmpty()){
                throw new Exception("No se encuentran elementos dentro de la lista.");
            } 
            for(Map.Entry<String, Empresa> informes : listEmpresa.entrySet()){
                String clave = informes.getKey();
                Empresa empresa = informes.getValue();

                empleados.add(empresa);
                }
            return empleados;       
                
            } catch (Exception e) {
                System.out.println(e.getMessage());   

        } 

        return null;                   
    }

    @Override
    public int contar() throws Exception {
        List<Empresa> numeroEmpresas = listarTodo();
        int numeroElementos = 0;

        try {
            numeroElementos = numeroEmpresas.size();  
            if(numeroElementos == 0)  {
                throw new Exception("Esta lista no tiene elementos");
            }  
            return numeroElementos;     
        } catch (Exception e) {
            System.out.println(e.getMessage());            
        }
        return 0;        
    }



    
}
