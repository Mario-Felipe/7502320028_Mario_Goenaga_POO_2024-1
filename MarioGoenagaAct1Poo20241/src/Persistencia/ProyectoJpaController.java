package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Dominio.Promotor;
import Dominio.Proyecto;
import Dominio.Tarea;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProyectoJpaController implements Serializable {

    public ProyectoJpaController() {
        emf = Persistence.createEntityManagerFactory("MarioGoenagaAct1Poo20241PU");
    }
    
    public ProyectoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proyecto proyecto) {
        if (proyecto.getTareas() == null) {
            proyecto.setTareas(new LinkedList<Tarea>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Promotor promotor = proyecto.getPromotor();
            if (promotor != null) {
                promotor = em.getReference(promotor.getClass(), promotor.getId());
                proyecto.setPromotor(promotor);
            }
            LinkedList<Tarea> attachedTareas = new LinkedList<Tarea>();
            for (Tarea tareasTareaToAttach : proyecto.getTareas()) {
                tareasTareaToAttach = em.getReference(tareasTareaToAttach.getClass(), tareasTareaToAttach.getId());
                attachedTareas.add(tareasTareaToAttach);
            }
            proyecto.setTareas(attachedTareas);
            em.persist(proyecto);
            if (promotor != null) {
                promotor.getProyectos().add(proyecto);
                promotor = em.merge(promotor);
            }
            for (Tarea tareasTarea : proyecto.getTareas()) {
                Proyecto oldProyectoOfTareasTarea = tareasTarea.getProyecto();
                tareasTarea.setProyecto(proyecto);
                tareasTarea = em.merge(tareasTarea);
                if (oldProyectoOfTareasTarea != null) {
                    oldProyectoOfTareasTarea.getTareas().remove(tareasTarea);
                    oldProyectoOfTareasTarea = em.merge(oldProyectoOfTareasTarea);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proyecto proyecto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyecto persistentProyecto = em.find(Proyecto.class, proyecto.getId());
            Promotor promotorOld = persistentProyecto.getPromotor();
            Promotor promotorNew = proyecto.getPromotor();
            LinkedList<Tarea> tareasOld = persistentProyecto.getTareas();
            LinkedList<Tarea> tareasNew = proyecto.getTareas();
            if (promotorNew != null) {
                promotorNew = em.getReference(promotorNew.getClass(), promotorNew.getId());
                proyecto.setPromotor(promotorNew);
            }
            LinkedList<Tarea> attachedTareasNew = new LinkedList<Tarea>();
            for (Tarea tareasNewTareaToAttach : tareasNew) {
                tareasNewTareaToAttach = em.getReference(tareasNewTareaToAttach.getClass(), tareasNewTareaToAttach.getId());
                attachedTareasNew.add(tareasNewTareaToAttach);
            }
            tareasNew = attachedTareasNew;
            proyecto.setTareas(tareasNew);
            proyecto = em.merge(proyecto);
            if (promotorOld != null && !promotorOld.equals(promotorNew)) {
                promotorOld.getProyectos().remove(proyecto);
                promotorOld = em.merge(promotorOld);
            }
            if (promotorNew != null && !promotorNew.equals(promotorOld)) {
                promotorNew.getProyectos().add(proyecto);
                promotorNew = em.merge(promotorNew);
            }
            for (Tarea tareasOldTarea : tareasOld) {
                if (!tareasNew.contains(tareasOldTarea)) {
                    tareasOldTarea.setProyecto(null);
                    tareasOldTarea = em.merge(tareasOldTarea);
                }
            }
            for (Tarea tareasNewTarea : tareasNew) {
                if (!tareasOld.contains(tareasNewTarea)) {
                    Proyecto oldProyectoOfTareasNewTarea = tareasNewTarea.getProyecto();
                    tareasNewTarea.setProyecto(proyecto);
                    tareasNewTarea = em.merge(tareasNewTarea);
                    if (oldProyectoOfTareasNewTarea != null && !oldProyectoOfTareasNewTarea.equals(proyecto)) {
                        oldProyectoOfTareasNewTarea.getTareas().remove(tareasNewTarea);
                        oldProyectoOfTareasNewTarea = em.merge(oldProyectoOfTareasNewTarea);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = proyecto.getId();
                if (findProyecto(id) == null) {
                    throw new NonexistentEntityException("The proyecto with id " + id + " no longer exists.");
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
            Proyecto proyecto;
            try {
                proyecto = em.getReference(Proyecto.class, id);
                proyecto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proyecto with id " + id + " no longer exists.", enfe);
            }
            Promotor promotor = proyecto.getPromotor();
            if (promotor != null) {
                promotor.getProyectos().remove(proyecto);
                promotor = em.merge(promotor);
            }
            LinkedList<Tarea> tareas = proyecto.getTareas();
            for (Tarea tareasTarea : tareas) {
                tareasTarea.setProyecto(null);
                tareasTarea = em.merge(tareasTarea);
            }
            em.remove(proyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proyecto> findProyectoEntities() {
        return findProyectoEntities(true, -1, -1);
    }

    public List<Proyecto> findProyectoEntities(int maxResults, int firstResult) {
        return findProyectoEntities(false, maxResults, firstResult);
    }

    private List<Proyecto> findProyectoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proyecto.class));
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

    public Proyecto findProyecto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proyecto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProyectoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proyecto> rt = cq.from(Proyecto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
