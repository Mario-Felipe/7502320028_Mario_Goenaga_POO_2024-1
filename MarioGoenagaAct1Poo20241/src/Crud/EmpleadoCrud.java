package Crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dominio.Empleado;
import Model.ModeloCrud;


public class EmpleadoCrud implements ModeloCrud<Empleado>{

    private HashMap<String, Empleado> listEmpleado = new HashMap<>();
    
    public EmpleadoCrud() {
        this.listEmpleado = new HashMap<>();
    }

    @Override
    public void agregar(Empleado objeto) throws Exception {
        try {
            if (listEmpleado.containsKey(objeto.getDni())) {
                throw new Exception("El empleado ya se encuentra registrado");
            }
            listEmpleado.put(objeto.getDni(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
             
    }

    @Override
    public Empleado buscar(String codigo) throws Exception {
        try {
            if (!listEmpleado.containsKey(codigo)) {
                throw new Exception("El empleado no se encuentra registrado");
            }
            return listEmpleado.get(codigo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void editar(Empleado objeto) throws Exception {
        try {
            if (!listEmpleado.containsKey(objeto.getDni())) {
                throw new Exception("El empleado no se encuentra registrado");
            }
            listEmpleado.put(objeto.getDni(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!listEmpleado.containsKey(codigo)) {
                throw new Exception("El empleado no se encuentra registrado");
            }
            listEmpleado.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
    }

    @Override
    public List<Empleado> listarTodo() throws Exception {
        List<Empleado> empleados = new ArrayList<>();

        try {
            if(listEmpleado.isEmpty()){
                throw new Exception("No se encuentran empleados dentro de la lista.");
            } 
            for(Map.Entry<String, Empleado> informes : listEmpleado.entrySet()){
                String clave = informes.getKey();
                Empleado empleado = informes.getValue();

                empleados.add(empleado);
                }
            return empleados;       
                
            } catch (Exception e) {
                System.out.println(e.getMessage());   

        } 

        return null; 
    }

    @Override
    public int contar() throws Exception {
        List<Empleado> numeroEmpleados = listarTodo();
        int numeroElementos = 0;

        try {
            numeroElementos = numeroEmpleados.size();  
            if(numeroElementos == 0)  {
                throw new Exception("Esta lista no tiene empleados");
            }  
            return numeroElementos;     
        } catch (Exception e) {
            System.out.println(e.getMessage());            
        }
        return 0;
        
    }

         
    
}
