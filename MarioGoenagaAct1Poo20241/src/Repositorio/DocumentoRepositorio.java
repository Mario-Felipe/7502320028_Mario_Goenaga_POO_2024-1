package Repositorio;

import Dominio.Documento;
import Persistencia.DocumentoJpaController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;


public class DocumentoRepositorio {
    
     public static DocumentoJpaController repositorio = new DocumentoJpaController();
     
     public void crear(Documento documento){
         try {
            if (encontrarDocumento(documento.getCodigoDocumento()) != null) {
                throw new Exception("El documento ya ase encuentra en la BD");
            }
            repositorio.create(documento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
     }
     
     public void editar(Documento documento){
         try {
            if (encontrarDocumento(documento.getCodigoDocumento()) == null) {
                throw new Exception("El documento no se encuentra en la BD");
            }
            repositorio.edit(documento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
     }
     
     public void destruir(String documento){
         Documento encontrado = encontrarDocumento(documento);
        try {
            if ( encontrado == null) {
                throw new Exception("El docuemtno no se encuentra en la BD");
            }
            repositorio.destroy(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
     }
     
     public Documento buscar(String documento){               
         Documento encontrado = encontrarDocumento(documento);
        try {
            if (encontrado == null) {
                throw new Exception("El documento no se encuentra en la BD");

            }
            return repositorio.findDocumento(encontrado.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return null;
        }    
     }
     
     public List<Documento> buscarTodo(){
         return repositorio.findDocumentoEntities();
     }
     
     public int contarTodoDocumento(){        
        return repositorio.getDocumentoCount();
    }
     
     public Documento encontrarDocumento(String codigo){
         Documento encontrado = null;
         
         List<Documento> lista = buscarTodo();
         
         Map<String, Documento> listaDocumentos = new HashMap<>();
         
         for(Documento entry : lista){
             listaDocumentos.put(entry.getCodigoDocumento(), entry);
         }
         
         encontrado = listaDocumentos.get(codigo);
         
         if (encontrado != null){
             return encontrado;
         } else {
             return null;
         }
     }
    
}