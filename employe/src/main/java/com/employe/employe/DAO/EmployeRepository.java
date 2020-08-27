package com.employe.employe.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.employe.employe.entity.EmployeEntity;
@EnableJpaRepositories("com.employe.employe.DAO")
public interface EmployeRepository extends JpaRepository<EmployeEntity, Long> {

}
