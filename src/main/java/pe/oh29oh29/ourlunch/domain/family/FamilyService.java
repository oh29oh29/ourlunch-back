package pe.oh29oh29.ourlunch.domain.family;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.domain.company.CompanyRepository;
import pe.oh29oh29.ourlunch.domain.company.CompanyService;
import pe.oh29oh29.ourlunch.domain.family.dto.RequestDTO;
import pe.oh29oh29.ourlunch.domain.member.MemberRepository;
import pe.oh29oh29.ourlunch.domain.member.MemberService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FamilyService {

    private final FamilyRepository familyRepository;

    private final CompanyService companyService;

    private final MemberService memberService;

    @Value("${ourlunch.url}")
    private String ourlunchUrl;

    public Family createFamily(RequestDTO.FamilyCreationRequest request) {

        companyService.addCompany(request);

        return null;
    }

    private String generateFamilyLinkUrl() {
        return (UUID.randomUUID().toString().toUpperCase() + UUID.randomUUID().toString().toUpperCase()).replaceAll("-", "");
    }

}
