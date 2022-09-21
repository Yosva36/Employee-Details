package com.ideas2it.employeedetails.dao.impl;

import com.ideas2it.employeedetails.entity.Trainee;
import com.ideas2it.employeedetails.entity.Trainer;
import org.apache.log4j.Logger;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import javax.persistence.TypedQuery;

import com.ideas2it.employeedetails.dao.TraineeDao;

import java.util.List;

/**
 * Deals with employee database and related operations.
 */
public class TraineeDaoImpl implements TraineeDao {
    Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Trainee.class).addAnnotatedClass(Trainer.class);
    StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
    SessionFactory sessionFactory = config.buildSessionFactory(reg.build());
    private final Logger logger = Logger.getLogger(TraineeDaoImpl.class);

    /**
     * Insert the trainee details into database.
     * @param trainee
     */
    public void insertTrainee(Trainee trainee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(trainee);
            transaction.commit();
        } catch (HibernateException hibernateException) {
            logger.error("Process Failed",hibernateException);
        }
    }

    /*
     *
     * Retrieve all trainee details from database.
     * @return List<Trainee>
     */
    public List<Trainee> retrieveTrainees() {
        List<Trainee> trainees = null;
        try(Session session = sessionFactory.openSession();) {
            trainees = session.createQuery("FROM Trainee").list();
            return trainees;
        } catch (HibernateException hibernateException) {
            logger.error("process failed");
        }
        return trainees;
    }

    /**
     * Retrieve a trainee details from database by trainee Id.
     * @param traineeId
     * @return trainee
     */
    public Trainee searchTrainee(String traineeId) {
        Trainee trainee = null;
        try (Session session = sessionFactory.openSession()) {
            TypedQuery query = session.createQuery("From Trainee e where e.traineeId = :a");
            query.setParameter("a", traineeId);
            trainee = (Trainee) query.getSingleResult();
            return trainee;
        } catch (HibernateException hibernateException) {
            logger.error("Process failed",hibernateException);
        }
        return trainee;
    }

    /**
     * Delete a trainee details from database.
     * @param trainee
     * @return boolean
     */
    public boolean deleteTrainee(Trainee trainee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(trainee);
            transaction.commit();
            return true;
        } catch (HibernateException hibernateException) {
            logger.error("Process failed",hibernateException);
        }
        return false;
    }

    /**
     *
     * Update a trainee details from database. 
     *
     * @param trainee
     *
     */
    public void updateTrainee(Trainee trainee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(trainee);
            transaction.commit();
        } catch (HibernateException hibernateException) {
            logger.error("process failed",hibernateException);
        }
    }
}

   
        

    