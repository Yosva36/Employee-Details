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
import java.util.List;

import com.ideas2it.employeedetails.dao.TrainerDao;

/**
 * Deals with employee database and related operations
 */
public class TrainerDaoImpl implements TrainerDao {
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Trainer.class).addAnnotatedClass(Trainee.class);
    StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    SessionFactory sessionFactory = configuration.buildSessionFactory(reg.build());
    private final Logger logger = Logger.getLogger(TrainerDaoImpl.class);

    /**
     * Insert the trainer details.
     * @param trainer
     */
    public void insertTrainer(Trainer trainer) {        
        try(Session session = sessionFactory.openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(trainer);
            transaction.commit();
        } catch (HibernateException hibernateException) {
            logger.error("Process failed",hibernateException);
        } 
    }

    /**
     * Retrieve all trainer details from database.
     * @return List<Trainer>
     */
    public List<Trainer> retrieveTrainers() {
        List<Trainer> trainers = null;
        try(Session session = sessionFactory.openSession();) {
            trainers = session.createQuery("FROM Trainer").list();
            return trainers;
        } catch (HibernateException hibernateException) {
            logger.error("Process failed",hibernateException);
        }
        return trainers;
    }

    /**
     * Retrieve a trainer details from database by trainer Id.
     * @param trainerId
     * @return trainer
     */
     public Trainer searchTrainer(String trainerId) {
        Trainer trainer = null;
        try(Session session = sessionFactory.openSession();) {
            TypedQuery query = session.createQuery("From Trainer e where e.trainerId = :a");
            query.setParameter("a",trainerId);
            trainer = (Trainer) query.getSingleResult();
            return trainer;
        } catch (HibernateException hibernateException) {
            logger.error("Process failed",hibernateException);
        }
        return trainer;
    }

    /**
     * Delete a trainer details from database.
     * @param trainer
     * @return boolean
     */
    public boolean deleteTrainer(Trainer trainer) {
        try(Session session = sessionFactory.openSession();) {
            Transaction transaction = session.beginTransaction();
            session.delete(trainer);
            transaction.commit();
            return true;
        } catch (HibernateException hibernateException) {
            logger.error("Process Failed",hibernateException);
        } 
        return false;
    }

    /**
     * Update a trainer details from database.
     * @param trainer
     */
    public void updateTrainer(Trainer trainer) {
        try(Session session = sessionFactory.openSession();) {
            Transaction transaction = session.beginTransaction(); 
            session.update(trainer);
            transaction.commit();
        } catch (HibernateException hibernateException) {
            logger.error("Process Failed",hibernateException);
        } 
    }
}