package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.oh29oh29.ourlunch.domain.company.Company;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.domain.family.FamilyRepository;
import pe.oh29oh29.ourlunch.domain.member.Member;
import pe.oh29oh29.ourlunch.domain.member.MemberRepository;

import java.util.UUID;

@RequiredArgsConstructor

@Service
public class FamilyCommandService {

    private final FamilyRepository familyRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Family createFamily(
            String familyName,
            Company company
    ) {
        return familyRepository.save(
                new Family(
                        company,
                        familyName,
                        generateFamilyCode()
                )
        );
    }

    private String generateFamilyCode() {
        return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }

    @Transactional
    public void join(
            String familyCode,
            String id,
            String name,
            String appetite
    ) throws Exception {
        // TODO 점심팸 또는 사용자 정보가 존재하지 않았을 경우에 대한 처리 필요
        final Family family = familyRepository.findByCode(familyCode).orElseThrow(Exception::new);
        final Member member = memberRepository.findById(id).orElseThrow(Exception::new);
        member.setName(name);
        member.setAppetite(appetite);
        member.setFamily(family);
    }
}
