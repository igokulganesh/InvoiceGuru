package com.invoicepro.backend.services.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/company/{companyId}/Item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(@PathVariable Long companyId) {
        List<Item> items = itemService.getAllItemByCompanyId(companyId);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable Long companyId, @PathVariable Long itemId) {
        Item item = itemService.getItemById(companyId, itemId);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@PathVariable Long companyId, @RequestBody Item item) {
        Item savedItem = itemService.createItem(companyId, item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Item> updateItem(
            @PathVariable Long companyId, @PathVariable Long itemId, @RequestBody Item itemInfo) {
        Item updatedItem = itemService.updateItem(companyId, itemId, itemInfo);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable Long companyId, @PathVariable Long itemId) {
        itemService.deleteItem(companyId, itemId);
        return ResponseEntity.noContent().build();
    }
}
