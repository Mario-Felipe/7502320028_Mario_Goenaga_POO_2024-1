package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Dominio.Proyecto;
import Dominio.Documento;
import Dominio.Tarea;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TareaJpaController implements Serializable {

    public TareaJpaController() {
        emf = Persistence.createEntityManagerFactory("MarioGoenagaAct1Poo20241PU");
    }    

    public TareaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tarea tarea) {
        if (tarea.getDocumentos() == null) {
            tarea.setDocumentos(new LinkedList<Documento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyecto proyecto = tarea.getProyecto();
            if (proyecto != null) {
                proyecto = em.getReference(proyecto.getClass(), proyecto.getId());
                tarea.setProyecto(proyecto);
            }
            LinkedList<Documento> attachedDocumentos = new LinkedList<Documento>();
            for (Documento documentosDocumentoToAttach : tarea.getDocumentos()) {
                documentosDocumentoToAttach = em.getReference(documentosDocumentoToAttach.getClass(), documentosDocumentoToAttach.getId());
                attachedDocumentos.add(documentosDocumentoToAttach);
            }
            tarea.setDocumentos(attachedDocumentos);
            em.persist(tarea);
            if (proyecto != null) {
                proyecto.getTareas().add(tarea);
                proyecto = em.merge(proyecto);
            }
            for (Documento documentosDocumento : tarea.getDocumentos()) {
                Tarea oldTareaOfDocumentosDocumento = documentosDocumento.getTarea();
                documentosDocumento.setTarea(tarea);
                documentosDocumento = em.merge(documentosDocumento);
                if (oldTareaOfDocumentosDocumento != null) {
                    oldTareaOfDocumentosDocumento.getDocumentos().remove(documentosDocumento);
                    oldTareaOfDocumentosDocumento = em.merge(oldTareaOfDocumentosDocumento);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tarea tarea) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tarea persistentTarea = em.find(Tarea.class, tarea.getId());
            Proyecto proyectoOld = persistentTarea.getProyecto();
            Proyecto proyectoNew = tarea.getProyecto();
            LinkedList<Documento> documentosOld = persistentTarea.getDocumentos();
            LinkedList<Documento> documentosNew = tarea.getDocumentos();
            if (proyectoNew != null) {
                proyectoNew = em.getReference(proyectoNew.getClass(), proyectoNew.getId());
                tarea.setProyecto(proyectoNew);
            }
            LinkedList<Documento> attachedDocumentosNew = new LinkedList<Documento>();
            for (Documento documentosNewDocumentoToAttach : documentosNew) {
                documentosNewDocumentoToAttach = em.getReference(documentosNewDocumentoToAttach.getClass(), documentosNewDocumentoToAttach.getId());
                attachedDocumentosNew.add(documentosNewDocumentoToAttach);
            }
            documentosNew = attachedDocumentosNew;
            tarea.setDocumentos(documentosNew);
            tarea = em.merge(tarea);
            if (proyectoOld != null && !proyectoOld.equals(proyectoNew)) {
                proyectoOld.getTareas().remove(tarea);
                proyectoOld = em.merge(proyectoOld);
            }
            if (proyectoNew != null && !proyectoNew.equals(proyectoOld)) {
                proyectoNew.getTareas().add(tarea);
                proyectoNew = em.merge(proyectoNew);
            }
            for (Documento documentosOldDocumento : documentosOld) {
                if (!documentosNew.contains(documentosOldDocumento)) {
                    documentosOldDocumento.setTarea(null);
                    documentosOldDocumento = em.merge(documentosOldDocumento);
                }
            }
            for (Documento documentosNewDocumento : documentosNew) {
                if (!documentosOld.contains(documentosNewDocumento)) {
                    Tarea oldTareaOfDocumentosNewDocumento = documentosNewDocumento.getTarea();
                    documentosNewDocumento.setTarea(tarea);
                    documentosNewDocumento = em.merge(documentosNewDocumento);
                    if (oldTareaOfDocumentosNewDocumento != null && !oldTareaOfDocumentosNewDocumento.equals(tarea)) {
                        oldTareaOfDocumentosNewDocumento.getDocumentos().remove(documentosNewDocumento);
                        oldTareaOfDocumentosNewDocumento = em.merge(oldTareaOfDocumentosNewDocumento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tarea.getId();
                if (findTarea(id) == null) {
                    throw new NonexistentEntityException("The tarea with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tarea tarea;
            try {
                tarea = em.getReference(Tarea.class, id);
                tarea.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tarea with id " + id + " no longer exists.", enfe);
            }
            Proyecto proyecto = tarea.getProyecto();
            if (proyecto != null) {
                proyecto.getTareas().remove(tarea);
                proyecto = em.merge(proyecto);
            }
            LinkedList<Documento> documentos = tarea.getDocumentos();
            for (Documento documentosDocumento : documentos) {
                documentosDocumento.setTarea(null);
                documentosDocumento = em.merge(documentosDocumento);
            }
            em.remove(tarea);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tarea> findTareaEntities() {
        return findTareaEntities(true, -1, -1);
    }

    public List<Tarea> findTareaEntities(int maxResults, int firstResult) {
        return findTareaEntities(false, maxResults, firstResult);
    }

    private List<Tarea> findTareaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tarea.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tarea findTarea(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tarea.class, id);
        } finally {
            em.close();
        }
    }

    public int getTareaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tarea> rt = cq.from(Tarea.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
