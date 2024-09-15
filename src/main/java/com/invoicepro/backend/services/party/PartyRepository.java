package com.invoicepro.backend.services.party;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {
    List<Party> findByCompanyId(Long companyId);
}
