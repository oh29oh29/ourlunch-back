package pe.oh29oh29.ourlunch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.entity.Company;
import pe.oh29oh29.ourlunch.entity.Family;
import pe.oh29oh29.ourlunch.entity.FamilyMembers;
import pe.oh29oh29.ourlunch.entity.Member;
import pe.oh29oh29.ourlunch.model.RequestDTO;
import pe.oh29oh29.ourlunch.repository.CompanyRepository;
import pe.oh29oh29.ourlunch.repository.FamilyMemberRepository;
import pe.oh29oh29.ourlunch.repository.FamilyRepository;
import pe.oh29oh29.ourlunch.repository.MemberRepository;
import pe.oh29oh29.ourlunch.util.DateUtil;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FamilyService {

    private final FamilyRepository familyRepository;

    private final MemberRepository memberRepository;

    private final CompanyRepository companyRepository;

    private final FamilyMemberRepository familyMemberRepository;

    @Value("${ourlunch.url}")
    private String ourlunchUrl;

    public Family createFamily(RequestDTO.FamilyCreationRequest request) {

        Member member = new Member(request.getMemberId(), request.getMemberPassword(), DateUtil.now());
        Member createdMember = memberRepository.save(member);

        Company company = new Company(request.getCompanyName());
        Company createdCompany = companyRepository.save(company);

        Family family = new Family(createdCompany, request.getFamilyName(), ourlunchUrl + generateFamilyLinkUrl(), DateUtil.now());
        Family createdFamily = familyRepository.save(family);

        FamilyMembers familyMembers = new FamilyMembers(createdFamily, createdMember, request.getMemberName(), true, DateUtil.now());
        familyMemberRepository.save(familyMembers);

        return createdFamily;
    }

    private String generateFamilyLinkUrl() {
        return (UUID.randomUUID().toString().toUpperCase() + UUID.randomUUID().toString().toUpperCase()).replaceAll("-", "");
    }
}
