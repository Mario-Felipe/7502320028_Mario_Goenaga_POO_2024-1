package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Dominio.Empresa;
import Dominio.Promotor;
import Dominio.Proyecto;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PromotorJpaController implements Serializable {

    public PromotorJpaController() {
        emf = Persistence.createEntityManagerFactory("MarioGoenagaAct1Poo20241PU");
    }    

    public PromotorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Promotor promotor) {
        if (promotor.getProyectos() == null) {
            promotor.setProyectos(new LinkedList<Proyecto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa empresa = promotor.getEmpresa();
            if (empresa != null) {
                empresa = em.getReference(empresa.getClass(), empresa.getId());
                promotor.setEmpresa(empresa);
            }
            LinkedList<Proyecto> attachedProyectos = new LinkedList<Proyecto>();
            for (Proyecto proyectosProyectoToAttach : promotor.getProyectos()) {
                proyectosProyectoToAttach = em.getReference(proyectosProyectoToAttach.getClass(), proyectosProyectoToAttach.getId());
                attachedProyectos.add(proyectosProyectoToAttach);
            }
            promotor.setProyectos(attachedProyectos);
            em.persist(promotor);
            if (empresa != null) {
                empresa.getEmpleados().add(promotor);
                empresa = em.merge(empresa);
            }
            for (Proyecto proyectosProyecto : promotor.getProyectos()) {
                Promotor oldPromotorOfProyectosProyecto = proyectosProyecto.getPromotor();
                proyectosProyecto.setPromotor(promotor);
                proyectosProyecto = em.merge(proyectosProyecto);
                if (oldPromotorOfProyectosProyecto != null) {
                    oldPromotorOfProyectosProyecto.getProyectos().remove(proyectosProyecto);
                    oldPromotorOfProyectosProyecto = em.merge(oldPromotorOfProyectosProyecto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Promotor promotor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Promotor persistentPromotor = em.find(Promotor.class, promotor.getId());
            Empresa empresaOld = persistentPromotor.getEmpresa();
            Empresa empresaNew = promotor.getEmpresa();
            LinkedList<Proyecto> proyectosOld = persistentPromotor.getProyectos();
            LinkedList<Proyecto> proyectosNew = promotor.getProyectos();
            if (empresaNew != null) {
                empresaNew = em.getReference(empresaNew.getClass(), empresaNew.getId());
                promotor.setEmpresa(empresaNew);
            }
            LinkedList<Proyecto> attachedProyectosNew = new LinkedList<Proyecto>();
            for (Proyecto proyectosNewProyectoToAttach : proyectosNew) {
                proyectosNewProyectoToAttach = em.getReference(proyectosNewProyectoToAttach.getClass(), proyectosNewProyectoToAttach.getId());
                attachedProyectosNew.add(proyectosNewProyectoToAttach);
            }
            proyectosNew = attachedProyectosNew;
            promotor.setProyectos(proyectosNew);
            promotor = em.merge(promotor);
            if (empresaOld != null && !empresaOld.equals(empresaNew)) {
                empresaOld.getEmpleados().remove(promotor);
                empresaOld = em.merge(empresaOld);
            }
            if (empresaNew != null && !empresaNew.equals(empresaOld)) {
                empresaNew.getEmpleados().add(promotor);
                empresaNew = em.merge(empresaNew);
            }
            for (Proyecto proyectosOldProyecto : proyectosOld) {
                if (!proyectosNew.contains(proyectosOldProyecto)) {
                    proyectosOldProyecto.setPromotor(null);
                    proyectosOldProyecto = em.merge(proyectosOldProyecto);
                }
            }
            for (Proyecto proyectosNewProyecto : proyectosNew) {
                if (!proyectosOld.contains(proyectosNewProyecto)) {
                    Promotor oldPromotorOfProyectosNewProyecto = proyectosNewProyecto.getPromotor();
                    proyectosNewProyecto.setPromotor(promotor);
                    proyectosNewProyecto = em.merge(proyectosNewProyecto);
                    if (oldPromotorOfProyectosNewProyecto != null && !oldPromotorOfProyectosNewProyecto.equals(promotor)) {
                        oldPromotorOfProyectosNewProyecto.getProyectos().remove(proyectosNewProyecto);
                        oldPromotorOfProyectosNewProyecto = em.merge(oldPromotorOfProyectosNewProyecto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = promotor.getId();
                if (findPromotor(id) == null) {
                    throw new NonexistentEntityException("The promotor with id " + id + " no longer exists.");
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
            Promotor promotor;
            try {
                promotor = em.getReference(Promotor.class, id);
                promotor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The promotor with id " + id + " no longer exists.", enfe);
            }
            Empresa empresa = promotor.getEmpresa();
            if (empresa != null) {
                empresa.getEmpleados().remove(promotor);
                empresa = em.merge(empresa);
            }
            LinkedList<Proyecto> proyectos = promotor.getProyectos();
            for (Proyecto proyectosProyecto : proyectos) {
                proyectosProyecto.setPromotor(null);
                proyectosProyecto = em.merge(proyectosProyecto);
            }
            em.remove(promotor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Promotor> findPromotorEntities() {
        return findPromotorEntities(true, -1, -1);
    }

    public List<Promotor> findPromotorEntities(int maxResults, int firstResult) {
        return findPromotorEntities(false, maxResults, firstResult);
    }

    private List<Promotor> findPromotorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Promotor.class));
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

    public Promotor findPromotor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Promotor.class, id);
        } finally {
            em.close();
        }
    }

    public int getPromotorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Promotor> rt = cq.from(Promotor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
