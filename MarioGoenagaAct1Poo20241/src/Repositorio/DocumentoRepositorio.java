package Repositorio;

import Dominio.Documento;
import Persistencia.DocumentoJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DocumentoRepositorio {
    
     public static DocumentoJpaController repositorio = new DocumentoJpaController();
     
     public void crear(Documento documento){
         repositorio.create(documento);
     }
     
     public void editar(Documento documento){
         try {
             repositorio.edit(documento);
         } catch (Exception ex) {
             Logger.getLogger(DocumentoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public void destruir(int id){
         try {
             repositorio.destroy(id);
         } catch (NonexistentEntityException ex) {
             Logger.getLogger(DocumentoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public Documento buscar(int id){               
         return repositorio.findDocumento(id);
     }
     
     public List<Documento> buscarTodo(){
         return repositorio.findDocumentoEntities();
     }
    
}