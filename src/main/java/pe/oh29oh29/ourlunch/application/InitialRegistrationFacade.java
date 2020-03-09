package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pe.oh29oh29.ourlunch.domain.company.Company;
import pe.oh29oh29.ourlunch.domain.family.Family;

@RequiredArgsConstructor

@Component
public class InitialRegistrationFacade {

    private final FamilyCommandService familyCommandService;
    private final CompanyQueryService companyQueryService;
    private final MemberCommandService memberCommandService;

    @Value("${ourlunch.url}")
    private String ourlunchUrl;

    @Transactional
    public Family regist(
            String userId,
            String userName,
            String appetite,
            String companyName,
            String familyName
    ) {
        final Company company = companyQueryService.findByNameOrSave(companyName);
        final Family family = familyCommandService.createFamily(familyName, company);
        memberCommandService.updateFamilyWithMaster(userId, userName, appetite, family);

        return family;
    }

}