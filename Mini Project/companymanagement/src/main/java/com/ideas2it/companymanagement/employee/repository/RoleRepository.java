package com.ideas2it.companymanagement.employee.repository;

import com.ideas2it.companymanagement.employee.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
