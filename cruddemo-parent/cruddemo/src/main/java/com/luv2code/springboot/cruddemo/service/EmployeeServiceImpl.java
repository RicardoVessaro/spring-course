package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;

/*
    @Deprecated because we are using Spring Data REST
    Commenting @@Service to not use this class anymore
 */
@Deprecated
//@Service // Indicates to Spring that is a Service. Spring finds the service through component scan
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isPresent()) {
            theEmployee = result.get();;

        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }
    // Removed @Transaction since JpaRepository provides this functionality
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
