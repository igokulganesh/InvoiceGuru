package com.invoicepro.backend.services.company;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> getAllCompany() {
        return repository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return repository.findById(id);
    }

    public Company saveCompany(Company company) {
        return repository.save(company);
    }

    public boolean existsById(Long company_id) {
        return repository.existsById(company_id);
    }

    public void deleteById(Long company_id) {
        repository.deleteById(company_id);
    }
}
