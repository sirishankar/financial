package spsu.edu.financial.model;

// Generated Nov 15, 2013 5:46:12 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class ExpenseDetails.
 * @see spsu.edu.financial.model.ExpenseDetails
 * @author Hibernate Tools
 */
public class ExpenseDetailsHome {

	private static final Log log = LogFactory.getLog(ExpenseDetailsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ExpenseDetails transientInstance) {
		log.debug("persisting ExpenseDetails instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ExpenseDetails instance) {
		log.debug("attaching dirty ExpenseDetails instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExpenseDetails instance) {
		log.debug("attaching clean ExpenseDetails instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ExpenseDetails persistentInstance) {
		log.debug("deleting ExpenseDetails instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExpenseDetails merge(ExpenseDetails detachedInstance) {
		log.debug("merging ExpenseDetails instance");
		try {
			ExpenseDetails result = (ExpenseDetails) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ExpenseDetails findById(int id) {
		log.debug("getting ExpenseDetails instance with id: " + id);
		try {
			ExpenseDetails instance = (ExpenseDetails) sessionFactory
					.getCurrentSession().get(
							"spsu.edu.financial.model.ExpenseDetails", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ExpenseDetails instance) {
		log.debug("finding ExpenseDetails instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("spsu.edu.financial.model.ExpenseDetails")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
