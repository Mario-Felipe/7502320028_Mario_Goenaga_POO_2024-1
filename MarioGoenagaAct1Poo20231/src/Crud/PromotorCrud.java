package Crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dominio.Promotor;
import Model.ModeloCrud;

public class PromotorCrud implements ModeloCrud<Promotor>{
    private HashMap<String, Promotor> listPromotor;

    @Override
    public void agregar(Promotor objeto) throws Exception {
        try {
            if (listPromotor.containsKey(objeto.getDni())) {
                throw new Exception("El Promotor ya se encuentra registrado");
            }
            listPromotor.put(objeto.getDni(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Promotor buscar(String codigo) throws Exception {
        try {
            if (!listPromotor.containsKey(codigo)) {
                throw new Exception("El promotor no se encuentra registrado");
            }
            return listPromotor.get(codigo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void editar(Promotor objeto) throws Exception {
        try {
            if (!listPromotor.containsKey(objeto.getDni())) {
                throw new Exception("El promotor no se encuentra registrado");
            }
            listPromotor.put(objeto.getDni(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!listPromotor.containsKey(codigo)) {
                throw new Exception("El promotor no se encuentra registrado");
            }
            listPromotor.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Promotor> listarTodo() throws Exception {
        List<Promotor> promotores = new ArrayList<>();
        try {
            if(listPromotor.isEmpty()){
                throw new Exception("No se encuentran elementos dentro de la lista.");
            } 
            for(Map.Entry<String, Promotor> informes : listPromotor.entrySet()){
                String clave = informes.getKey();
                Promotor promotor = informes.getValue();

                promotores.add(promotor);
                }
            return promotores;       
                
            } catch (Exception e) {
                System.out.println(e.getMessage());   

        } 

        return null;
    }

    @Override
    public int contar() throws Exception {
        List<Promotor> numeroPromotores = listarTodo();
        int numeroElementos = 0;

        try {
            numeroElementos = numeroPromotores.size();  
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
