package pe.oh29oh29.ourlunch.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pe.oh29oh29.ourlunch.TestSupport;
import pe.oh29oh29.ourlunch.entity.Company;
import pe.oh29oh29.ourlunch.entity.Family;
import pe.oh29oh29.ourlunch.entity.FamilyMember;
import pe.oh29oh29.ourlunch.entity.Member;
import pe.oh29oh29.ourlunch.model.RequestDTO;
import pe.oh29oh29.ourlunch.repository.CompanyRepository;
import pe.oh29oh29.ourlunch.repository.FamilyMemberRepository;
import pe.oh29oh29.ourlunch.repository.FamilyRepository;
import pe.oh29oh29.ourlunch.repository.MemberRepository;
import pe.oh29oh29.ourlunch.util.DateUtil;

import static org.junit.Assert.*;

public class FamilyServiceTest extends TestSupport {


    @Autowired
    private FamilyService familyService;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Test
    public void 점심팸_생성_테스트() {
        Company company = new Company("회사명_01");
        Member member = new Member("id_01", "password_01", DateUtil.now());
        Family family = new Family(company, "점심팸이름_01", "http://test.com", DateUtil.now());
        FamilyMember familyMember = new FamilyMember(family, member, "멤버이름_01", true, DateUtil.now());

        familyMember.setFamily(family);
        familyMember.setMember(member);

        Member createdMember = memberRepository.save(member);
        Company createdCompany = companyRepository.save(company);
        Family createdFamily = familyRepository.save(family);
        FamilyMember createdFamilyMember = familyMemberRepository.save(familyMember);

        assertEquals(member.getId(), createdMember.getId());
        assertEquals(member.getPassword(), createdMember.getPassword());
        assertEquals(member.getSignUpDate(), createdMember.getSignUpDate());
        assertEquals(company.getName(), createdCompany.getName());
        assertEquals(family.getName(), createdFamily.getName());
        assertEquals(family.getLinkUrl(), createdFamily.getLinkUrl());
        assertEquals(family.getCreateDate(), createdFamily.getCreateDate());
        assertEquals(family.getCompany().getName(), createdFamily.getCompany().getName());
        assertEquals(familyMember.getName(), createdFamilyMember.getName());
        assertEquals(familyMember.isMaster(), createdFamilyMember.isMaster());
        assertEquals(familyMember.getJoinDate(), createdFamilyMember.getJoinDate());

    }

    @Test
    public void FamilyService_점심팸_생성_테스트() {
        RequestDTO.FamilyCreationRequest request = new RequestDTO.FamilyCreationRequest();

        request.setCompanyName("회사명_02");
        request.setFamilyName("점심팸이름_02");
        request.setMemberId("id_02");
        request.setMemberName("멤버이름_02");
        request.setMemberPassword("password_02");

        Family family = familyService.createFamily(request);

        assertNotNull(family);
    }
}
