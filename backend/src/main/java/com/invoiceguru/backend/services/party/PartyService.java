package com.invoiceguru.backend.services.party;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoiceguru.backend.exceptions.ResourceNotFoundException;
import com.invoiceguru.backend.exceptions.UnauthorizedException;
import com.invoiceguru.backend.services.company.Company;
import com.invoiceguru.backend.services.company.CompanyRepository;

@Service
public class PartyService {
    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public List<Party> getAllPartyByCompanyId(Long companyId) {
        return partyRepository.findByCompanyId(companyId);
    }

    public Party getPartyById(Long companyId, Long partyId) {
        Party party = partyRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party not found with ID: " + partyId));

        if (!party.getCompany().getId().equals(companyId)) {
            throw new UnauthorizedException("Not authorized to view this party");
        }

        return party;
    }

    public Party createParty(Long companyId, Party party) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + companyId));

        party.setCompany(company);
        return partyRepository.save(party);
    }

    public Party updateParty(Long companyId, Long partyId, Party partyInfo) {
        Party party = partyRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party not found with ID: " + partyId));

        if (!party.getCompany().getId().equals(companyId)) {
            throw new UnauthorizedException("Not authorized to update this party");
        }

        if (!party.getId().equals(partyInfo.getId())) {
            throw new RuntimeException("Illegal Action");
        }

        BeanUtils.copyProperties(partyInfo, party);
        return partyRepository.save(party);
    }

    public void deleteParty(Long companyId, Long partyId) {
        Party party = partyRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party not found with ID: " + partyId));

        if (!party.getCompany().getId().equals(companyId)) {
            throw new UnauthorizedException("Not authorized to view this party");
        }

        partyRepository.delete(party);
    }
}
