package com.Bootcamp.jobportal.repository;

import com.Bootcamp.jobportal.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//Optional
//Spring generates the implementation at runtime using a proxy.
public interface CompanyRepository extends JpaRepository<Company, Long> {
}