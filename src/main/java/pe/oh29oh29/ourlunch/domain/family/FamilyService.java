package pe.oh29oh29.ourlunch.domain.family;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.oh29oh29.ourlunch.domain.company.Company;
import pe.oh29oh29.ourlunch.domain.company.CompanyService;

import java.util.UUID;

@RequiredArgsConstructor

@Service
@Transactional
public class FamilyService {

    private final FamilyRepository familyRepository;
    private final CompanyService companyService;

    @Value("${ourlunch.url}")
    private String ourlunchUrl;

    Family createFamily(final String companyName,
                        final String familyName) {
        final Company company = companyService.addCompany(companyName);
        final Family family = familyRepository.save(Family.of(company, familyName, generateFamilyLinkUrl()));
        family.setLinkUrl(ourlunchUrl + family.getLinkUrl());
        return family;
    }

    private String generateFamilyLinkUrl() {
        return (UUID.randomUUID().toString().toUpperCase() + UUID.randomUUID().toString().toUpperCase()).replaceAll("-", "");
    }

}
