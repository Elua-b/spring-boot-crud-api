package com.example.crudsystem.repostories;

import com.example.crudsystem.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface EmployeeRepostory extends JpaRepository<Employee, String> {
    @Query("SELECT t FROM employees  t WHERE t.firstname= ?1 ")
    Optional<Employee> findByName(String firstname);
//    public Optional<Employee> findById(UUID uuid);

}
