package com.uniminuto.ejercicio1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uniminuto.ejercicio1.entityEjb.Servicio;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class ServicioDaoImpl implements ServicioDao {

    @PersistenceContext(unitName = "movie-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

//    public List findAllServicios() {
//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.openSession();
//        List employees = session.createQuery("from Servicio ").list();
//        session.close();
//        return employees;
//    }
//
//    public Servicio findById(int id) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Servicio> cq = cb.createQuery(Servicio.class);
//        Root<Servicio> model = cq.from(Servicio.class);
//        cq.where(cb.equal(model.get("id"), id));
//        TypedQuery<Servicio> q = em.createQuery(cq);
//        return q.getSingleResult();
//    }

    public Long insert(Servicio servicio) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        Long servicioID = null;
        try {
            tx = session.beginTransaction();
            servicioID = (Long) session.save(servicio);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return servicioID;
    }
    
     public boolean delete(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
		Servicio p = (Servicio) session.load(Servicio.class, new Long(id));
		if(null != p){
			session.delete(p);
		}

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

}
