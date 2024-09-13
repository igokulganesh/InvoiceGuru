package com.invoiceguru.backend.services.party;

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
@RequestMapping("/api/company/{companyId}/party")
public class PartyController {

    @Autowired
    private PartyService partyService;

    @GetMapping
    public ResponseEntity<List<Party>> getAllParty(@PathVariable Long companyId) {
        List<Party> parties = partyService.getAllPartyByCompanyId(companyId);
        return ResponseEntity.ok(parties);
    }

    @GetMapping("/{partyId}")
    public ResponseEntity<Party> getPartyById(@PathVariable Long companyId, @PathVariable Long partyId) {
        Party party = partyService.getPartyById(companyId, partyId);
        return ResponseEntity.ok(party);
    }

    @PostMapping
    public ResponseEntity<Party> createParty(@PathVariable Long companyId, @RequestBody Party party) {
        Party createdParty = partyService.createParty(companyId, party);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParty);
    }

    @PutMapping("/{partyId}")
    public ResponseEntity<Party> updateParty(@PathVariable Long companyId, @PathVariable Long partyId,
            @RequestBody Party party) {
        Party updatedParty = partyService.updateParty(companyId, partyId, party);
        return ResponseEntity.ok(updatedParty);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteParty(@PathVariable Long companyId, @PathVariable Long partyId) {
        partyService.deleteParty(companyId, partyId);
        return ResponseEntity.noContent().build();
    }
}
