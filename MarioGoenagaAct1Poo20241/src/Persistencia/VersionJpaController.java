package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Dominio.Documento;
import Dominio.Version;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VersionJpaController implements Serializable {

    public VersionJpaController() {
        emf = Persistence.createEntityManagerFactory("MarioGoenagaAct1Poo20241PU");
    }    

    public VersionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Version version) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documento documento = version.getDocumento();
            if (documento != null) {
                documento = em.getReference(documento.getClass(), documento.getId());
                version.setDocumento(documento);
            }
            em.persist(version);
            if (documento != null) {
                documento.getVersiones().add(version);
                documento = em.merge(documento);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Version version) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Version persistentVersion = em.find(Version.class, version.getId());
            Documento documentoOld = persistentVersion.getDocumento();
            Documento documentoNew = version.getDocumento();
            if (documentoNew != null) {
                documentoNew = em.getReference(documentoNew.getClass(), documentoNew.getId());
                version.setDocumento(documentoNew);
            }
            version = em.merge(version);
            if (documentoOld != null && !documentoOld.equals(documentoNew)) {
                documentoOld.getVersiones().remove(version);
                documentoOld = em.merge(documentoOld);
            }
            if (documentoNew != null && !documentoNew.equals(documentoOld)) {
                documentoNew.getVersiones().add(version);
                documentoNew = em.merge(documentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = version.getId();
                if (findVersion(id) == null) {
                    throw new NonexistentEntityException("The version with id " + id + " no longer exists.");
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
            Version version;
            try {
                version = em.getReference(Version.class, id);
                version.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The version with id " + id + " no longer exists.", enfe);
            }
            Documento documento = version.getDocumento();
            if (documento != null) {
                documento.getVersiones().remove(version);
                documento = em.merge(documento);
            }
            em.remove(version);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Version> findVersionEntities() {
        return findVersionEntities(true, -1, -1);
    }

    public List<Version> findVersionEntities(int maxResults, int firstResult) {
        return findVersionEntities(false, maxResults, firstResult);
    }

    private List<Version> findVersionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Version.class));
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

    public Version findVersion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Version.class, id);
        } finally {
            em.close();
        }
    }

    public int getVersionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Version> rt = cq.from(Version.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
