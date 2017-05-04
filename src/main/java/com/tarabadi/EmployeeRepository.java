package com.tarabadi;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by Matt on 01/05/2017.
 */
@PreAuthorize("hasRole('ROLE_USER')")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    Employee save(@Param("employee") Employee employee);

    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    void delete(@Param("employee") Employee employee);

}