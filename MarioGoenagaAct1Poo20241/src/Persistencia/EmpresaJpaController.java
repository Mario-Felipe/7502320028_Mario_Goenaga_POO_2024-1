package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Dominio.Empleado;
import Dominio.Empresa;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpresaJpaController implements Serializable {

    public EmpresaJpaController() {
        emf = Persistence.createEntityManagerFactory("MarioGoenagaAct1Poo20241PU");
    }
    
    public EmpresaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresa empresa) {
        if (empresa.getEmpleados() == null) {
            empresa.setEmpleados(new LinkedList<Empleado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LinkedList<Empleado> attachedEmpleados = new LinkedList<Empleado>();
            for (Empleado empleadosEmpleadoToAttach : empresa.getEmpleados()) {
                empleadosEmpleadoToAttach = em.getReference(empleadosEmpleadoToAttach.getClass(), empleadosEmpleadoToAttach.getId());
                attachedEmpleados.add(empleadosEmpleadoToAttach);
            }
            empresa.setEmpleados(attachedEmpleados);
            em.persist(empresa);
            for (Empleado empleadosEmpleado : empresa.getEmpleados()) {
                Empresa oldEmpresaOfEmpleadosEmpleado = empleadosEmpleado.getEmpresa();
                empleadosEmpleado.setEmpresa(empresa);
                empleadosEmpleado = em.merge(empleadosEmpleado);
                if (oldEmpresaOfEmpleadosEmpleado != null) {
                    oldEmpresaOfEmpleadosEmpleado.getEmpleados().remove(empleadosEmpleado);
                    oldEmpresaOfEmpleadosEmpleado = em.merge(oldEmpresaOfEmpleadosEmpleado);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresa empresa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa persistentEmpresa = em.find(Empresa.class, empresa.getId());
            LinkedList<Empleado> empleadosOld = persistentEmpresa.getEmpleados();
            LinkedList<Empleado> empleadosNew = empresa.getEmpleados();
            LinkedList<Empleado> attachedEmpleadosNew = new LinkedList<Empleado>();
            for (Empleado empleadosNewEmpleadoToAttach : empleadosNew) {
                empleadosNewEmpleadoToAttach = em.getReference(empleadosNewEmpleadoToAttach.getClass(), empleadosNewEmpleadoToAttach.getId());
                attachedEmpleadosNew.add(empleadosNewEmpleadoToAttach);
            }
            empleadosNew = attachedEmpleadosNew;
            empresa.setEmpleados(empleadosNew);
            empresa = em.merge(empresa);
            for (Empleado empleadosOldEmpleado : empleadosOld) {
                if (!empleadosNew.contains(empleadosOldEmpleado)) {
                    empleadosOldEmpleado.setEmpresa(null);
                    empleadosOldEmpleado = em.merge(empleadosOldEmpleado);
                }
            }
            for (Empleado empleadosNewEmpleado : empleadosNew) {
                if (!empleadosOld.contains(empleadosNewEmpleado)) {
                    Empresa oldEmpresaOfEmpleadosNewEmpleado = empleadosNewEmpleado.getEmpresa();
                    empleadosNewEmpleado.setEmpresa(empresa);
                    empleadosNewEmpleado = em.merge(empleadosNewEmpleado);
                    if (oldEmpresaOfEmpleadosNewEmpleado != null && !oldEmpresaOfEmpleadosNewEmpleado.equals(empresa)) {
                        oldEmpresaOfEmpleadosNewEmpleado.getEmpleados().remove(empleadosNewEmpleado);
                        oldEmpresaOfEmpleadosNewEmpleado = em.merge(oldEmpresaOfEmpleadosNewEmpleado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = empresa.getId();
                if (findEmpresa(id) == null) {
                    throw new NonexistentEntityException("The empresa with id " + id + " no longer exists.");
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
            Empresa empresa;
            try {
                empresa = em.getReference(Empresa.class, id);
                empresa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresa with id " + id + " no longer exists.", enfe);
            }
            LinkedList<Empleado> empleados = empresa.getEmpleados();
            for (Empleado empleadosEmpleado : empleados) {
                empleadosEmpleado.setEmpresa(null);
                empleadosEmpleado = em.merge(empleadosEmpleado);
            }
            em.remove(empresa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresa> findEmpresaEntities() {
        return findEmpresaEntities(true, -1, -1);
    }

    public List<Empresa> findEmpresaEntities(int maxResults, int firstResult) {
        return findEmpresaEntities(false, maxResults, firstResult);
    }

    private List<Empresa> findEmpresaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresa.class));
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

    public Empresa findEmpresa(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresa.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresa> rt = cq.from(Empresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
