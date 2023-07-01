package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
    The DAO (Data Access Object) is the helper class of our application to handle data logic, like persistence,
    transaction, and search.
    The DAO uses the Spring Entity Manager to connect to the database. The Entity Manager uses a datasource to connect
    and to manage the database in our application. This datasource is defined in our application.properties file.
 */
/*
    @Repository: Specialized annotation for repositories,
    supports component scanning and translates JDBC exceptions.
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired // optional because have only one constructor
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    /*
        @Transactional: Handle the transactional management
            while we are performing an update (persisting).
     */
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    // No need to add @Transactional since we are only reading data
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }
}
