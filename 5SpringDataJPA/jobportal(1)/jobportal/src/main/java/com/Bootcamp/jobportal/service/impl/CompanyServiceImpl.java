package com.Bootcamp.jobportal.service.impl;

import com.Bootcamp.jobportal.entity.Company;
import com.Bootcamp.jobportal.repository.CompanyRepository;
import com.Bootcamp.jobportal.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }
}
