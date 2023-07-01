package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
            while we are performing an update (persisting, modifying the database).
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

    // No need to add @Transactional since we are doing a query
    @Override
    public List<Student> findAll() {

        /*
            All JPQL syntax is based on entity name and entity fields
            "Student" is the name of the JPA Entity, the class name not the table name.
            "lastName" is the field of the JPA entity.
            We are ordering students by the last name. By default, the sort is ascending (ASC) but we can order
                descending (DESC).

                "FROM Student order by lastName"
         */
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return query results
        return theQuery.getResultList();
    }

    // ":theData" is JPQL named parameter, it is prefixed with a colon :
    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
            "FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        // "theData" is the parameter
        theQuery.setParameter("theData", theLastName);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional // We are performing an update
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional // We are performing a delete
    public void delete(Integer id) {

        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional // We are perfoming a delete
    public int deleteAll() {

        /*
            'executeUpdate' method execute the query statement.
            Remember the method name "update" is a generic term, indicating we are "modifying" the database
         */
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student")
            .executeUpdate();

        return numRowsDeleted;
    }

}
