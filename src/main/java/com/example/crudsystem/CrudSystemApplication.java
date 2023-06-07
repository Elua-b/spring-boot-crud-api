package com.example.crudsystem;

import com.example.crudsystem.employee.Employee;
import com.example.crudsystem.repostories.EmployeeRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudSystemApplication.class, args);
	}

    @Autowired
    private EmployeeRepostory employeeRepostory;
    @Override
    public void run(String... args) throws Exception {
        Employee employee=new Employee();
        employee.setFirstname("Eloi");
        employee.setLastname("BUGINGO");
        employee.setAddress("Nyamirambo");
        employee.setPhonenumber("0788420127");
        employeeRepostory.save(employee);
        Employee employee1=new Employee();
        employee1.setFirstname("mpac");
        employee1.setLastname("mupakizi");
        employee1.setAddress("Gatsibo");
        employee1.setPhonenumber("0788420127");
        employeeRepostory.save(employee1);
    }
}
