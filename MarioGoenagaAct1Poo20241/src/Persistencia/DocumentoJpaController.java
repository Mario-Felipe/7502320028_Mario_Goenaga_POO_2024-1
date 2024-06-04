package Persistencia;

import Dominio.Documento;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Dominio.Tarea;
import Dominio.Version;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DocumentoJpaController implements Serializable {

    public DocumentoJpaController() {
        emf = Persistence.createEntityManagerFactory("MarioGoenagaAct1Poo20241PU");
    }    

    public DocumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documento documento) {
        if (documento.getVersiones() == null) {
            documento.setVersiones(new LinkedList<Version>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tarea tarea = documento.getTarea();
            if (tarea != null) {
                tarea = em.getReference(tarea.getClass(), tarea.getId());
                documento.setTarea(tarea);
            }
            LinkedList<Version> attachedVersiones = new LinkedList<Version>();
            for (Version versionesVersionToAttach : documento.getVersiones()) {
                versionesVersionToAttach = em.getReference(versionesVersionToAttach.getClass(), versionesVersionToAttach.getId());
                attachedVersiones.add(versionesVersionToAttach);
            }
            documento.setVersiones(attachedVersiones);
            em.persist(documento);
            if (tarea != null) {
                tarea.getDocumentos().add(documento);
                tarea = em.merge(tarea);
            }
            for (Version versionesVersion : documento.getVersiones()) {
                Documento oldDocumentoOfVersionesVersion = versionesVersion.getDocumento();
                versionesVersion.setDocumento(documento);
                versionesVersion = em.merge(versionesVersion);
                if (oldDocumentoOfVersionesVersion != null) {
                    oldDocumentoOfVersionesVersion.getVersiones().remove(versionesVersion);
                    oldDocumentoOfVersionesVersion = em.merge(oldDocumentoOfVersionesVersion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documento documento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documento persistentDocumento = em.find(Documento.class, documento.getId());
            Tarea tareaOld = persistentDocumento.getTarea();
            Tarea tareaNew = documento.getTarea();
            LinkedList<Version> versionesOld = persistentDocumento.getVersiones();
            LinkedList<Version> versionesNew = documento.getVersiones();
            if (tareaNew != null) {
                tareaNew = em.getReference(tareaNew.getClass(), tareaNew.getId());
                documento.setTarea(tareaNew);
            }
            LinkedList<Version> attachedVersionesNew = new LinkedList<Version>();
            for (Version versionesNewVersionToAttach : versionesNew) {
                versionesNewVersionToAttach = em.getReference(versionesNewVersionToAttach.getClass(), versionesNewVersionToAttach.getId());
                attachedVersionesNew.add(versionesNewVersionToAttach);
            }
            versionesNew = attachedVersionesNew;
            documento.setVersiones(versionesNew);
            documento = em.merge(documento);
            if (tareaOld != null && !tareaOld.equals(tareaNew)) {
                tareaOld.getDocumentos().remove(documento);
                tareaOld = em.merge(tareaOld);
            }
            if (tareaNew != null && !tareaNew.equals(tareaOld)) {
                tareaNew.getDocumentos().add(documento);
                tareaNew = em.merge(tareaNew);
            }
            for (Version versionesOldVersion : versionesOld) {
                if (!versionesNew.contains(versionesOldVersion)) {
                    versionesOldVersion.setDocumento(null);
                    versionesOldVersion = em.merge(versionesOldVersion);
                }
            }
            for (Version versionesNewVersion : versionesNew) {
                if (!versionesOld.contains(versionesNewVersion)) {
                    Documento oldDocumentoOfVersionesNewVersion = versionesNewVersion.getDocumento();
                    versionesNewVersion.setDocumento(documento);
                    versionesNewVersion = em.merge(versionesNewVersion);
                    if (oldDocumentoOfVersionesNewVersion != null && !oldDocumentoOfVersionesNewVersion.equals(documento)) {
                        oldDocumentoOfVersionesNewVersion.getVersiones().remove(versionesNewVersion);
                        oldDocumentoOfVersionesNewVersion = em.merge(oldDocumentoOfVersionesNewVersion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = documento.getId();
                if (findDocumento(id) == null) {
                    throw new NonexistentEntityException("The documento with id " + id + " no longer exists.");
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
            Documento documento;
            try {
                documento = em.getReference(Documento.class, id);
                documento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documento with id " + id + " no longer exists.", enfe);
            }
            Tarea tarea = documento.getTarea();
            if (tarea != null) {
                tarea.getDocumentos().remove(documento);
                tarea = em.merge(tarea);
            }
            LinkedList<Version> versiones = documento.getVersiones();
            for (Version versionesVersion : versiones) {
                versionesVersion.setDocumento(null);
                versionesVersion = em.merge(versionesVersion);
            }
            em.remove(documento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documento> findDocumentoEntities() {
        return findDocumentoEntities(true, -1, -1);
    }

    public List<Documento> findDocumentoEntities(int maxResults, int firstResult) {
        return findDocumentoEntities(false, maxResults, firstResult);
    }

    private List<Documento> findDocumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documento.class));
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

    public Documento findDocumento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documento.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documento> rt = cq.from(Documento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
