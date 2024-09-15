package com.invoicepro.backend.services.item;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicepro.backend.exceptions.ResourceNotFoundException;
import com.invoicepro.backend.exceptions.UnauthorizedException;
import com.invoicepro.backend.services.company.Company;
import com.invoicepro.backend.services.company.CompanyRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public List<Item> getAllItemByCompanyId(Long companyId) {
        return itemRepository.findByCompanyId(companyId);
    }

    public Item getItemById(Long companyId, Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with ID: " + itemId));

        if (!item.getCompany().getId().equals(companyId))
            throw new UnauthorizedException("Not authorized to view this item");

        return item;
    }

    public Item createItem(Long companyId, Item item) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with ID " + companyId));

        item.setCompany(company);
        return itemRepository.save(item);
    }

    public Item updateItem(Long companyId, Long itemId, Item itemInfo) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with ID " + itemId));

        if (!item.getCompany().getId().equals(companyId))
            throw new UnauthorizedException("Not authorized to update this item");

        if (!item.getId().equals(itemId))
            throw new RuntimeException("Illegal Operations");

        BeanUtils.copyProperties(itemInfo, item);
        return itemRepository.save(item);
    }

    public void deleteItem(Long companyId, Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with ID " + itemId));

        if (!item.getCompany().getId().equals(companyId))
            throw new UnauthorizedException("Not authorized to update this item");

        itemRepository.delete(item);
    }
}
