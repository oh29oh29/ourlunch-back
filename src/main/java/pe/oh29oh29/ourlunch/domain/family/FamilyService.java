package pe.oh29oh29.ourlunch.domain.family;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.oh29oh29.ourlunch.domain.company.Company;
import pe.oh29oh29.ourlunch.domain.company.CompanyRepository;
import pe.oh29oh29.ourlunch.domain.member.Member;
import pe.oh29oh29.ourlunch.domain.member.MemberRepository;

import java.util.UUID;

@RequiredArgsConstructor

@Service
@Transactional
public class FamilyService {

    private final FamilyRepository familyRepository;
    private final CompanyRepository companyRepository;
    private final MemberRepository memberRepository;

    @Value("${ourlunch.url}")
    private String ourlunchUrl;

    @Transactional
    Family createFamily(final String userId,
                        final String companyName,
                        final String familyName) {

        Company company = companyRepository.findByName(companyName);

        if (company == null) {
            company = companyRepository.save(Company.of(companyName));
        }

        final Family family = familyRepository.save(Family.of(company, familyName, generateFamilyLinkUrl()));
        family.setLinkUrl(ourlunchUrl + family.getLinkUrl());

        Member member = memberRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        member.setFamily(family);
        member.setMaster(true);

        return family;
    }

    private String generateFamilyLinkUrl() {
        return (UUID.randomUUID().toString().toUpperCase() + UUID.randomUUID().toString().toUpperCase()).replaceAll("-", "");
    }

}
