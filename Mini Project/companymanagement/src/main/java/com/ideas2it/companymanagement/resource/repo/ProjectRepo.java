package com.ideas2it.companymanagement.resource.repo;

import com.ideas2it.companymanagement.resource.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
