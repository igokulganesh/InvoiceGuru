package com.invoicepro.backend.services.unit;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class UnitDataInitializer {
    private final UnitRepository repository;

    public UnitDataInitializer(UnitRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        if (repository.count() == 0) {
            repository.save(new Unit("Unit", true));
            repository.save(new Unit("Kg", false));
            repository.save(new Unit("Meter", false));
            repository.save(new Unit("Hour", false));
            repository.save(new Unit("Day", false));
            repository.save(new Unit("Litre", false));
        }
    }
}
