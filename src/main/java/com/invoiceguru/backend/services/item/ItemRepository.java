package com.invoiceguru.backend.services.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    public List<Item> findByCompanyId(Long companyId);
}
