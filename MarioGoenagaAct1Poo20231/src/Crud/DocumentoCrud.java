package Crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dominio.Documento;
import Model.ModeloCrud;

public class DocumentoCrud implements ModeloCrud<Documento> {

    private HashMap<String, Documento> listDocumento = new HashMap<>();

    
    public DocumentoCrud() {  
        this.listDocumento = new HashMap<>();      
    }

    @Override
    public void agregar(Documento objeto) throws Exception {
        try {
            if (listDocumento.containsKey(objeto.getCodigoDocumento())) {
                throw new Exception("El documento ya se encuentra registrado");
            }
            listDocumento.put(objeto.getCodigoDocumento(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Documento buscar(String codigo) throws Exception {
        try {
            if (!listDocumento.containsKey(codigo)) {
                throw new Exception("El documento no se encuentra registrado");
            }
            return listDocumento.get(codigo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public void editar(Documento objeto) throws Exception {
        try {
            if (!listDocumento.containsKey(objeto.getCodigoDocumento())) {
                throw new Exception("El documento no se encuentra registrado");
            }
            listDocumento.put(objeto.getCodigoDocumento(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!listDocumento.containsKey(codigo)) {
                throw new Exception("El documento no se encuentra registrado");
            }
            listDocumento.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Documento> listarTodo() throws Exception {
        List<Documento> documentos = new ArrayList<>();

        try {
            if(listDocumento.isEmpty()){
                throw new Exception("No se encuentran elementos dentro de la lista.");
            } 
            for(Map.Entry<String, Documento> informes : listDocumento.entrySet()){
                String clave = informes.getKey();
                Documento documento = informes.getValue();

                documentos.add(documento);
                }
            return documentos;       
                
            } catch (Exception e) {
                System.out.println(e.getMessage());   

        } 

        return null;   

        }
        
    @Override
    public int contar() throws Exception {
        List<Documento> numeroDocumentos = listarTodo();
        int numeroElementos = 0;

        try {
            numeroElementos = numeroDocumentos.size();  
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
