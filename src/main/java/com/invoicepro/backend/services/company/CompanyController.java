package com.invoicepro.backend.services.company;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany() {
        List<Company> companys = service.getAllCompany();
        return ResponseEntity.ok(companys);
    }

    @GetMapping("/{company_id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long company_id) {
        Company company = this.service.getCompanyById(company_id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found with id: " + company_id));
        return ResponseEntity.ok(company);
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company savedCompany = this.service.saveCompany(company);

        return ResponseEntity.created(null).body(savedCompany);
    }

    @PutMapping("/{company_id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long company_id, @RequestBody Company companyInfo) {
        Company company = getCompanyById(company_id).getBody();
        BeanUtils.copyProperties(companyInfo, company);
        Company updatedCompany = service.saveCompany(company);
        return ResponseEntity.ok(updatedCompany);
    }

    @DeleteMapping("/{company_id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long company_id) {
        if (!service.existsById(company_id)) {
            return ResponseEntity.notFound().build(); // Return 404 Not Found
        }

        service.deleteById(company_id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
