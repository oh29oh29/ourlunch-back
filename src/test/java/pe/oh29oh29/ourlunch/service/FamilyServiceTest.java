package pe.oh29oh29.ourlunch.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pe.oh29oh29.ourlunch.TestSupport;
import pe.oh29oh29.ourlunch.entity.Company;
import pe.oh29oh29.ourlunch.entity.Family;
import pe.oh29oh29.ourlunch.entity.FamilyMembers;
import pe.oh29oh29.ourlunch.entity.Member;
import pe.oh29oh29.ourlunch.repository.CompanyRepository;
import pe.oh29oh29.ourlunch.repository.FamilyMemberRepository;
import pe.oh29oh29.ourlunch.repository.FamilyRepository;
import pe.oh29oh29.ourlunch.repository.MemberRepository;
import pe.oh29oh29.ourlunch.util.DateUtil;

import static org.junit.Assert.*;

public class FamilyServiceTest extends TestSupport {

    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    FamilyMemberRepository familyMemberRepository;

    @Before
    public void setUp() {

    }

    @Test
    public void 점심팸_생성_테스트() {
        Company company = new Company("회사명_01");
        Member member = new Member("id_01", "password_01", DateUtil.now());
        Family family = new Family(company, "점심팸이름_01", "http://test.com", DateUtil.now());
        FamilyMembers familyMembers = new FamilyMembers(family, member, "멤버이름_01", true, DateUtil.now());

        family.setCompany(company);

        familyMembers.setFamily(family);
        familyMembers.setMember(member);

        Member createdMember = memberRepository.save(member);
        Company createdCompany = companyRepository.save(company);
        Family createdFamily = familyRepository.save(family);
        FamilyMembers createdFamilyMembers = familyMemberRepository.save(familyMembers);

        assertEquals(member.getId(), createdMember.getId());
        assertEquals(member.getPassword(), createdMember.getPassword());
        assertEquals(member.getSignUpDate(), createdMember.getSignUpDate());
        assertEquals(company.getName(), createdCompany.getName());
        assertEquals(family.getName(), createdFamily.getName());
        assertEquals(family.getLinkUrl(), createdFamily.getLinkUrl());
        assertEquals(family.getCreateDate(), createdFamily.getCreateDate());
        assertEquals(familyMembers.getName(), createdFamilyMembers.getName());
        assertEquals(familyMembers.isMaster(), createdFamilyMembers.isMaster());
        assertEquals(familyMembers.getJoinDate(), createdFamilyMembers.getJoinDate());

    }
}
