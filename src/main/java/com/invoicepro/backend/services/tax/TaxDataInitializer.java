package com.invoicepro.backend.services.tax;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class TaxDataInitializer {
    private final TaxRepository repository;

    public TaxDataInitializer(TaxRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        if (repository.count() == 0) {
            repository.save(new Tax("GST-0", new BigDecimal(0)));
            repository.save(new Tax("GST-5", new BigDecimal(5)));
            repository.save(new Tax("GST-12", new BigDecimal(12)));
            repository.save(new Tax("GST-18", new BigDecimal(18)));
            repository.save(new Tax("GST-28", new BigDecimal(28)));
            repository.save(new Tax("IGST-0", new BigDecimal(0)));
            repository.save(new Tax("IGST-5", new BigDecimal(5)));
            repository.save(new Tax("IGST-12", new BigDecimal(12)));
            repository.save(new Tax("IGST-18", new BigDecimal(18)));
            repository.save(new Tax("IGST-28", new BigDecimal(28)));
            repository.save(new Tax("Excempt-GST-0", new BigDecimal(0)));
            repository.save(new Tax("Excempt-IGST-0", new BigDecimal(0)));
        }
    }
}
