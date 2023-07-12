package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    @RepositoryRestResource: Defines the path to the REST endpoint.
        Useful for custom paths or irregular plurals.
    In this example the custom path is "members".
 */
//@RepositoryRestResource(path="members")
// Spring JpaRepository is a boiler plate of the DAO, it gives us the common CRUD methods.
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

}
