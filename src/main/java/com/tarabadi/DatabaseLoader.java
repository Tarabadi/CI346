package com.tarabadi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by Matt on 01/05/2017.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EmployeeRepository employees;
    private final ManagerRepository managers;
//    private final DayRepository days;

    @Autowired
    public DatabaseLoader(EmployeeRepository employeeRepository,
                          ManagerRepository managerRepository) {

        this.employees = employeeRepository;
        this.managers = managerRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Manager admin = this.managers.save(new Manager("admin", "pass",
                "ROLE_MANAGER", "ROLE_USER"));


        Manager user = this.managers.save(new Manager("user", "pass",
                "ROLE_USER"));

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken("admin", "doesn't matter",
                        AuthorityUtils.createAuthorityList("ROLE_MANAGER")));

        this.employees.save(new Employee("Monday","Jim", "Mike", "Charlie", admin));
        this.employees.save(new Employee("Tuesday","Connor", "John", "Adam", admin));
        this.employees.save(new Employee("Wednesday","Mike", "Alex", "Joe", admin));
        this.employees.save(new Employee("Thursday","Alex", "Jim", "Will", admin));
        this.employees.save(new Employee("Friday","Dan", "John", "Charlie", admin));
        this.employees.save(new Employee("Saturday","Dan", "Liam", "Connor", admin));
        this.employees.save(new Employee("Sunday", "Cameron", "Alex", "Dan", admin));

        SecurityContextHolder.clearContext();
    }
}