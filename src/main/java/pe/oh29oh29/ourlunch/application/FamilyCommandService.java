package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.oh29oh29.ourlunch.domain.company.Company;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.domain.family.FamilyRepository;

import java.util.UUID;

@RequiredArgsConstructor

@Service
public class FamilyCommandService {

    private final FamilyRepository familyRepository;

    @Transactional
    public Family createFamily(
            final String familyName,
            final Company company
    ) {
        return familyRepository.save(
                new Family(company, familyName, generateFamilyLinkUrl())
        );
    }

    private String generateFamilyLinkUrl() {
        return (UUID.randomUUID().toString().toUpperCase() + UUID.randomUUID().toString().toUpperCase()).replaceAll("-", "");
    }

}
