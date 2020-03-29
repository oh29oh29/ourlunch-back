package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.domain.family.FamilyRepository;
import pe.oh29oh29.ourlunch.domain.member.Member;
import pe.oh29oh29.ourlunch.domain.member.MemberRepository;

import java.util.List;

@RequiredArgsConstructor

@Service
public class FamilyQueryService {

    private final FamilyRepository familyRepository;
    private final MemberRepository memberRepository;

    @Value("${ourlunch.url}")
    private String ourlunchUrl;

    public List<Member> getMembers(String familyId) {
        final Family family = familyRepository
                .findById(Long.parseLong(familyId))
                .orElseThrow(IllegalArgumentException::new);

        return memberRepository.findAllByFamily(family);
    }

    public boolean existByCode(String code) {
        return familyRepository.findByCode(code).isPresent();
    }
}
