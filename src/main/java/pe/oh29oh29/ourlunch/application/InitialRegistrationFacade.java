package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pe.oh29oh29.ourlunch.domain.company.Company;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.model.Response;

@RequiredArgsConstructor

@Component
public class InitialRegistrationFacade {

    private final FamilyCommandService familyCommandService;
    private final CompanyCommandService companyCommandService;
    private final MemberCommandService memberCommandService;

    @Value("${ourlunch.url}")
    private String ourlunchUrl;

    public Response regist(
            final String userId,
            final String companyName,
            final String familyName
    ) {
        final Company company = companyCommandService.addCompany(companyName);
        final Family family = familyCommandService.createFamily(familyName, company);
        memberCommandService.updateFamilyWithMaster(userId, family);

        return Response.ok();
    }

}
